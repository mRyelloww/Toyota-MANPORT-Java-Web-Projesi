package Main.Models;


import javax.persistence.*;

@Entity
@Table
public class Frontend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long frontendID;
    private String frontendName;

    public Frontend() {
    }

    public Frontend(String frontendName) {
        this.frontendName = frontendName;
    }

    public Long getFrontendID() {
        return frontendID;
    }

    public void setFrontendID(Long frontendID) {
        this.frontendID = frontendID;
    }

    public String getFrontendName() {
        return frontendName;
    }

    public void setFrontendName(String frontendName) {
        this.frontendName = frontendName;
    }
}
