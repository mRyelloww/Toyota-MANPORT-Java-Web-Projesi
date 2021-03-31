package Main.Models;


import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobID;
    private String jobName;
    private String description;

    @ManyToOne
    @JoinColumn(name=("impactID"))
    private Impact impact;

    @ManyToOne
    @JoinColumn(name = "productionID")
    private Production production;

    public Jobs() {
    }

    public Jobs(String jobName, String description, Impact impact, Production production) {
        this.jobName = jobName;
        this.description = description;
        this.impact = impact;
        this.production = production;
    }

    public Jobs(String jobName, String description, Impact impact) {
        this.jobName = jobName;
        this.description = description;
        this.impact = impact;
    }

    public Long getJobID() {
        return jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public String getDescription() {
        return description;
    }

    public Impact getImpact() {
        return impact;
    }

    public Production getProduction() {
        return production;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImpact(Impact impact) {
        this.impact = impact;
    }

    public void setProduction(Production production) {
        this.production = production;
    }
}
