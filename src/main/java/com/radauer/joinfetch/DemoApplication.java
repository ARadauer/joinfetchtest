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


    //im grunde liegts nicht an spring data jpa sondern am join fetch verahlten von hibernate
    //https://developer.jboss.org/wiki/HibernateFAQ-AdvancedProblems#jive_content_id_Hibernate_does_not_return_distinct_results_for_a_query_with_outer_join_fetching_enabled_for_a_collection_even_if_I_use_the_distinct_keyword
    @Bean
    public CommandLineRunner demo(CustomerController customerController) {
        return (args) -> {
            customerController.initData();
            customerController.getAllAsList();
            customerController.getAllAsListDistinct();
            customerController.getAllAsListOrdered();
            customerController.getAllAsStream();
            customerController.getAllAsStreamOrdered();
            customerController.getAllAsListByQuery();

        };
    }
}
