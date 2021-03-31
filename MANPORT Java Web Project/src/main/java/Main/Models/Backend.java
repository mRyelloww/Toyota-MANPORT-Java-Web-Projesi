package Main.Models;

import javax.persistence.*;

@Entity
@Table
public class Backend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long backendID;
    private String backendName;

    public Backend(String backendName) {
        this.backendName = backendName;
    }

    public Backend() {
    }

    public Long getBackendID() {
        return backendID;
    }

    public void setBackendID(Long backendID) {
        this.backendID = backendID;
    }

    public String getBackendName() {
        return backendName;
    }

    public void setBackendName(String backendName) {
        this.backendName = backendName;
    }
}
