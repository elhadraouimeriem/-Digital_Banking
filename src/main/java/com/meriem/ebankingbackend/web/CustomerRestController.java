package com.meriem.ebankingbackend.web;

import com.meriem.ebankingbackend.entities.Customer;
import com.meriem.ebankingbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@Slf4j

public class CustomerRestController {
    @Autowired
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<Customer> customers(){
        return bankAccountService.listCustomers();
    }
}
