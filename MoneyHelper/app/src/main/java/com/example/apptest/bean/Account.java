package com.example.apptest.bean;

import org.litepal.crud.LitePalSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account extends LitePalSupport {
    private String account;

    private String password;
}
