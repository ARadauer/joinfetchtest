package com.radauer.joinfetch;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Andreas on 19.11.2016.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select c from Customer c join fetch c.products")
    List<Customer> getAllAsList();

    @Query("select c from Customer c join fetch c.products order by c.id")
    List<Customer> getAllAsListOrdered();

    @Query("select  c from Customer c join fetch c.products")
    Stream<Customer> getAllAsStream();

    @Query("select c from Customer c join fetch c.products order by c.id")
    Stream<Customer> getAllAsStreamOrdered();
}
