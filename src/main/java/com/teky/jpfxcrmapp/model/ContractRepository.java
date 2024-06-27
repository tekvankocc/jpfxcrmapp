package com.teky.jpfxcrmapp.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Integer> {

    List<Contract> findAllByOrderByStatus();

    void deleteByCustomer(Customer customer);
}
