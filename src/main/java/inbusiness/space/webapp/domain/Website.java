package inbusiness.space.webapp.domain;

//import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * A Website.
 */
//@Entity
//@Table(name = "website")
//@Document(indexName="website")
public class Website implements Serializable {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotNull
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    //@Column(name = "name", length = 50, nullable = false)
    private String name;

//    @NotNull
//    @Size(min = 5, max = 50)
//    @Pattern(regexp = "^[a-zA-Z0-9]*$")
//    //@Column(name = "uuid", length = 50, nullable = false)
//    private String uuid;

    @Size(max = 200)
    @Pattern(regexp = "^[a-zA-Z0-9:/_-]*$")
    //@Column(name = "url", length = 200)
    private String url;

    @NotNull
    @Size(max = 10)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    //@Column(name = "version", length = 10, nullable = false)
    private String version;

    @NotNull
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    //@Column(name = "ownername", length = 100, nullable = false)
    private String ownername;

    //@Size(max = 2000)
    //@Column(name = "config") //, length = 2000)
    //@Lob
    private Map<String, Object> config;

//    @ManyToOne
//    private User owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public Map<String, Object> getConfig() {
        return config;
    }

    public void setConfig(Map<String, Object> config) {
        this.config = config;
    }

    //    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User user) {
//        this.owner = user;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Website website = (Website) o;

        if ( ! Objects.equals(id, website.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Website{" +
                "id=" + id +
                ", name='" + name + "'" +
                //", uuid='" + uuid + "'" +
                ", url='" + url + "'" +
                ", version='" + version + "'" +
                ", ownername='" + ownername + "'" +
                ", config='" + config + "'" +
                '}';
    }
}
