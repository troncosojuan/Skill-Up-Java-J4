package com.alkemy.wallet.auth.service;

import com.alkemy.wallet.auth.dto.UserAuthDto;
import com.alkemy.wallet.auth.repository.UserRepository;
import com.alkemy.wallet.exception.RepeatedUsername;
import java.util.Collections;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustomService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity = userRepository.findByUsername(username);
    if (userEntity == null) {
      throw new UsernameNotFoundException("username or password not found");
    }
    return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
  }

  public void save(@Valid UserAuthDto userDto) throws RepeatedUsername {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    if (userRepository.findByUsername(userDto.getUsername()) != null) {
      throw new RepeatedUsername("Username repetido");
    }
    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(userDto.getUsername());
    userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

  }


}