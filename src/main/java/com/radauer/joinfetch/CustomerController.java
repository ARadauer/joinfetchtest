package com.radauer.joinfetch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

/**
 * Created by Andreas on 19.11.2016.
 */
@RestController

public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private EntityManager em;

    @RequestMapping(path = "init")
    @Transactional()
    public void initData() {

        for (int i = 1; i < 10; i++) {
            repository.save(new Customer("User " + i));
        }

        for (char c = 'A'; c < 'E'; c++) {
            log.info("Load all Customers and add product " + c);
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                customer.getProducts().add(new Product("Product " + c + " for " + customer.getName()));
                log.info(customer.toString());
            }
        }
    }


    public void getAllAsList() {

        log.info("Get all as list:");
        repository.getAllAsList().forEach((customer -> log.info(customer.toString())));
    }

    public void getAllAsListDistinct() {

        log.info("Get all as list distinct:");
        repository.getAllAsListDistinct().forEach((customer -> log.info(customer.toString())));
    }

    public void getAllAsListOrdered() {

        log.info("Get all as list ordered:");
        repository.getAllAsListOrdered().forEach((customer -> log.info(customer.toString())));
    }

    public void getAllAsStream() {

        log.info("Get all as streams:");
        repository.getAllAsStream().forEach((customer -> log.info(customer.toString())));
    }

    public void getAllAsStreamOrdered() {

        log.info("Get all as streams ordered:");
        repository.getAllAsStreamOrdered().forEach((customer -> log.info(customer.toString())));
    }

    public void getAllAsListByQuery() {

        log.info("Get all as list by query:");
        repository.getAllAsListByQuery().forEach((customer -> log.info(customer.toString())));

    }


}
