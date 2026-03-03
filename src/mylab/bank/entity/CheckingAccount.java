package mylab.bank.entity;

import mylab.bank.exception.WithdrawalLimitExceededException;
import mylab.bank.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {

    private double withdrawalLimit = 5000.0;

    public CheckingAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                    "출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
    }
}