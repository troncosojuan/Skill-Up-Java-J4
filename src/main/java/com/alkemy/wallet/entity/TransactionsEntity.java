package com.alkemy.wallet.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class TransactionsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idTrans;
  @NonNull
  private Double amount;
  @NonNull
  private Type type;
  private String description;

  @CreationTimestamp
  private LocalDateTime transactionDate;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "userId")
  private UserEntity userEntity;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "accoundId")
  private AccountEntity accountEntity;



}
