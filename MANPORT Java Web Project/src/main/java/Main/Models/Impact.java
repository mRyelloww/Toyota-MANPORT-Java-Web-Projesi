package Main.Models;


import javax.persistence.*;

@Entity
@Table
public class Impact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long impactID;
    private String impactLevel;

    public Impact() {
    }

    public Impact(String impactLevel) {
        this.impactLevel = impactLevel;
    }

    public Long getImpactID() {
        return impactID;
    }

    public String getImpactLevel() {
        return impactLevel;
    }

    public void setImpactLevel(String impactLevel) {
        this.impactLevel = impactLevel;
    }
}
