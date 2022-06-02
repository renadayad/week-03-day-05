package com.example.springhandelday2.servies;

import com.example.springhandelday2.exception.InvalidException;
import com.example.springhandelday2.model.Bank;
import com.example.springhandelday2.model.CustomerDetails;
import com.example.springhandelday2.model.Customers;
import com.example.springhandelday2.repoistory.BankRepoistory;
import com.example.springhandelday2.repoistory.CustomerDetailsRepoistory;
import com.example.springhandelday2.repoistory.CustomersRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankServies {

    private final BankRepoistory bankRepoistory;
private final CustomerDetailsRepoistory customerDetailsRepoistory;
//private final CustomerDetaillsServies customerDetaillsServies;
    private final CustomersRepoistory customersRepoistory;
    public List<Bank> getAllBank() {

        return bankRepoistory.findAll();
    }

    public void addBank(Bank bank) {
        bankRepoistory.save(bank);

    }

    public void withdrawsmoney(Integer customerDetailsid,Double amount){

      CustomerDetails customerDetails=
        customerDetailsRepoistory.findById(customerDetailsid).orElseThrow(()->{
            throw new InvalidException("Customer id is invaild!");
        });
        customerDetails.setBalance(customerDetails.getBalance()-amount);
    }

    public void depositsawsmoney(Integer customerDetailsid,Double amount){

        CustomerDetails customerDetails=
                customerDetailsRepoistory.findById(customerDetailsid).orElseThrow(()->{
                    throw new InvalidException("Customer id is invaild!");
                });
        customerDetails.setBalance(customerDetails.getBalance()+amount);
    }

    public void addCustomertoBank(Integer customerid,Integer bankid){
        Optional<Customers> customers=customersRepoistory.findById(customerid);
        if(customers.isEmpty()){
            throw new InvalidException("Customer id invalied");
        }
        Optional<Bank> bank=bankRepoistory.findById(bankid);
        if(bank.isEmpty()){
            throw new InvalidException("bank id invailed ");
        }

        //customers.get().getBank().a(bank.get());
        customersRepoistory.save(customers.get());
    }

}//end class
