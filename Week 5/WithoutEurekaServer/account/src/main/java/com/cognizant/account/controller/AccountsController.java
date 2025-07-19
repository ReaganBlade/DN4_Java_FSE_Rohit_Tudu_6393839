package com.cognizant.account.controller;

import com.cognizant.account.models.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("/accounts/{number}")
    private Account getAccount(@PathVariable String number) {
        Account account = new Account();
        account.setNumber(number);
        account.setType("savings");
        account.setBalance(234343);
        return account;
    }
}
