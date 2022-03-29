package clickUpApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //ignore everything that we do not check
public class Folder {
    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private Number id;

    public void setName(final String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(final Number id){
        this.id = id;
    }

    public Number getId(){
        return id;
    }
}
