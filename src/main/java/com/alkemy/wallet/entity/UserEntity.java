package com.alkemy.wallet.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "users")

@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Getter
@Setter
public class UserEntity implements Serializable {


  public static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idUser;

  @Column(name = "FIRST_NAME", nullable = false)
  private String firstName;

  @Column(name = "LAST_NAME", nullable = false)
  private String lastName;

  @Column(name = "EMAIL", nullable = false)
  private String email;

  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @CreationTimestamp
  private LocalDateTime createDateTime;

  @UpdateTimestamp
  private LocalDateTime updateDateTime;

  @ManyToOne()
  @JoinColumn(name = "roleId")
  private RoleEntity role;

  @OneToMany(mappedBy = "user",
      fetch = FetchType.EAGER,
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.REFRESH,
          CascadeType.PERSIST
      })

  private boolean delete = Boolean.FALSE;

  private List<AccountEntity> accounts = new ArrayList<>();

  private void addAccount(AccountEntity account){
    accounts.add(account);

  }

  private void deleteAccount(AccountEntity account){
    accounts.remove(account);

  }
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof UserEntity)) {
      return false;
    } else {
      UserEntity userEntity = (UserEntity) obj;
      if (this.getIdUser() != null) {
        return this.getIdUser().equals(userEntity.getIdUser());

      } else {
        return false;
      }
    }
  }



}


