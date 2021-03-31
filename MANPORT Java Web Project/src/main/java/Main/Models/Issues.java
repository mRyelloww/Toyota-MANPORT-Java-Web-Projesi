package Main.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@JsonIgnoreProperties({"plantApp"})
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueID;
    private LocalDate date;
    private String issueType;
    private String description;

    @ManyToOne
    @JoinColumn(name="impactID")
    private Impact impact;

    @ManyToOne
    @JoinColumn(name="plantAppID")
    private PlantApp plantApp;

    public Issues() {
    }

    public Issues(PlantApp plantApp,
                  Impact impact,
                  LocalDate date,
                  String issueType,
                  String description
                  ) {
        this.date = date;
        this.issueType = issueType;
        this.description = description;
        this.impact = impact;
        this.plantApp = plantApp;
    }

    public Long getIssueID() {
        return issueID;
    }

    public void setIssueID(Long issueID) {
        this.issueID = issueID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Impact getImpact() {
        return impact;
    }

    public void setImpact(Impact impact) {
        this.impact = impact;
    }

    public PlantApp getPlantApp() {
        return plantApp;
    }

    public void setPlantApp(PlantApp plantApp) {
        this.plantApp = plantApp;
    }
}
