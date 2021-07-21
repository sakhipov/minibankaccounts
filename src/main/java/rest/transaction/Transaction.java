package rest.transaction;


import rest.models.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long transactionId;

    private TypeOfTransaction type;
    private int amountOfMoney;
    private Date date;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    public Transaction() {
    }

    public Transaction(TypeOfTransaction type, int amountOfMoney, Long currentTime, Account account) {
        this.type = type;
        this.amountOfMoney = amountOfMoney;
        this.date = new Date(currentTime);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public TypeOfTransaction getType() {
        return type;
    }

    public void setType(TypeOfTransaction type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
