package com.alkemy.wallet.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name="accounts")
@SQLDelete(sql = "UPDATE accounts SET deleted = true WHERE id=?")


public class Account implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idAccount;

  public Account() {
  }

  public enum currency{ars, usd};

   private int currencyType;

  Account( int currencyType ) {
    this.currencyType= currencyType;
  }


  @Column(name = "transactionLimit", nullable = false)
  private double transactionLimit;

  @Column(name = "balance", nullable = false)
  private double balance;

  @Column(name = "userId", nullable = false)
  private Long userId;







}
