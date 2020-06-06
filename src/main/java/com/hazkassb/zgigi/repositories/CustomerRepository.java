package com.hazkassb.zgigi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hazkassb.zgigi.entities.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
