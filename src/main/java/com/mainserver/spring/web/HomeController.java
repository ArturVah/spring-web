package com.mainserver.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/string", method = RequestMethod.GET)
    public String homePageString() {
        return "home";
    }

    @RequestMapping(value = "/mm/param", method = RequestMethod.GET)
    public String homePageModelMapWithParameter(ModelMap modelMap, HttpServletRequest request) {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        modelMap.put("parameter", a + b);
        return "home";
    }

    @RequestMapping(value = "/mm", method = RequestMethod.GET)
    public String homePageModelMap(ModelMap modelMap) {
        modelMap.addAttribute("userName", "valodik");
        return "home";
    }

    @RequestMapping(value = "/mv", method = RequestMethod.GET)
    public ModelAndView homePageModelAndView() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("parameter", "urish valodik");
        return modelAndView;
    }

}