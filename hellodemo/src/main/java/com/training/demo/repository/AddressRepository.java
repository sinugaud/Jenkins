package com.training.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.demo.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
