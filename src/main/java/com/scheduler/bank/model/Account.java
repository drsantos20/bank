package com.scheduler.bank.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by drsantos on 7/13/17.
 */

public class Account {
	
    @NotNull
    @Pattern(regexp="(\\d+\\-?)+", message="Invalid account number!")
    private final String number;
    
    @NotNull
    public Account(String number) {
        this.number = number;
    }
    @NotNull
    public String getNumber() {
        return number;
    }
    
}
