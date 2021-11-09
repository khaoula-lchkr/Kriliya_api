package ma.ensate.kriliya.model;

import javax.persistence.*;

@Entity
@Table(name="images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private String cle;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="annonce_id", referencedColumnName = "id")
    private Annonce annonce;

    public Image(){

    }

    public Image(int id, String url, String cle) {
        this.id = id;
        this.url = url;
        this.cle = cle;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }



}
