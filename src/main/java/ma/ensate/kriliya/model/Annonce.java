package ma.ensate.kriliya.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="annonces")
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String type;
    private String titre;
    private String description;
    private String 	ville;
    private String quartier;
    private float prix;
    private int surface;
    private int chambres;
    private  Boolean wifi;
    private Boolean meuble;
    private Boolean refrigerateur;
    private Boolean chauffage;
    private Boolean machineALaver;
    private String preference;
    private int User_id;


    @OneToOne(orphanRemoval = false)
    @JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="annonce_id", referencedColumnName = "id")
    private List<Image> Images;

    public Annonce(){

    }

    public Annonce(int id, Date date, String type, String titre, String description, String ville, String quartier, float prix, int surface, int chambres, Boolean wifi, Boolean refrigerateur, Boolean chauffage, Boolean machineALaver, Boolean meuble, String preference) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.titre = titre;
        this.description = description;
        this.ville = ville;
        this.quartier = quartier;
        this.prix = prix;
        this.surface = surface;
        this.chambres = chambres;
        this.wifi = wifi;
        this.refrigerateur = refrigerateur;
        this.chauffage = chauffage;
        this.meuble = meuble;
        this.machineALaver = machineALaver;
        this.preference = preference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public int getChambres() {
        return chambres;
    }

    public void setChambres(int chambres) {
        this.chambres = chambres;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getRefrigerateur() {
        return refrigerateur;
    }

    public void setRefrigerateur(Boolean refrigerateur) {
        this.refrigerateur = refrigerateur;
    }

    public Boolean getChauffage() { return chauffage; }

    public void setChauffage(Boolean chauffage) {
        this.chauffage = chauffage;
    }

    public Boolean getMachineALaver() {
        return machineALaver;
    }

    public void setMachineALaver(Boolean machineALaver) {
        this.machineALaver = machineALaver;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getMeuble() { return meuble; }

    public void setMeuble(Boolean meuble) { this.meuble = meuble; }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImages() {
        return Images;
    }

    public void setImages(List<Image> images) {
        Images = images;
    }
}
