package rest.models;


import rest.transaction.Transaction;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long accountId;

    @NotEmpty(message = "Account Number should not be empty")
    private String accountNumber;

    @Min(value = 0, message = "Balance should be greater than 0")
    private int accountBalance;

    @OneToMany(mappedBy="account", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    public Account(String accountNumber, int accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public Account() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(int balance) {
        this.accountBalance = balance;
    }

    @Override
    public String toString() {
        return "Id " + getAccountId() +
                " accountNumber: " + getAccountNumber() +
                " balance: " + getAccountBalance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountBalance == account.accountBalance && Objects.equals(accountId, account.accountId) && Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNumber, accountBalance);
    }
}
