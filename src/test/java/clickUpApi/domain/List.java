package clickUpApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class List {

    @JsonProperty("id")
    private Number id;
    @JsonProperty("name")
    private String name;
    /*
    @JsonProperty("folder_id")
    private Number folderId;
    */
    @JsonProperty("folder")
    private JsonNode folder;  //Using a JsonNode to access a nested Json value, in this case - ID of the folder
    public void setFolder(final JsonNode folder){this.folder = folder;}
    public JsonNode getFolder() { return folder; }


    public void setName(final String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setId(final Number id){
        this.id = id;
    }
    public Number getId() { return id; }

}
