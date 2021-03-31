package Main.Services;

// Models
import Main.Models.*;
// Repos
import Main.Repositories.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenemeService {

    @Autowired
    private ImpactRepo impactRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private JobsRepo jobsRepo;
    @Autowired
    private ProductionRepo productionRepo;
    @Autowired
    private PlantRepo plantRepo;
    @Autowired
    private ApplicationRepo applicationRepo;


    public List<Impact> getImpact(){

        return impactRepo.findAll();
    }
    public List<Country> getCountry(){

        return countryRepo.findAll();
    }
    public List<Jobs> getJobs(){

        return jobsRepo.findAll();
    }
    public List<Production> getProductions(){

        return productionRepo.findAll();
    }
    public List<Plant> getPlants(){

        return plantRepo.findAll();
    }
    public List<Application> getApplications(){

        return applicationRepo.findAll();
    }
}
