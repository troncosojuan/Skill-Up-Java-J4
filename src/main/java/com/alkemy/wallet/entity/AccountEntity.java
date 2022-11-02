package com.alkemy.wallet.entity;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@Table(name = "accounts")
@SQLDelete(sql = "UPDATE accounts SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")

public class AccountEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_account", nullable = false)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(name = "currency", nullable = false)
  private CurrencyList currency;

  @Column(name = "transaction_limit", nullable = false)
  private Double transactionLimit;

  @Column(name = "balance", nullable = false)
  private Double balance;

  @Column(name = "update_date")
  private Instant updateDate;

  @Column(name = "creation_date")
  private Instant creationDate;

  @Column(name = "soft_delete")
  private boolean softDelete = Boolean.FALSE;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

}
