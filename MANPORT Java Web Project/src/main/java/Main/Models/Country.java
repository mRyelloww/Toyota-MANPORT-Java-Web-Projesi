package Main.Models;


import javax.persistence.*;

@Entity
@Table
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryID;
    private String countryName;
    private Integer appCount;

    public Country() {
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Long getCountryID() {
        return countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getAppCount() {
        return appCount;
    }

    public void setAppCount(Integer appCount) {
        this.appCount = appCount;
    }
}
