package Main.Models;

import javax.persistence.*;

@Entity
@Table
public class ResponsibleTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responsibleTeamID;
    private String responsibleTeamName;

    public ResponsibleTeam() {
    }

    public ResponsibleTeam(String responsibleTeamName) {
        this.responsibleTeamName = responsibleTeamName;
    }

    public Long getResponsibleTeamID() {
        return responsibleTeamID;
    }

    public void setResponsibleTeamID(Long responsibleTeamID) {
        this.responsibleTeamID = responsibleTeamID;
    }

    public String getResponsibleTeamName() {
        return responsibleTeamName;
    }

    public void setResponsibleTeamName(String responsibleTeamName) {
        this.responsibleTeamName = responsibleTeamName;
    }
}
