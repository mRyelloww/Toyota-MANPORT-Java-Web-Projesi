package Main.Models;

import javax.persistence.*;

@Entity(name = "Plant")
@Table
public class Plant {

    @Id
    @GeneratedValue
    @Column(nullable=false)
    private Long PlantID;
    @ManyToOne
    @JoinColumn(name="CountryID")
    private Country CountryID;
    private Long ProductionID;
    private String shortCode;
    private String fullName;
    private Integer liveAppCount;

    //Constructor
    public Plant() {
    }

    public Plant(Long productionID, String shortCode, String fullName) {
        ProductionID = productionID;
        this.shortCode = shortCode;
        this.fullName = fullName;
    }/*
    // Getters
    public Long getCountryID() {
        return CountryID;
    }
*/
    public Long getProductionID() {
        return ProductionID;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getLiveAppCount() {
        return liveAppCount;
    }

    //Setters
    //public void setCountryID(Long countryID) {
    //    CountryID = countryID;
    //}

    public void setProductionID(Long productionID) {
        ProductionID = productionID;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLiveAppCount(Integer liveAppCount) {
        this.liveAppCount = liveAppCount;
    }
}
