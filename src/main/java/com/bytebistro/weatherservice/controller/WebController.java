package com.bytebistro.weatherservice.controller;

import com.bytebistro.weatherservice.SignupForm;
import com.bytebistro.weatherservice.WeatherServiceManager;
import javax.validation.Valid;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class WebController  extends WebMvcConfigurerAdapter{
    WeatherServiceManager weatherService;
    
@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("weather");
    }

    @GetMapping("/signup")
    public String showForm(SignupForm signupForm) {
        return "signup";
    }

    @PostMapping("/signup")
    public String checkSignupInfo(@Valid SignupForm signupForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "results";
        else
            return "results";
    }
      @RequestMapping("/weather")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="Escondido") String name) {
        weatherService = new WeatherServiceManager();
        weatherService.callWeatherWebService(name);
        
        model.addAttribute("name", name + " "+ weatherService.getCurrentTemp());
        
        
        return "weather";
    }
}
