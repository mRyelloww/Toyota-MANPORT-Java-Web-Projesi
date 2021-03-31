package Main.DataCreation;


// Model Imports
import Main.Models.*;

// Repo Imports
import Main.Repositories.*;


import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataCreator {

    @Bean
    public CommandLineRunner demo(ApplicationRepo applicationRepo,
                                  CountryRepo countryRepo,
                                  MiddleWareRepo middleWareRepo,
                                  ImpactRepo impactRepo,
                                  JobsRepo jobsRepo,
                                  //List<Jobs> jobsList, LİSTE KULLANMIYOSUN ARTIK
                                  ProductionRepo prodRepo,
                                  PlantRepo plantRepo,
                                  BusinessAreaRepo businessAreaRepo,
                                  ResponsibleTeamRepo responsibleTeamRepo,
                                  BackendRepo backendRepo,
                                  FrontendRepo frontendRepo,
                                  DatabaseNameRepo databaseNameRepo,
                                  PlantAppRepo plantAppRepo,
                                  IssuesRepo issuesRepo
                                  ) {
        return (args) -> {
            countryRepo.save(new Country("Turkey"));
            countryRepo.save(new Country("England"));
            countryRepo.save(new Country("France"));
            countryRepo.save(new Country("Russia"));
            countryRepo.save(new Country("Czech"));
            countryRepo.save(new Country("South Africa"));

            impactRepo.save(new Impact("Low"));
            impactRepo.save(new Impact("Medium"));
            impactRepo.save(new Impact("High"));

            businessAreaRepo.save(new BusinessArea("Manufacturing"));
            businessAreaRepo.save(new BusinessArea("Quality"));
            businessAreaRepo.save(new BusinessArea("Both"));
            businessAreaRepo.save(new BusinessArea("Others"));

            responsibleTeamRepo.save(new ResponsibleTeam("Manufacturing Systems"));
            responsibleTeamRepo.save(new ResponsibleTeam("EMC"));
            responsibleTeamRepo.save(new ResponsibleTeam("Others"));

            backendRepo.save(new Backend("Pure Java"));
            backendRepo.save(new Backend("JSP"));
            backendRepo.save(new Backend("PL/SQL"));
            backendRepo.save(new Backend("Spring"));
            backendRepo.save(new Backend("Spring Boot"));
            backendRepo.save(new Backend("Other"));

            frontendRepo.save(new Frontend("No UI"));
            frontendRepo.save(new Frontend("Pure HTML/CSS/JS"));
            frontendRepo.save(new Frontend("JSP"));
            frontendRepo.save(new Frontend("Apache Wicket"));
            frontendRepo.save(new Frontend("BackBoneJS"));
            frontendRepo.save(new Frontend("ReactJS"));
            frontendRepo.save(new Frontend("Other"));

            databaseNameRepo.save(new DatabaseName("Oracle"));
            databaseNameRepo.save(new DatabaseName("MsSQL"));
            databaseNameRepo.save(new DatabaseName("DB2"));
            databaseNameRepo.save(new DatabaseName("Other"));

            applicationRepo.save(new Application(
                    "FLR",
                    LocalDate.of(1999,9,12),
                    "Eren",
                    ">75K",
                    ">15K",
                    true,
                    0,
                    frontendRepo.getOne((long)1),
                    backendRepo.getOne((long)1),
                    databaseNameRepo.getOne((long)1),
                    responsibleTeamRepo.getOne((long)1),
                    businessAreaRepo.getOne((long)1))
            );

            middleWareRepo.save(new MiddleWare("11","9",null,null,applicationRepo.getOne((long)1)) );

            plantRepo.save(new Plant("TMMT","Toyota Motor Manufacturing Turkey", 4, countryRepo.getOne((long)1) ));
            plantRepo.save(new Plant("TMUK","Toyota Motor Manufacturing United Kingdom", 2, countryRepo.getOne((long)2) ));

            plantAppRepo.save(new PlantApp(applicationRepo.getOne((long)1) , plantRepo.getOne((long)1) , true) );

            issuesRepo.save(new Issues(plantAppRepo.getOne((long)1), impactRepo.getOne((long)1), LocalDate.of(2021,9,9),"Sorun Tipi","Açıklama") );

            prodRepo.save(new Production("Prod-1",plantRepo.getOne((long)1)) );
            prodRepo.save(new Production("Prod-2",plantRepo.getOne((long)1)) );

            prodRepo.save(new Production("Prod-1",plantRepo.getOne((long)2)) );
            prodRepo.save(new Production("Prod-2",plantRepo.getOne((long)2)) );

            jobsRepo.save(new Jobs("Job1","Slowness",impactRepo.getOne((long)1), prodRepo.getOne((long)1)) );
            jobsRepo.save(new Jobs("Job2","Job Delay", impactRepo.getOne((long)2) , prodRepo.getOne((long)1) ));
            jobsRepo.save(new Jobs("Job3","No Response", impactRepo.getOne((long)3) , prodRepo.getOne((long)1) ));

            jobsRepo.save(new Jobs("Job1","iş çıktı kardeş gel",impactRepo.getOne((long)3), prodRepo.getOne((long)3)) );

//            jobsList.add(jobsRepo.getOne((long)1));
//            jobsList.add(jobsRepo.getOne((long)2));
//            jobsList.add(jobsRepo.getOne((long)3));

        };
    }

}
