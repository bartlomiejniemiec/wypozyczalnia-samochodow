package controller;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class IndexResource implements TemplateViewRoute {

    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> attributes = new HashMap();
        return new ModelAndView(attributes, "index.ftl");
    }
}
