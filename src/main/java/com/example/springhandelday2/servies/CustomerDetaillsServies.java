package com.example.springhandelday2.servies;

import com.example.springhandelday2.model.CustomerDetails;
import com.example.springhandelday2.repoistory.CustomerDetailsRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetaillsServies {

    private final CustomerDetailsRepoistory customerDetailsRepoistory;

    public List<CustomerDetails> getAllCustomerDetails() {

        return customerDetailsRepoistory.findAll();
    }

    public void addCustomerDetails(CustomerDetails customerDetails) {
      customerDetailsRepoistory.save(customerDetails);

    }


}//end class
