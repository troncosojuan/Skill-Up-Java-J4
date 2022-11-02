package com.alkemy.wallet.auth.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Data
public class UserAuthDto {
  @Email(message = "Username must be an email")
  private String email;
  @Size(min = 8)
  private String password;
}