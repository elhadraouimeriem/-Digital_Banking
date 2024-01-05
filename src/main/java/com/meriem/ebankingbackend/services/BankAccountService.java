package com.meriem.ebankingbackend.services;

import com.meriem.ebankingbackend.dtos.*;
import com.meriem.ebankingbackend.entities.BankAccount;
import com.meriem.ebankingbackend.entities.CurrentAccount;
import com.meriem.ebankingbackend.entities.Customer;
import com.meriem.ebankingbackend.entities.SavingAccount;
import com.meriem.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.meriem.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.meriem.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomersDTO saveCustomer(CustomersDTO customersDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;

    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double inerestRate, Long customerId) throws CustomerNotFoundException;

    List<CustomersDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit (String accountId ,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit (String accountId, double amount, String description) throws BalanceNotSufficientException, BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomersDTO getCustomer(Long customerId)throws CustomerNotFoundException;

    CustomersDTO updateCustomer(CustomersDTO customersDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO>accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomersDTO> searchCustomers(String keyword);
}
