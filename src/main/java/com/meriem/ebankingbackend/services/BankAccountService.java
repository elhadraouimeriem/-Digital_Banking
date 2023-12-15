package com.meriem.ebankingbackend.services;

import com.meriem.ebankingbackend.entities.BankAccount;
import com.meriem.ebankingbackend.entities.CurrentAccount;
import com.meriem.ebankingbackend.entities.Customer;
import com.meriem.ebankingbackend.entities.SavingAccount;
import com.meriem.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.meriem.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.meriem.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;

    SavingAccount saveSavingBankAccount(double initialBalance, double inerestRate, Long customerId) throws CustomerNotFoundException;

    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit (String accountId ,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit (String accountId, double amount, String description) throws BalanceNotSufficientException, BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccount> bankAccountList();
}
