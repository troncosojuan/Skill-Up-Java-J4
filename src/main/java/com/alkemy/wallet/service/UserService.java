package com.alkemy.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

  public boolean deleteById(Long id) throws Exception;

}
