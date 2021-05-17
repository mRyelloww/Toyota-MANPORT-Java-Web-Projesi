package Main.Controllers;

// Models
// Eren Sarı deneme
import Main.Models.*;


import Main.Repositories.CountryRepo;
import Main.Repositories.ImpactRepo;
import Main.Repositories.JobsRepo;
import Main.Services.DenemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "deneme")
public class DenemeController {

    private final DenemeService denemeService;

    @Autowired
    public DenemeController(DenemeService denemeService) {
        this.denemeService = denemeService;
    }

    @RequestMapping(path = "/impact")
    public List<Impact> getImpact()  {
        return denemeService.getImpact();
    }

    @RequestMapping(path = "/country")
    public List<Country> getCountry()  {
        return denemeService.getCountry();
    }

    @RequestMapping(path = "/jobs")
    public List<Jobs> getJobs()  { return denemeService.getJobs(); }

    @RequestMapping(path = "/prod")
    public List<Production> getProduction()  { return denemeService.getProductions(); }

    @RequestMapping(path = "/plant")
    public List<Plant> getPlant()  { return denemeService.getPlants(); }

    @RequestMapping(path = "/plantapp")
    public List<PlantApp> getPlantApps()  { return denemeService.getPlantApps(); }

    @RequestMapping(path = "/application")
    public List<Application> getApplication()  {
        return denemeService.getApplications();
    }

    @RequestMapping(path = "/issues")
    public List<Issues> getIssues()  {
        return denemeService.getIssues();
    }
    /*
    @RequestMapping(path = "/issues/deniyoruz")
    public List<Issues> issueTanimla()  {
        denemeService.issueTanimla();
        return denemeService.getIssues();
    }
     */


}
