package com.mv.dao;

import com.mv.model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDao {
    private static final java.lang.String ADD_RESERVATION_SELECT =
            "INSERT INTO reservation (car_id, reservation_begin, reservation_end, total_price) VALUES (?, ?, ?, ?)";
    private DBConnectionManager connectionManager;

    public ReservationDao(DBConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void addReservation(Connection connection, Reservation reservation) {
        try (PreparedStatement ps = connection.prepareStatement(ADD_RESERVATION_SELECT)) {
            ps.setInt(1, reservation.getCar_id());
            ps.setDate(2, reservation.getBeginDate());
            ps.setDate(3, reservation.getEndDate());
            ps.setInt(4, reservation.getTotal_price());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reservation> getReservations(int carId) {
        try (Connection connection = connectionManager.getConnection()) {
            List<Reservation> reservations = new ArrayList<>();
            try (ResultSet resultSet = connection.prepareStatement(getReservationsByCarIdSelect(carId)).executeQuery()) {
                while (resultSet.next()) {
                    reservations.add(getSingleReservation(resultSet));
                }
            }
            return reservations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Reservation getSingleReservation(ResultSet resultSet) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(resultSet.getInt("reservation_id"));
        reservation.setCar_id(resultSet.getInt("reservation_car_id"));
        reservation.setBeginDate(resultSet.getDate("reservation_begin_date"));
        reservation.setEndDate(resultSet.getDate("reservation_end_date"));
        reservation.setTotal_price(resultSet.getInt("reservation_total_price"));
        return reservation;
    }

    private String getReservationsByCarIdSelect(int carId) {
        return "select r.id as reservation_id, r.car_id as reservation_car_id, r.begin_date as reservation_begin_date, " +
                "r.end_date as reservation_end_date, r.total_price as reservation_total_price " +
                "from reservation as r " +
                "where r.car_id = " + carId;
    }
}
