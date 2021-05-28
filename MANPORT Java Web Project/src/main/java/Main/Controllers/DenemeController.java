package Main.Controllers;

// Models
// Eren Sarı deneme
import Main.Models.*;


import Main.Repositories.CountryRepo;
import Main.Repositories.ImpactRepo;
import Main.Repositories.JobsRepo;
import Main.Services.DenemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Country> getCountries()  {
        return denemeService.getCountries();
    }

    @RequestMapping(path = "/jobs")
    public List<Jobs> getJobs()  { return denemeService.getJobs(); }

    @RequestMapping(path = "/prod")
    public List<Production> getProduction()  { return denemeService.getProductions(); }

    @RequestMapping(path = "/plant")
    public List<Plant> getPlant()  { return denemeService.getPlants(); }

    @RequestMapping(path = "/plantapp")
    public List<PlantApp> getPlantApps()  { return denemeService.getPlantApps(); }



    @GetMapping("/plantapp/{id}")
    public PlantApp getPlantApp(@PathVariable(value = "id") Long id){
        return denemeService.getPlantApp(id);
    }
    @PutMapping(path = "/plantapp/{id}")
    public PlantApp getPlantApp(@PathVariable(value = "id") Long id, @RequestBody PlantApp plantapp){
        return denemeService.changePlantApp(id,plantapp);
    }

    @GetMapping("/application/{id}")
    public Application getApplication(@PathVariable(value = "id") Long id){
        return denemeService.getApplication(id);
    }
    @PutMapping(path = "/application/{id}")
    public Application getApplication(@PathVariable(value = "id") Long id, @RequestBody Application application){
        return denemeService.changeApplicationVisibility(id,application);
    }

    @GetMapping("/country/{id}")
    public Country getCountry(@PathVariable(value = "id") Long id){
        return denemeService.getCountry(id);
    }
    @PutMapping(path = "/country/{id}")
    public Country getCountry(@PathVariable(value = "id") Long id, @RequestBody Country country){
        return denemeService.changeCountry(id,country);
    }

    @RequestMapping(path = "/siraliIssues")
    public List<Issues> getIssuesByRow()  {
        return denemeService.getIssuesByRow();
    }

    @RequestMapping(path = "/application")
    public List<Application> getApplications()  {
        return denemeService.getApplications();
    }

    @RequestMapping(path = "/issues")
    public List<Issues> getIssues()  {
        return denemeService.getIssues();
    }

/*
    @RequestMapping(value = "/plantapp/{id}" , method = RequestMethod.PUT)
    public void addImpact(@RequestBody PlantApp pltapp , @PathVariable(value = "id") Long id){
        denemeService.addPlantAppImpact(id);
    }
*/
    /*
    @RequestMapping(path = "/issues/deniyoruz")
    public List<Issues> issueTanimla()  {
        denemeService.issueTanimla();
        return denemeService.getIssues();
    }
     */


}
