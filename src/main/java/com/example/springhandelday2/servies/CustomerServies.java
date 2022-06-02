package com.example.springhandelday2.servies;

import com.example.springhandelday2.model.Customers;
import com.example.springhandelday2.repoistory.CustomersRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServies {

    private final CustomersRepoistory customersRepoistory;

    public List<Customers> getAllCustomers() {

        return customersRepoistory.findAll();
    }

    public Customers getOneCustomers(Integer customerid) {

        return customersRepoistory.findById(customerid).get();
    }

    public void addCustomers(Customers customers) {
        customersRepoistory.save(customers);

    }


}//end class
