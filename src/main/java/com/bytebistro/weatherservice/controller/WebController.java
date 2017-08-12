package com.bytebistro.weatherservice.controller;

import com.bytebistro.weatherservice.QueryForm;
import com.bytebistro.weatherservice.SignupForm;
import com.bytebistro.weatherservice.model.Subscription;
import com.bytebistro.weatherservice.model.WeatherServiceManager;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.ui.Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Controller
public class WebController extends WebMvcConfigurerAdapter {

    WeatherServiceManager weatherService;
    Connection connect = null;
    String sqlConnection = "jdbc:mysql://cst438.cq7a2r1z7sxe.us-west-2.rds.amazonaws.com/weatherservice?" +
                    "user=cst438&password=cst438123";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("weather");
    }

    @GetMapping("/search")
    public String showForm(SignupForm signupForm) {
        return "search";
    }

    @PostMapping("/signup")
    public String checkSignupInfo(@Valid QueryForm queryForm, BindingResult bindingResult) {
        return "weather";
    }

    @RequestMapping(value = {"/", "/weather"})
    public String weatherService(Model model, @RequestParam(value = "name", required = false, defaultValue = "Escondido") String name) {
        weatherService = new WeatherServiceManager();
        weatherService.callWeatherWebService(name);
        model.addAttribute("name", weatherService.getCityName());
        model.addAttribute("currentTemp", weatherService.getCurrentTemp());
        model.addAttribute("high", weatherService.getHighTemp());
        model.addAttribute("low", weatherService.getLowTemp());
        model.addAttribute("sunrise", weatherService.getSunriseTime());
        model.addAttribute("sunset", weatherService.getSunsetTime());
        model.addAttribute("description", weatherService.getDescription());
        return "weather";
    }

    @RequestMapping("/subscribe")
    public String addSubscription(Model model, @RequestParam(value = "email", required = true, defaultValue = "") String email,
                                  @RequestParam(value = "name", required = true, defaultValue = "") String name,
                                  @RequestParam(value = "location", required = true, defaultValue = "") String location) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(sqlConnection);
            System.out.println("Connected to database");
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO weatherservice.alerts VALUES (?, ?, ?, 1, 1, 1)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, location);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception caught...");
            System.out.println(e);
        } finally {
            System.out.println("Failed.");
            try {
                connect.close();
                System.out.println("Connection closed");
            } catch(Exception e2) {
                // Error closing connection
            }
        }

        return "weather";
    }

    @RequestMapping("/getsubscriptions")
    public @ResponseBody
    Subscription[] getSubscriptions() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(sqlConnection);

            // Get the count of current users
            PreparedStatement subCount = connect.prepareStatement("SELECT COUNT(*) FROM weatherservice.alerts");
            ResultSet count = subCount.executeQuery();
            count.next();
            Subscription[] list = new Subscription[count.getInt(1)];
            for(int i = 0; i < count.getInt(1); i++) {
                list[i] = new Subscription();
            }

            // Dump these users into a Subscriptions[] array
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM weatherservice.alerts");
            ResultSet results = preparedStatement.executeQuery();

            // Iterate through our results and insert them into the array
            int cur_index = 0;
            while(results.next()) {
                list[cur_index].setName(results.getString(1));
                list[cur_index].setEmail(results.getString(2));
                list[cur_index].setLocation(results.getString(3));
                list[cur_index].setHeat(results.getInt(4));
                list[cur_index].setCold(results.getInt(5));
                list[cur_index].setExtreme(results.getInt(6));
                cur_index++;
            };

            return list;
        } catch(Exception e) {
            System.out.println("Caught an exception.");
            System.out.println(e);
        }
        return new Subscription[0];
    }

}
