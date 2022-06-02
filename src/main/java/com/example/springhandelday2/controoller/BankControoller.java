package com.example.springhandelday2.controoller;


import com.example.springhandelday2.model.Api;
import com.example.springhandelday2.model.Bank;
import com.example.springhandelday2.servies.BankServies;
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
@RequestMapping("api/v1/bank")
public class BankControoller {
    Logger log=LoggerFactory.getLogger(CustomersControoller.class);

    private final BankServies bankServies;

    @GetMapping
    public ResponseEntity<List<Bank>> getAllBank() {
        log.info("bank are return by through getAllBank()");

        return ResponseEntity.status(201).body(bankServies.getAllBank());
    }

    @PostMapping
    public ResponseEntity addBank(@RequestBody Bank bank) {

        log.info("bank are added by through addBank()");

        bankServies.addBank(bank);
        return ResponseEntity.status(200).body("bank added!");
    }
    @PostMapping("/withdrawsmoney/{customerdetaliesid}/amount")

    public ResponseEntity<Api>withdrawsmoney(@PathVariable Integer customerdetaliesid,@PathVariable Double amount){
        log.info("withdrawsmoney are return by through withdrawsmoney()");

        bankServies.withdrawsmoney(customerdetaliesid,amount);
        return ResponseEntity.status(201).body(new Api("withdrawsmoney is commpleted",201));
    }

    @PostMapping("/depositsawsmoney/{customerdetaliesid}/amount")

    public ResponseEntity<Api>depositsawsmoney(@PathVariable Integer customerdetaliesid,@PathVariable Double amount){
        log.info("depositsawsmoney are return by through depositsawsmoney");

        bankServies.depositsawsmoney(customerdetaliesid,amount);
        return ResponseEntity.status(201).body(new Api("depositsawsmoney is commpleted",201));
    }

    @PostMapping("/enrooledcustomer/{customerid}/{bankid}")
    public ResponseEntity enroledCustomerToBank(@PathVariable Integer customerid,@PathVariable Integer bankid){
        log.info("added customer to bank");

        bankServies.addCustomertoBank(customerid,bankid);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Customer enrooled to bank",201));
    }
}
