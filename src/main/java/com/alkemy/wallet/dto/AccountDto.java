package com.alkemy.wallet.dto;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class AccountDto {

    private Long id;
    private CurrencyList currency;
    private Double transactionLimit;
    private Double balance;
    private Instant updateDate;
    private Instant creationDate;

  }
}
