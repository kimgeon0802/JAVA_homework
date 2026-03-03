package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.exception.*;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;


public class BankDemo {

    public static void main(String[] args) {

        Bank bank = new Bank();

        try {
            System.out.println("=== 계좌 생성 ===");
            bank.createSavingsAccount("홍길동", 10000, 3.0);
            bank.createCheckingAccount("김철수", 20000);
            bank.createSavingsAccount("이영희", 30000, 2.0);

            bank.printAllAccounts();

            System.out.println("\n=== 입금/출금 테스트 ===");
            bank.deposit("AC1000", 5000);
            bank.withdraw("AC1001", 3000);

            System.out.println("\n=== 이자 적용 테스트 ===");
            bank.applyInterestAll();

            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.transfer("AC1002", "AC1001", 5000);
            System.out.println();

            bank.printAllAccounts();

            // 예외 테스트
            bank.withdraw("AC1001", 6000);
            bank.withdraw("AC1001", 6000);
            bank.deposit("AC9999", 1000);

        } catch (AccountNotFoundException |
                 InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}