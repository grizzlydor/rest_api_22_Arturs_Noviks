package clickUpApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("list_id")
    private Number listId;

    public void setName(final String name) { this.name = name;}
    public String getName() { return name;}

    public void setId(final String id) {this.id = id;}
    public String getId() { return id;}

    public void setListId(final Number listId) {this.listId = listId;}
    public Number getListId() {return listId;}
}
