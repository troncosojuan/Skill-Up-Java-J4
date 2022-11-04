package com.alkemy.wallet.controller;

import com.alkemy.wallet.dto.AccountDto;
import com.alkemy.wallet.dto.AccountListDto;
import com.alkemy.wallet.service.AccountService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.session.ReactiveSessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AccountController {

  private AccountService accountService;

  @Autowired
  AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @Secured(value = {"ROLE_ADMIN"})
  @GetMapping("/accounts/{userId}")
  public ResponseEntity<List<AccountListDto>> getAccountsById(@Valid @PathVariable Long id) {
    List<AccountListDto> accounts = this.accountService.getAccountsById(id);
    return ResponseEntity.ok(accounts);
  }


}






