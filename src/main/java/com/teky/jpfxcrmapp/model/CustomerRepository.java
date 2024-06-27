package com.teky.jpfxcrmapp.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
	List<Customer> findAll();
	List<Customer> findAllByOrderByInformation();
	List<Customer> findAllByOrderByName();
}
