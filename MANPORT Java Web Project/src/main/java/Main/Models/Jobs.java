package Main.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table
//@JsonIgnoreProperties({"Productions"})
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobID;
    private String jobName;
    //private String description;

    @ManyToOne
    @JoinColumn(name=("impactID"))
    private Impact impact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name=("issueID"))
    private Issues issue;

    @ManyToOne
    @JoinColumn(name = "productionID")
    private Production production;

    public Jobs() {
    }

    public Jobs(String jobName, /* String description, */ Impact impact, Production production,  Issues issue) {
        this.jobName = jobName;
        //this.description = description;
        this.impact = impact;
        this.production = production;
        this.issue = issue;
    }

    public Jobs(String jobName, Impact impact, Production production) {
        this.jobName = jobName;
        //this.description = description;
        this.impact = impact;
        this.production = production;

    }

    public Long getJobID() {
        return jobID;
    }

    public String getJobName() {
        return jobName;
    }
/*
    public String getDescription() {
        return description;
    }
*/
    public Impact getImpact() {
        return impact;
    }
//
//    public Production getProduction() {
//        return production;
//    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
/*
    public void setDescription(String description) {
        this.description = description;
    }
*/
    public void setImpact(Impact impact) {
        this.impact = impact;
    }

//    public void setProduction(Production production) {
//        this.production = production;
//    }

    public void setIssue(Issues issue) {
        this.issue = issue;
    }
}
