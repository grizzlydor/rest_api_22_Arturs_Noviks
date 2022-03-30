package clickUpApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class List {

    @JsonProperty("list_id")
    private Number id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("folder_id")
    private Number folderId;
    /*@JsonProperty("folder_name")
    private String folderName;*/

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

    public void setFolderId(final Number folderId) {this.folderId = folderId;}
    public Number getFolderId(){return folderId;}

    /*public void setFolderName(final String folderName) {this.folderName = folderName;}
    public String getFolderName(){return folderName;}*/
}
