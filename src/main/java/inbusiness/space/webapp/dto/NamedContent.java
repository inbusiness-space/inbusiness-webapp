package inbusiness.space.webapp.dto;

/**
 * Created by wilfried on 19/12/2015.
 */
public class NamedContent {

    private String name;
    private String type;
    private byte[] content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
