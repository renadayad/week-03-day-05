package com.example.springhandelday2.controoller;


import com.example.springhandelday2.model.CustomerDetails;
import com.example.springhandelday2.servies.CustomerDetaillsServies;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customerdetaild")
public class CustomerDetailsControoller {
    Logger log=LoggerFactory.getLogger(CustomersControoller.class);

    private final CustomerDetaillsServies customerDetaillsServies;

    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getAllCustomerDetails() {
        log.info("customer details are return by through getAllCustomerDetails()");

        return ResponseEntity.status(201).body(customerDetaillsServies.getAllCustomerDetails());
    }

    @PostMapping
    public ResponseEntity addCustomerDetails(@RequestBody CustomerDetails customerDetails) {
        log.info("customer details are added by through addCustomerDetails()");

        customerDetaillsServies.addCustomerDetails(customerDetails);
        return ResponseEntity.status(200).body("customerDetails added!");
    }


}
