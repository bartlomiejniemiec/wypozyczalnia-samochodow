package com.mv.dao;

import com.mv.model.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private String daoCarsSelect;
    private DBConnectionManager connectionManager;

    public CarDao(DBConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }


    public List<Car> getAvaibleCars() {
        daoCarsSelect = getDaoCarsSelect();
        try (Connection connection = connectionManager.getConnection()) {
            List<Car> cars = new ArrayList<>();
            try (ResultSet resultSet = connection.prepareStatement(daoCarsSelect).executeQuery()) {
                while (resultSet.next()) {
                    Car car = new Car();
                    car.setId(resultSet.getInt("car_id"));
                    car.setName(resultSet.getString("car_name"));
                    car.setAvaible(resultSet.getBoolean("car_avaible"));
                    car.setPricePerDay(resultSet.getInt("car_price_per_day"));
                    car.setYear(resultSet.getInt("car_year"));
                    car.setColor(resultSet.getString("car_color"));
                    cars.add(car);
                }
                return cars;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDaoCarsSelect() {
        return "select c.id as car_id, c.car_name as car_name, c.avaible as car_avaible, c.price_per_day as car_price_per_day, " +
                "c.year as car_year, c.color as car_color " +
                "from car c " +
                "where c.avaible = true";
    }
}
