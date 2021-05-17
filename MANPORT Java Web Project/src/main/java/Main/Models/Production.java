package Main.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
//@JsonIgnoreProperties({"Jobs"})
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productionID;
    private String productionName;

    @OneToMany(mappedBy = "production")
    private List<Jobs> jobs;

    @ManyToOne
    @JoinColumn(name = "plantID")
    private Plant plant;

    public Production() {
    }

    public Production(String productionName) {
        this.productionName = productionName;
    }

    public Production(String productionName, Plant plant) {
        this.productionName = productionName;
        this.plant = plant;
    }

    public Long getProductionID() {
        return productionID;
    }

    public void setProductionID(Long productionID) {
        this.productionID = productionID;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }


    public List<Jobs> getJobs() {
        return jobs;
    }
//
    public void setJobs(List<Jobs> jobs) {
        this.jobs = jobs;
    }
//
//     public Plant getPlant() {
//         return plant;
//     }
//
//     public void setPlant(Plant plant) {
//         this.plant = plant;
//     }
}
