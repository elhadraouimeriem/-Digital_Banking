package com.meriem.ebankingbackend.dtos;

import com.meriem.ebankingbackend.entities.BankAccount;
import com.meriem.ebankingbackend.enums.OperationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operatinDate;
    private double amount;
    private OperationType type;
    private String description;
}
