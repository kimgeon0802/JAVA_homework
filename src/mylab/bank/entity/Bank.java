package mylab.bank.entity;

import java.util.ArrayList;
import mylab.bank.exception.*;

public class Bank {

    private ArrayList<Account> accounts;
    private int nextAccountNumber = 1000;

    public Bank() {
        accounts = new ArrayList<>();
    }

    private String generateAccountNumber() {
        return "AC" + nextAccountNumber++;
    }

    public void createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accNo = generateAccountNumber();
        SavingsAccount account = new SavingsAccount(accNo, ownerName, balance, interestRate);
        accounts.add(account);
        System.out.println("저축 계좌가 생성되었습니다: " + account);
    }

    public void createCheckingAccount(String ownerName, double balance) {
        String accNo = generateAccountNumber();
        CheckingAccount account = new CheckingAccount(accNo, ownerName, balance);
        accounts.add(account);
        System.out.println("체킹 계좌가 생성되었습니다: " + account);
    }
    
    public void applyInterestAll() {
        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }
        }
    }

    private Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException(
                "계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void deposit(String accountNumber, double amount)
            throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
    }

    public void transfer(String fromAcc, String toAcc, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {

        Account from = findAccount(fromAcc);
        Account to = findAccount(toAcc);

        from.withdraw(amount);
        to.deposit(amount);

        System.out.println(amount + "원이 " + fromAcc + "에서 " + toAcc + "로 송금되었습니다.");
    }

    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}