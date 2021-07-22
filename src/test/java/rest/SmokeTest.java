package rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rest.controllers.AccountsController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private AccountsController accountsController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(accountsController).isNotNull();
    }
}
