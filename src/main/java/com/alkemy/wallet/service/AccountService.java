package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.AccountListDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
  List<AccountListDto> getAccountsById(Long id);
}
