package inbusiness.space.webapp.domain;


//import org.springframework.data.elasticsearch.annotations.Document;

//import javax.persistence.Id;

/**
 * Created by fer on 25/09/2015.
 */
//@Document(indexName="respond")
public class Snippet {
    //@Id
    private String id; // C'est le nom du répertoire snippet.
                        // A partir de cette id, on ira chercher dans les ressources images d'exemple du snippet et le code HTML.
    private String name; // Nom du snippet
    private String prefix; // Type surement css du snippet

    public Snippet() {
        super();
    }

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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
