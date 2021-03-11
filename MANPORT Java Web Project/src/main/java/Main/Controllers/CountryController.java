package Main.Controllers;


import Main.Repositories.CountryRepository;
import Main.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "Controllers/CountryController")
public class CountryController {

        private final CountryService countryService;
        @Autowired
        private final CountryRepository repo;

        @Autowired
        public CountryController(CountryService countryService) {
                this.countryService = countryService;
                repo = null;
        }
/*
        @GetMapping
        public List<Plant> getPlants()  {

                return plantService.getPlant();
        }
*/
}
