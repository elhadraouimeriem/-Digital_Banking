package com.meriem.ebankingbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meriem.ebankingbackend.entities.BankAccount;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
public class CustomersDTO {
    private Long id;
    private String name;
    private String email;

}