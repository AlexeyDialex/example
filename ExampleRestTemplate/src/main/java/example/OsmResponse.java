package example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OsmResponse {
    private String display_name;
    private Geojson geojson;

    public String getDisplay_name() {
        return display_name;
    }

    public Geojson getGeojson() {
        return geojson;
    }
}


/*
Format of response from API OSM:

[
    {id: "", ..., display_name: "", ..., geojson
        :{type: "", coordinates
            :[[
                [x,y],[x,y],[x,y]
            ]],[[
                [z,z],[z,z],[z,z]
            ]]
        }
    }
]

*/