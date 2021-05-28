package Main.Services;

// Models
import Main.Models.*;
// Repos
import Main.Repositories.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
    private PlantAppRepo plantAppRepo;
    @Autowired
    private ApplicationRepo applicationRepo;
    @Autowired
    private IssuesRepo issuesRepo;

    public List<Impact> getImpact(){

        return impactRepo.findAll();
    }
    public List<Country> getCountries(){

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
    public List<PlantApp> getPlantApps(){

        //return plantAppRepo.findAllById(Collections.singleton((long) 2));
        return plantAppRepo.findAll();

    }
    public List<Application> getApplications(){

        return applicationRepo.findAll();
    }
    public List<Issues> getIssues(){
        return issuesRepo.findAll();
    }

    public List<Issues> getIssuesByRow(){
        List<Issues> issues = issuesRepo.findAll();
        List<Issues> sortedIssues = new ArrayList<>();
        Issues newIssue = new Issues();
        Issues oldIssue = new Issues();
        Issues olderIssue = new Issues();
        //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");


        //sortedIssues.set(0,issues.get(0));
        newIssue.setDate(LocalDateTime.of(2000,1,1,1,1));
        oldIssue.setDate(LocalDateTime.of(2000,1,1,1,1));
        olderIssue.setDate(LocalDateTime.of(2000,1,1,1,1));

        for (int i=0 ; i<issues.size() ; i++){
            if(issues.get(i).getDate().isAfter(newIssue.getDate()) ){
                oldIssue = newIssue;
                newIssue = issues.get(i);
            }
            else if ( issues.get(i).getDate().isAfter(oldIssue.getDate()) ){
                olderIssue = oldIssue;
                oldIssue = issues.get(i);
            }
            else if ( issues.get(i).getDate().isAfter(olderIssue.getDate()) ){
                olderIssue = issues.get(i);
            }
        }

        sortedIssues.add(newIssue);
        sortedIssues.add(oldIssue);
        sortedIssues.add(olderIssue);
        
        return sortedIssues;
    }


    public PlantApp getPlantApp(Long id){
        PlantApp plantapp = this.plantAppRepo.findById(id).get();
        return plantapp;
    }
    public PlantApp changePlantApp(Long id,PlantApp plantapp){
        plantAppRepo.save(plantapp);
        return plantapp;
    }

    public Application getApplication(Long id){
        Application application = this.applicationRepo.findById(id).get();
        return application;
    }
    public Application changeApplicationVisibility(Long id,Application application){
        applicationRepo.save(application);
        return application;
    }

    public Country getCountry(Long id){
        Country country = this.countryRepo.findById(id).get();
        return country;
    }
    public Country changeCountry(Long id,Country country){
        countryRepo.save(country);
        return country;
    }

//    public String getCountryName(Long id){
//        Country country = this.countryRepo.findById(id).get();
//        return country.getCountryName();
//    }

/*
    public void addPlantAppImpact(Long id,Impact impact){
        PlantApp pltApp = plantAppRepo.findById(id).get();
        pltApp.setImpact(impact);
        plantAppRepo.save(pltApp);
    }
*/
    /*
    public void issueTanimla(){
        //issuesRepo.getOne((long)1).addIssueJobType(jobsRepo.getOne((long)1 ));
    }
     */
}
