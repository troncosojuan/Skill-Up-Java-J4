package com.alkemy.wallet.dto;

import com.alkemy.wallet.entity.RoleEntity;
import java.util.List;
import javax.validation.Valid;
import lombok.Data;

@Data
public class UserDto {

  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private RoleDto role;

  private List<@Valid AccountDto> accounts;


}

