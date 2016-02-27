package com.mv.controller;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class BasicResource implements TemplateViewRoute {
    private String url;

    public BasicResource(String url) {
        this.url = url;
    }

    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> attributes = new HashMap<>();
        return new ModelAndView(attributes, url);
    }
}