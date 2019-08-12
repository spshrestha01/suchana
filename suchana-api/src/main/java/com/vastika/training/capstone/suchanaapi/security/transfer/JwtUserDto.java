package com.vastika.training.capstone.suchanaapi.security.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class JwtUserDto {
    private int id;
    private String username;
    private String role;
}
