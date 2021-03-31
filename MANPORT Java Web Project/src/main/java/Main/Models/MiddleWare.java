package Main.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
@JsonIgnoreProperties({"application"})
public class MiddleWare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long middlewareID;
    private String jdkVersion;
    private String jettyVersion;
    private String nodeVersion;

    @OneToOne
    @JoinColumn(name="plantID")
    private Plant plant;

    @ManyToOne
    @JoinColumn(name="applicationID")
    private Application application;

    public MiddleWare() {
    }

    public MiddleWare(String jdkVersion,
                      String jettyVersion,
                      String nodeVersion,
                      Plant plant,
                      Application application) {
        this.jdkVersion = jdkVersion;
        this.jettyVersion = jettyVersion;
        this.nodeVersion = nodeVersion;
        this.plant = plant;
        this.application = application;
    }

    public Long getMiddlewareID() {
        return middlewareID;
    }

    public void setMiddlewareID(Long middlewareID) {
        this.middlewareID = middlewareID;
    }

    public String getJdkVersion() {
        return jdkVersion;
    }

    public void setJdkVersion(String jdkVersion) {
        this.jdkVersion = jdkVersion;
    }

    public String getJettyVersion() {
        return jettyVersion;
    }

    public void setJettyVersion(String jettyVersion) {
        this.jettyVersion = jettyVersion;
    }

    public String getNodeVersion() {
        return nodeVersion;
    }

    public void setNodeVersion(String nodeVersion) {
        this.nodeVersion = nodeVersion;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
