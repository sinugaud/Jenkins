package com.training.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.demo.entities.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

}
