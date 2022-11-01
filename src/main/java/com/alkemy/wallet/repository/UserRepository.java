package com.alkemy.wallet.repository;

import com.alkemy.wallet.model.User;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findAll(Specification<User> spec);

}
