package com.radauer.joinfetch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerController customerController) {
        return (args) -> {
            customerController.initData();
            customerController.getAllAsList();
            customerController.getAllAsListOrdered();
            customerController.getAllAsStream();
            customerController.getAllAsStreamOrdered();

        };
    }
}
