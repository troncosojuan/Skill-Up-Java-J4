package com.alkemy.wallet.repository;

import com.alkemy.wallet.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <AccountEntity, Long> {

}
