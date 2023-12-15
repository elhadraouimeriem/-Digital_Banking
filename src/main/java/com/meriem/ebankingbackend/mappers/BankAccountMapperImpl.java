package com.meriem.ebankingbackend.mappers;

import com.meriem.ebankingbackend.dtos.CustomersDTO;
import com.meriem.ebankingbackend.entities.Customer;
import org.springframework.beans.BeanUtils;

public class BankAccountMapperImpl {
    public CustomersDTO fromCustomer(Customer customer){
        CustomersDTO customersDTO=new CustomersDTO();
        BeanUtils.copyProperties(customer,customersDTO);
        //customersDTO.setId(customer.getId());
        //customersDTO.setName(customer.getName());
        //customersDTO.setEmail(customer.getEmail());

        return customersDTO;
    }
    public Customer fromCustomerDTO(CustomersDTO customersDTO){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customersDTO,customer);
        return customer;
    }
}
