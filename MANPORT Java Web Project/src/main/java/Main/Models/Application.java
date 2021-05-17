package Main.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@JsonIgnoreProperties({"plantApp"})
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationID;
    private String shortCode;
    private LocalDate releaseDate;
    private String responsible;
    private String lcOfBackendCode;
    private String lcOfFrontendCode;
    private Boolean lineStopRisk;
    private Integer livePlantsCount;

    @OneToMany(mappedBy = "application")
    private List<MiddleWare> middleWare;

    @OneToMany(mappedBy = "application")
    private List<PlantApp> plantApp;

    @ManyToOne
    @JoinColumn(name="frontendID")
    private Frontend frontend;

    @ManyToOne
    @JoinColumn(name="backendID")
    private Backend backend;

    @ManyToOne
    @JoinColumn(name="databaseNameID")
    private DatabaseName databaseName;

    @ManyToOne
    @JoinColumn(name="responsibleTeamID")
    private ResponsibleTeam responsibleTeam;

    @ManyToOne
    @JoinColumn(name="businessAreaID")
    private BusinessArea businessArea;

    public Application() {
    }

    public Application(String shortCode,
                       LocalDate releaseDate,
                       String responsible,
                       String lcOfBackendCode,
                       String lcOfFrontendCode,
                       Boolean lineStopRisk,
                       Integer livePlantsCount,
                       Frontend frontend,
                       Backend backend,
                       DatabaseName databaseName,
                       ResponsibleTeam responsibleTeam,
                       BusinessArea businessArea) {
        this.shortCode = shortCode;
        this.releaseDate = releaseDate;
        this.responsible = responsible;
        this.lcOfBackendCode = lcOfBackendCode;
        this.lcOfFrontendCode = lcOfFrontendCode;
        this.lineStopRisk = lineStopRisk;
        this.livePlantsCount = livePlantsCount;
        this.frontend = frontend;
        this.backend = backend;
        this.databaseName = databaseName;
        this.responsibleTeam = responsibleTeam;
        this.businessArea = businessArea;
    }

    public Long getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Long applicationID) {
        this.applicationID = applicationID;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getLcOfBackendCode() {
        return lcOfBackendCode;
    }

    public void setLcOfBackendCode(String lcOfBackendCode) {
        this.lcOfBackendCode = lcOfBackendCode;
    }

    public String getLcOfFrontendCode() {
        return lcOfFrontendCode;
    }

    public void setLcOfFrontendCode(String lcOfFrontendCode) {
        this.lcOfFrontendCode = lcOfFrontendCode;
    }

    public Boolean getLineStopRisk() {
        return lineStopRisk;
    }

    public void setLineStopRisk(Boolean lineStopRisk) {
        this.lineStopRisk = lineStopRisk;
    }

    public Integer getLivePlantsCount() {
        return livePlantsCount;
    }

    public void setLivePlantsCount(Integer livePlantsCount) {
        this.livePlantsCount = livePlantsCount;
    }
//
    public List<MiddleWare> getMiddleWare() {
        return middleWare;
    }

    public void setMiddleWare(List<MiddleWare> middleWare) {
        this.middleWare = middleWare;
    }
//
    public Frontend getFrontend() {
        return frontend;
    }

    public void setFrontend(Frontend frontend) {
        this.frontend = frontend;
    }

    public Backend getBackend() {
        return backend;
    }

    public void setBackend(Backend backend) {
        this.backend = backend;
    }

    public DatabaseName getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(DatabaseName databaseName) {
        this.databaseName = databaseName;
    }

    public ResponsibleTeam getResponsibleTeam() {
        return responsibleTeam;
    }

    public void setResponsibleTeam(ResponsibleTeam responsibleTeam) {
        this.responsibleTeam = responsibleTeam;
    }

    public BusinessArea getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(BusinessArea businessArea) {
        this.businessArea = businessArea;
    }

    public List<PlantApp> getPlantApp() {
        return plantApp;
    }

    public void setPlantApp(List<PlantApp> plantApp) {
        this.plantApp = plantApp;
    }
}
