package com.aninfo.service;

import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Withdraw;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService extends TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    public Withdraw createWithdraw(Account account, Double amount) {

        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        Withdraw withdraw = new Withdraw(account, amount);
        transactionRepository.save(withdraw);
        return withdraw;
    }
}
