package com.aninfo.model;

import javax.persistence.Entity;

@Entity
public class Withdraw extends Transaction {
    public Withdraw() {
        super();
    }

    public Withdraw(Account account, Double amount) {
        super(account, amount);
    }

}
