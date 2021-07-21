package rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rest.models.Account;
import rest.repositories.AccountRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final AccountRepository accountRepository;

    @Autowired
    public DatabaseLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Account account1 = new Account("1234", 100);
        Account account11 = new Account("11223344", 200);
        Account account2 = new Account("5678", 300);

        this.accountRepository.save(account1);
        this.accountRepository.save(account11);
        this.accountRepository.save(account2);
    }
}
