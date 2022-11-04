package com.alkemy.wallet.mapper;

import com.alkemy.wallet.dto.AccountListDto;
import com.alkemy.wallet.entity.UserEntity;
import com.alkemy.wallet.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class AccountMap {
  @Autowired
  private AccountRepository accountRepository;

  public List<AccountListDto> accountEntityList2DTOList(List<UserEntity> entities){
    List<AccountListDto> dtos = new ArrayList<>();
    AccountListDto accountListDto;
    for (UserEntity entity : entities){
     accountListDto = new AccountListDto();
     accountListDto.setAccounts(entity.getAccounts());
     dtos.add(accountListDto);
    }
    return dtos;
  }
  /*public AccountListDto accountEntity2Dto(AccountEntity entity){
    AccountDto dto = new AccountDto();
    dto.setId(entity.getId());
    dto.setCurrency(entity.getCurrency());
    dto.setTransactionLimit(entity.getTransactionLimit());
    dto.setBalance(entity.getBalance());
    dto.setUpdateDate(entity.getUpdateDate());
    dto.setCreationDate(entity.getCreationDate());
    return dto;
  }*/



}
