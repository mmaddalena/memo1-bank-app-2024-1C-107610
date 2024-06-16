package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.DepositZeroSumException;
import com.aninfo.model.Account;
import com.aninfo.model.Deposit;
import com.aninfo.model.Withdraw;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService extends TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Deposit createDeposit(Account account, Double amount) {

        if (amount < 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        } else if (amount == 0) {
            throw new DepositZeroSumException("Cannot deposit zero sum");
        }

        if (amount >= 2000) {
            if (amount * 0.1 <= 500.0) {
                amount = amount + amount * 0.1;
            } else {
                amount = amount + 500;
            }
        }
        Deposit deposit = new Deposit(account, amount);
        transactionRepository.save(deposit);
        return deposit;
    }
}
