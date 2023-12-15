package com.meriem.ebankingbackend;

import com.meriem.ebankingbackend.entities.*;
import com.meriem.ebankingbackend.enums.AccountStatus;
import com.meriem.ebankingbackend.enums.OperationType;
import com.meriem.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.meriem.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.meriem.ebankingbackend.exceptions.CustomerNotFoundException;
import com.meriem.ebankingbackend.repositories.AccountOperationRepository;
import com.meriem.ebankingbackend.repositories.BankAccountRepository;
import com.meriem.ebankingbackend.repositories.CustomerRepository;
import com.meriem.ebankingbackend.services.BankAccountService;
import com.meriem.ebankingbackend.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(EbankingBackendApplication.class, args);

	}
@Bean
	CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
		return args -> {
			Stream.of("Meriem","Khadija","Mohamed").forEach(
					name->{
						Customer customer=new Customer();
						customer.setName(name);
						customer.setEmail(name+"@gmail?com");
					   bankAccountService.saveCustomer(customer);
					}
			);
			bankAccountService.listCustomers().forEach(customer -> {
				try {
					bankAccountService.saveCurrentBankAccount(Math.random()*90000,9000,customer.getId());
				    bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5,customer.getId());
					List<BankAccount> bankAccounts=bankAccountService.bankAccountList();
					for(BankAccount bankAccount:bankAccounts){
						for(int i=0;i<10;i++)
							bankAccountService.credit(bankAccount.getId(), 10000+Math.random()*120000,"Credit");
							bankAccountService.debit(bankAccount.getId(),10000+Math.random()*9000,"Debit");
					}
				} catch (CustomerNotFoundException e) {
					e.printStackTrace();
				} catch (BankAccountNotFoundException | BalanceNotSufficientException e) {
					e.printStackTrace();
				}

			});
			};
	}
	//@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							BankAccountRepository bankAccountRepository,
							AccountOperationRepository accountOperationRepository){
		return args -> {
			Stream.of("meriem","abdelali","fatima ezzahra").forEach(name->{
				Customer customer=new Customer();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				CurrentAccount currentAccount=new CurrentAccount();
				currentAccount.setId(UUID.randomUUID().toString());
				currentAccount.setBalance(Math.random()*90000);
				currentAccount.setCreatedAt(new Date());
				currentAccount.setStatus(AccountStatus.CREADTED);
				currentAccount.setCustomer(customer);
				currentAccount.setOverDraft(9000);
				bankAccountRepository.save(currentAccount);
				SavingAccount savingAccount=new SavingAccount();
				savingAccount.setId(UUID.randomUUID().toString());
				savingAccount.setBalance(Math.random()*90000);
				savingAccount.setCreatedAt(new Date());
				savingAccount.setStatus(AccountStatus.CREADTED);
				savingAccount.setCustomer(customer);
				savingAccount.setIntersetRate(5.5);
				bankAccountRepository.save(savingAccount);
			});
			bankAccountRepository.findAll().forEach(acc->{
				for(int i=0 ;i<10;i++ ){
					AccountOperation accountOperation=new AccountOperation();
					accountOperation.setOperatinDate(new Date());
					accountOperation.setAmount(Math.random()*12000);
					accountOperation.setType(Math.random()>0.5? OperationType.DEBIT: OperationType.CREDIT);
					accountOperation.setBankAccount(acc);
					accountOperationRepository.save(accountOperation);
				}

			});
		};
	}

}
