package service.country;

import model.Country;
import model.Student;
import service.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryService implements CountryInterFace{
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Country> showAll() {
        List<Country> countryList = new ArrayList<>();
        String sql ="select * from country";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Country country = new Country(id,name);
                countryList.add(country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return countryList;


    }

    @Override
    public void create(Country country) {

    }

    @Override
    public void update(int id, Country country) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Country findById(int id) {
        Country country = null;
        String sql = "select * from country where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                int id1 = set.getInt("id");
                String name = set.getString("name");
                country = new Country(id1,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return country;
    }

    @Override
    public List<Country> findListById(int id) {
        return null;
    }

    @Override
    public Country findByName(String name) {
        return null;
    }
}
