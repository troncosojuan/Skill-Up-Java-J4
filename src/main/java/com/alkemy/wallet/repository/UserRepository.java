package com.alkemy.wallet.repository;

import com.alkemy.wallet.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  List<UserEntity> findAll(Specification<UserEntity> spec);

}
