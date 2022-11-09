package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.AccountListDto;
import com.alkemy.wallet.entity.UserEntity;
import com.alkemy.wallet.exception.ParamNotFound;
import com.alkemy.wallet.mapper.AccountMap;
import com.alkemy.wallet.repository.AccountRepository;
import com.alkemy.wallet.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AccountMap accountMap;
  @Override
  public List<AccountListDto> getAccountsById(Long id) {
    UserEntity entity = userRepository.findById(id).orElseThrow(
        ()-> new ParamNotFound("ID User Invalid"));
    List<AccountListDto> accountDtos = this.accountMap.accountEntityList2DTOList(entity.getAccounts());
    return accountDtos;
  }

}
