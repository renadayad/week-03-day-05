package com.example.springhandelday2.controoller;


import com.example.springhandelday2.DTO.CustomerDetailsDTO;
import com.example.springhandelday2.model.Api;
import com.example.springhandelday2.model.CustomerDetails;
import com.example.springhandelday2.model.Customers;
import com.example.springhandelday2.repoistory.CustomersRepoistory;
import com.example.springhandelday2.servies.CustomerServies;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class CustomersControoller {
    Logger log=LoggerFactory.getLogger(CustomersControoller.class);

    private final CustomerServies customerServies;
    private final CustomersRepoistory customersRepoistory;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomer() {

        log.info("customer are return by through getAllCustomer");

        return ResponseEntity.status(201).body(customerServies.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customers customers) {
        log.info("customer are added through addCustomer");

        customerServies.addCustomers(customers);
        return ResponseEntity.status(200).body("Customers added!");
    }

    @PostMapping("/details")
    public ResponseEntity addCustomerDetails(@RequestBody CustomerDetailsDTO cd){

        log.info("addCustomerDetails through addCustomerDetails()");

        Customers customer= customersRepoistory.findById(cd.getId()).get();
        CustomerDetails customerDetails=new CustomerDetails(
                null,cd.getAge(),cd.getBalance(),customer);
        customer.setCustomerDetails(customerDetails);
       // customersRepoistory.save(customerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Customer added !",201));
    }


}
