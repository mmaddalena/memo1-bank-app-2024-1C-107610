package com.aninfo.model;

import javax.persistence.Entity;

@Entity
public class Deposit  extends Transaction {
    public Deposit() {
        super();
    }

    public Deposit(Account account, Double amount) {
        super(account, amount);
    }
}
