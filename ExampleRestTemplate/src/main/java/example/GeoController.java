package example;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class GeoController {
private String osmUrl;

    @RequestMapping("/getosm")
    public String getOsmRespone (@RequestParam(value = "name", defaultValue = "Самарская область") String name) {
        osmUrl = "http://nominatim.openstreetmap.org/search?state=" + name
                + "&country=russia&format=json&polygon_geojson=1";
        /*для примера*/ String url = "https://nominatim.openstreetmap.org/search?state=%D0%A1%D0%B0%D0%BC%D0%B0%D1%80%D1%81%D0%BA%D0%B0%D1%8F%20%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C&country=russia&format=json&polygon_geojson=1"; //тут можно через targetURL и urlParameters


        ResponseEntity<List<OsmResponse>> responseEntity =
                new RestTemplate().exchange(
                                url,
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<List<OsmResponse>>() { }
                );
        List<OsmResponse> osmResponseList = responseEntity.getBody();
        System.out.println(responseEntity.toString());
        System.out.println(osmResponseList);
        return "success";  //заглушка для примера
    }

}
