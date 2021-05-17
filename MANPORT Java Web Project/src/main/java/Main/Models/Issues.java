package Main.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
//@JsonIgnoreProperties({"plantApp"})
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueID;
    private LocalDate date;

    @OneToMany(mappedBy = "issue")
    public List<Jobs> issueJobType;

    //private String issueProdType;

    private String description;
/*      issue'da impact kullanmaktan vazgeçtim çünkü her issue her jobda farklı derecede olabilir.Mesela Slowness sorunu job1'de high derecedeyken job3'te low olabilir.
    @ManyToOne
    @JoinColumn(name="impactID")
    private Impact impact;
*/
    @ManyToOne
    @JoinColumn(name="plantAppID")
    private PlantApp plantApp;

    public Issues() {
    }

    public Issues(/*PlantApp plantApp,*/
                  /*Impact impact,*/
                  LocalDate date,
                  String description
                  ) {
        this.date = date;
        //this.issueProdType = issueProdType; issue proda gerek yok zaten jobların id'leri var
        this.description = description;
        //this.impact = impact;
        //this.plantApp = plantApp;
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

    public List<Jobs> getIssueJobType() {
        return issueJobType;
    }
    public void setIssueJobType(List<Jobs> issueJobType) {
        this.issueJobType = issueJobType;
    }
/*
    public void addIssueJobType(Jobs job){
        this.issueJobType.add(job);
    }
*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*
    public Impact getImpact() {
        return impact;
    }

    public void setImpact(Impact impact) {
        this.impact = impact;
    }
*/
    public PlantApp getPlantApp() {
        return plantApp;
    }

    public void setPlantApp(PlantApp plantApp) {
        this.plantApp = plantApp;
    }
}
