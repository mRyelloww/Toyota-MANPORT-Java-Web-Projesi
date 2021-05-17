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

            impactRepo.save(new Impact("NoIssue"));
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
            applicationRepo.save(new Application(
                    "CTS",
                    LocalDate.of(1998,8,11),
                    "Can",
                    ">50K",
                    ">10K",
                    false,
                    0,
                    frontendRepo.getOne((long)1),
                    backendRepo.getOne((long)1),
                    databaseNameRepo.getOne((long)1),
                    responsibleTeamRepo.getOne((long)1),
                    businessAreaRepo.getOne((long)1))
            );
            applicationRepo.save(new Application(
                    "CVQS",
                    LocalDate.of(1998,8,11),
                    "Sarı",
                    ">50K",
                    ">10K",
                    false,
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

            plantAppRepo.save(new PlantApp(applicationRepo.getOne((long)1) , plantRepo.getOne((long)1) , false));
            //plantAppRepo.save(new PlantApp(applicationRepo.getOne((long)1) , plantRepo.getOne((long)1) , true));
            plantAppRepo.save(new PlantApp(applicationRepo.getOne((long)2) , plantRepo.getOne((long)1) , true));
            plantAppRepo.save(new PlantApp(applicationRepo.getOne((long)2) , plantRepo.getOne((long)2) , true));

            plantAppRepo.save(new PlantApp(applicationRepo.getOne((long)3) , plantRepo.getOne((long)2) , true));





            prodRepo.save(new Production("PROD-1",plantRepo.getOne((long)1)) ); // Türkiyenin Prod-1 'si
            prodRepo.save(new Production("PROD-2",plantRepo.getOne((long)1)) ); // Türkiyenin Prod-2 'si

            prodRepo.save(new Production("PROD-1",plantRepo.getOne((long)2)) ); // İngilterenin Prod-1 'si
            prodRepo.save(new Production("PROD-2",plantRepo.getOne((long)2)) ); // İngilterenin Prod-2 'si

            /*
            jobsRepo.save(new Jobs("Job2", impactRepo.getOne((long)1) , prodRepo.getOne((long)1) ));
            jobsRepo.save(new Jobs("Job3", impactRepo.getOne((long)1) , prodRepo.getOne((long)1) ));

            jobsRepo.save(new Jobs("Job1",impactRepo.getOne((long)1), prodRepo.getOne((long)3) ));
            jobsRepo.save(new Jobs("Job1",impactRepo.getOne((long)1), prodRepo.getOne((long)2) ));
            jobsRepo.save(new Jobs("Job1",impactRepo.getOne((long)1), prodRepo.getOne((long)4) ));
            jobsRepo.save(new Jobs("Job1",impactRepo.getOne((long)1), prodRepo.getOne((long)4) ));
            */
            jobsRepo.save(new Jobs("Job1",impactRepo.getOne((long)1), prodRepo.getOne((long)1) ));
            jobsRepo.save(new Jobs("Job2", impactRepo.getOne((long)1), prodRepo.getOne((long)1) ));
            jobsRepo.save(new Jobs("Job3", impactRepo.getOne((long)1), prodRepo.getOne((long)1) ));
            jobsRepo.save(new Jobs("Job4", impactRepo.getOne((long)1), prodRepo.getOne((long)1) ));

            jobsRepo.save(new Jobs("Job1", impactRepo.getOne((long)1), prodRepo.getOne((long)3) ));
            jobsRepo.save(new Jobs("Job2", impactRepo.getOne((long)1), prodRepo.getOne((long)3) ));
            jobsRepo.save(new Jobs("Job3", impactRepo.getOne((long)1), prodRepo.getOne((long)3) ));


            jobsRepo.save(new Jobs("Job1", impactRepo.getOne((long)1), prodRepo.getOne((long)4) ));
            jobsRepo.save(new Jobs("Job2", impactRepo.getOne((long)1), prodRepo.getOne((long)4) ));

            jobsRepo.save(new Jobs("Job1", impactRepo.getOne((long)1), prodRepo.getOne((long)2) ));






            issuesRepo.save(new Issues( LocalDate.of(2021,9,9),"Slowness") );
            issuesRepo.save(new Issues( LocalDate.of(2021,9,9),"No Response") );
            issuesRepo.save(new Issues( LocalDate.of(2021,9,9),"Job Delay") );
            issuesRepo.save(new Issues( LocalDate.of(2021,9,9),"Scan Issue") );
            issuesRepo.save(new Issues( LocalDate.of(2021,9,9),"DB Connection") );
            issuesRepo.save(new Issues( LocalDate.of(2021,9,9),"Disconnected") );





            /*
            List<Issues> isu = issuesRepo.findAll();
            isu.get(1).setPlantApp(plantAppRepo.getOne((long)1 ));
            List<Jobs> jobis = jobsRepo.findAll();
            jobis.get(1).setIssue(issuesRepo.getOne((long)1 ));
            //isu.get(1).addIssueJobType(jobsRepo.getOne((long)1 ));

            System.out.println("\n" + isu.get(1).getPlantApp().getPlantAppID() );
            */

            Issues issueTmp = issuesRepo.findById((long)1).get();
            Jobs jobTmp = jobsRepo.findById((long)1).get();
            jobTmp.setIssue(issueTmp);                     // Hangi tür problem olduğunu belirtiyorum
            jobTmp.setImpact(impactRepo.getOne((long)4));  // Belirlemiş olduğum issue türünün impact derecesini belirliyorum
            PlantApp plantappTmp = plantAppRepo.findById((long)1).get();
            issueTmp.setPlantApp(plantappTmp);
            issuesRepo.save(issueTmp);
            jobsRepo.save(jobTmp);      // Son olarak değişiklikleri kaydediyorum

            issueTmp = issuesRepo.findById((long)2).get();
            jobTmp = jobsRepo.findById((long)2).get();
            jobTmp.setIssue(issueTmp);                     // Hangi tür problem olduğunu belirtiyorum
            jobTmp.setImpact(impactRepo.getOne((long)3));
            plantappTmp = plantAppRepo.findById((long)2).get();
            issueTmp.setPlantApp(plantappTmp);
            issuesRepo.save(issueTmp);
            jobsRepo.save(jobTmp);

            /* Turkey->Prod-1 'de bulunan Job4'e , Slowness issue'sunu , impact olarak low(sarı) , application olarak FLR bölümünde bulunacak şekilde ayarladım.
            issueTmp= issuesRepo.findById((long)1).get();
            jobTmp= jobsRepo.findById((long)4).get();
            plantappTmp = plantAppRepo.findById((long)1).get();
            jobTmp.setIssue(issueTmp);
            jobTmp.setImpact(impactRepo.getOne((long)2));
            issueTmp.setPlantApp(plantappTmp);
            issuesRepo.save(issueTmp);
            jobsRepo.save(jobTmp);
            */

            issueTmp = issuesRepo.findById((long)3).get();
            jobTmp = jobsRepo.findById((long)3).get();
            jobTmp.setIssue(issueTmp);
            jobTmp.setImpact(impactRepo.getOne((long)2));
            plantappTmp = plantAppRepo.findById((long)1).get();
            issueTmp.setPlantApp(plantappTmp);
            issuesRepo.save(issueTmp);
            jobsRepo.save(jobTmp);

            issueTmp = issuesRepo.findById((long)4).get();
            jobTmp = jobsRepo.findById((long)6).get();
            jobTmp.setIssue(issueTmp);
            jobTmp.setImpact(impactRepo.getOne((long)4));
            plantappTmp = plantAppRepo.findById((long)4).get();
            issueTmp.setPlantApp(plantappTmp);
            issuesRepo.save(issueTmp);
            jobsRepo.save(jobTmp);

            issueTmp = issuesRepo.findById((long)5).get();
            jobTmp = jobsRepo.findById((long)10).get();
            jobTmp.setIssue(issueTmp);
            jobTmp.setImpact(impactRepo.getOne((long)2));
            plantappTmp = plantAppRepo.findById((long)1).get();
            issueTmp.setPlantApp(plantappTmp);
            issuesRepo.save(issueTmp);
            jobsRepo.save(jobTmp);

            issueTmp = issuesRepo.findById((long)6).get();
            jobTmp = jobsRepo.findById((long)10).get();
            jobTmp.setIssue(issueTmp);
            jobTmp.setImpact(impactRepo.getOne((long)2));
            plantappTmp = plantAppRepo.findById((long)2).get();
            issueTmp.setPlantApp(plantappTmp);
            issuesRepo.save(issueTmp);
            jobsRepo.save(jobTmp);



//            jobsList.add(jobsRepo.getOne((long)1));
//            jobsList.add(jobsRepo.getOne((long)2));
//            jobsList.add(jobsRepo.getOne((long)3));

        };
    }

}
