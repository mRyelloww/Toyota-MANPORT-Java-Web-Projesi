package Main.Models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantID;
    private String shortCode;
    private String plantName;
    private Integer liveAppCount;

    @OneToMany(mappedBy = "plant")
    private List<Production> productions;

    @OneToMany(mappedBy = "plant")
    private List<PlantApp> plantApp;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name=("countryID"))
    private Country country;


    public Plant() {
    }

    public Plant(String shortCode,
                 String plantName,
                 Integer liveAppCount,
                 Country country) {
        this.shortCode = shortCode;
        this.plantName = plantName;
        this.liveAppCount = liveAppCount;
        this.country = country;
    }


    public Long getPlantID() {
        return plantID;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Integer getLiveAppCount() {
        return liveAppCount;
    }

    public void setLiveAppCount(Integer liveAppCount) {
        this.liveAppCount = liveAppCount;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Production> getProductions() {
        return productions;
    }
    public void setProductions(List<Production> productions) {
        this.productions = productions;
    }

    public List<PlantApp> getPlantApp() {
        return plantApp;
    }

    public void setPlantApp(List<PlantApp> plantApp) {
        this.plantApp = plantApp;
    }
}
