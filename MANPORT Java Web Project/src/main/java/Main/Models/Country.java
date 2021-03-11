package Main.Models;

import javax.persistence.*;

@Entity
@Table
public class Country {
    @Id
    @GeneratedValue
    @Column(nullable=false)
    private Long CountryID;
    private String countryName;
    private Integer numberOfAppsUsed;

    public Country() {
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Long getCountryID() {
        return CountryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getNumberOfAppsUsed() {
        return numberOfAppsUsed;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setNumberOfAppsUsed(Integer numberOfAppsUsed) {
        this.numberOfAppsUsed = numberOfAppsUsed;
    }
}
