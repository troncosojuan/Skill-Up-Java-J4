package com.alkemy.wallet.service.impl;

import com.alkemy.wallet.auth.repository.UserRepository;
import com.alkemy.wallet.exception.ParamNotFound;
import com.alkemy.wallet.service.UserService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean deleteById(Long id) throws Exception {
    try {
      if (userRepository.existsById(id)){
        userRepository.deleteById(id);
        return true;
      }else {
        throw new Exception();
      }
    }catch (Exception e){
      throw new Exception(e.getMessage());
    }
  }



}
