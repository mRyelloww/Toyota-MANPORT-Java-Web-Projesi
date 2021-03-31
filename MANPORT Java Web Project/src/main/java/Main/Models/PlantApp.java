package Main.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@JsonIgnoreProperties({"application" , "plant"})
public class PlantApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantAppID;
    private Boolean alive;

    @ManyToOne
    @JoinColumn(name="applicationID")
    private Application application;

    @ManyToOne
    @JoinColumn(name="plantID")
    private Plant plant;

    @OneToMany(mappedBy = "plantApp")
    private List<Issues> issues;

    public PlantApp() {
    }

    public PlantApp(Application application,
                    Plant plant,
                    Boolean alive) {
        this.application = application;
        this.plant = plant;
        this.alive = alive;

    }

    public Long getPlantAppID() {
        return plantAppID;
    }

    public void setPlantAppID(Long plantAppID) {
        this.plantAppID = plantAppID;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
//
    public List<Issues> getIssues() {
        return issues;
    }

    public void setIssues(List<Issues> issues) {
        this.issues = issues;
    }
    //
}
