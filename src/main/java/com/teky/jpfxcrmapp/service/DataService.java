package com.teky.jpfxcrmapp.service;

import com.teky.jpfxcrmapp.model.Customer;
import com.teky.jpfxcrmapp.model.CustomerRepository;
import com.teky.jpfxcrmapp.model.Contract;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import com.teky.jpfxcrmapp.model.ContractRepository;

@Service
public class DataService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ContractRepository contractRepository;

    private String error;

    public boolean saveCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
            return true;
        } catch (TransactionSystemException ex) {
            error = getErrorFromException(ex);
        }
        return false;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAllByOrderByInformation();
    }

    public List<Customer> getCustomersForList() {
        return customerRepository.findAllByOrderByName();
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        contractRepository.deleteByCustomer(customer);
        customerRepository.delete(customer);
    }

    public boolean saveContract(Contract contract) {
        try {
            contractRepository.save(contract);
            return true;
        } catch (TransactionSystemException ex) {
            error = getErrorFromException(ex);
        }
        return false;
    }

    public List<Contract> getContracts() {
        return contractRepository.findAllByOrderByStatus();
    }

    public void updateContractAsDone(Contract contract)
    {
        if(contract.getStatus() == false)
        {
            contract.setStatus(true);
            saveContract(contract);
        }
        else if(contract.getStatus() == true)
        {
            contract.setStatus(false);
            saveContract(contract);
        }
        
    }

    public String getError() {
        return error;
    }

    private String getErrorFromException(TransactionSystemException ex) {
        ConstraintViolationException cve = (ConstraintViolationException) ex.getCause().getCause();
        return cve.getConstraintViolations().iterator().next().getMessage();
    }
}
