package service.country;

import model.Country;
import model.Student;

import java.util.List;

public interface CountryInterFace {
    List<Country> showAll();

    void createCountry(Country country);

    void updateCountry(int id,Country country);

    void removeCountry(int id);

    Country findCountryById(int id);

    Country findCountryByName(String name);
}
