package Main.Services;

import Main.Models.Country;
import Main.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;
    @Override
    public void run(String... args) throws Exception {

        Country country1 = new Country();
        country1.setCountryName("Turkey");
        countryRepository.save(country1);

        Country country2 = new Country();
        country2.setCountryName("England");
        countryRepository.save(country2);

        Country country3 = new Country();
        country3.setCountryName("France");
        countryRepository.save(country3);

        Country country4 = new Country();
        country4.setCountryName("Russia");
        countryRepository.save(country4);

        Country country5 = new Country();
        country5.setCountryName("Czech");
        countryRepository.save(country5);

        Country country6 = new Country();
        country6.setCountryName("SouthAfrica");
        countryRepository.save(country6);

    }
}
