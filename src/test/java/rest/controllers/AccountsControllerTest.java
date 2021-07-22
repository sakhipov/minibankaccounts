package rest.controllers;

import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import rest.db.DatabaseLoader;
import rest.models.Account;
import rest.repositories.AccountRepository;
import rest.repositories.TransactionRepository;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountsController.class)
class AccountsControllerTest {

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private MockMvc mockMvc;
//    @Test
//    public void testReturn200() throws Exception {
//        given(repository.getById(any())).willReturn(new Person(42, "Ivan"));
//        mockMvc.perform(get("/person/42")
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//        verify();
//
//        given(this.userVehicleService.getVehicleDetails("sboot"))
//                .willReturn(new VehicleDetails("Honda", "Civic"));
//
//        given(accountRepository.findById(any()))
//                .willReturn(java.util.Optional.of(new Account("11111", 100)));
//    }

    @Test
    void index() {
    }

    @Test
    void show() {
    }

    @Test
    void newAccount() {
    }

    @Test
    void create() {
    }

    @Test
    void edit() {
    }

    @Test
    void update() {
    }

    @Test
    void putMoney() {
    }

    @Test
    void putMoneyDo() {
    }

    @Test
    void withdrawMoney() {
    }

    @Test
    void withdrawMoneyDo() {
    }

    @Test
    void delete() {
    }

    @Test
    void showHistory() {
    }
}