package com.alkemy.wallet.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")

public class Account implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idAccount;


  @ManyToOne
  @JoinColumn(name = "currency")
  @NotNull
  private AccountTypeEnum currency;

  public AccountTypeEnum getAccountType() {
    return currency;
  }

  public void setAccountType(AccountTypeEnum currency) {
    this.currency = currency;
  }

  public <AccountDTO> Account(Long id) {
    this.id = id;
  public enum currency{ars, usd};

    public AccountDTO convertEntityToDTO() {
      return new ModelMapper().map(this, AccountDTO.class);
    }

  @Column(name = "transactionLimit", nullable = false)
  private double transactionLimit;

  @Column(name = "balance", nullable = false)
  private double balance;

  @Column(name = "userId", nullable = false)
  private Long userId;







}
