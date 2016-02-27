package com.mv.controller;

import com.mv.dao.CarDao;
import com.mv.dao.ReservationDao;
import com.mv.model.Car;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class ReservationResource implements TemplateViewRoute {
    private CarDao carDao;
    private ReservationDao reservationDao;

    public ReservationResource(CarDao carDao, ReservationDao reservationDao) {
        this.carDao = carDao;
        this.reservationDao = reservationDao;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        int carId = getCarId(request);
        Car car = carDao.getCarById(carId);
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("car", car);
        attributes.put("reservations", reservationDao.getReservations(carId));
        return new ModelAndView(attributes, "reservation.ftl");
    }

    private Integer getCarId(Request request) {
        return Integer.parseInt(request.params(":id"));
    }
}
