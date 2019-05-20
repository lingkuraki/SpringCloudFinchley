package com.kuraki.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
}
