package com.mv.controller;

import com.mv.dao.CarDao;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class CarsResource implements TemplateViewRoute {
    private CarDao carDao;

    public CarsResource(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("cars", carDao.getAvaibleCars());
        return new ModelAndView(attributes, "cars.ftl");
    }
}
