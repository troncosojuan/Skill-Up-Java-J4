package com.alkemy.wallet.controller;

import com.alkemy.wallet.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserServiceImpl userServiceImpl;

  @DeleteMapping("/{id}")
  public ResponseEntity deleteById(@PathVariable Long id){
    try {
      userServiceImpl.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. por favor intentee mas tarde.\"}");
    }
  }

}
