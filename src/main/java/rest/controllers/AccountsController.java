package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rest.models.Account;
import rest.repositories.AccountRepository;
import rest.repositories.TransactionRepository;
import rest.transaction.Transaction;
import rest.transaction.TypeOfTransaction;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountsController(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        return "accounts/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("account", accountRepository.findById((long) id).orElse(null));
        return "accounts/show";
    }

    @GetMapping("/new")
    public String newAccount(@ModelAttribute("account") Account account) {
        return "accounts/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("account") @Valid Account account,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "accounts/new";

        accountRepository.save(account);
        return "redirect:/accounts";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("account", accountRepository.findById((long) id).orElse(null));//.get()
        return "accounts/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "accounts/edit";

        Account accountToUpdate = accountRepository.findById((long) id).orElse(null);//.get()
        if (accountToUpdate != null) {
            accountToUpdate.setAccountNumber(account.getAccountNumber());
            accountToUpdate.setAccountBalance(account.getAccountBalance());
        }
        accountRepository.save(accountToUpdate);
        return "redirect:/accounts";
    }

    @GetMapping("/{id}/putmoney")
    public String putMoney(Model model, @PathVariable("id") int id) {
        model.addAttribute("account", accountRepository.findById((long) id).orElse(null));//.get()
        return "accounts/putmoney";
    }

    @PostMapping("/{id}/putmoney")
    public String putMoneyDo(@RequestParam("money") int money,
                             @PathVariable("id") int id) {
//        if (bindingResult.hasErrors())
//            return "accounts/putmoney";

//        int amount = Integer.parseInt(money);

        Account accountToUpdate = accountRepository.findById((long) id).orElse(null);//.get()
        if (accountToUpdate != null) {
            accountToUpdate.setAccountBalance(accountToUpdate.getAccountBalance() + money);
        }

        Date date = new Date();
        Transaction transaction = new Transaction(TypeOfTransaction.PUT, money, date.getTime(), accountToUpdate);

        accountRepository.save(accountToUpdate);
        transactionRepository.save(transaction);
        return "redirect:/accounts";
    }

    @GetMapping("/{id}/withdrawmoney")
    public String withdrawMoney(Model model, @PathVariable("id") int id) {
        model.addAttribute("account", accountRepository.findById((long) id).orElse(null));//.get()
        return "accounts/withdrawmoney";
    }

    @PostMapping("/{id}/withdrawmoney")
    public String withdrawMoneyDo(@RequestParam("money") int money,
                                  @PathVariable("id") int id) {
//        if (bindingResult.hasErrors())
//            return "accounts/putmoney";

//        int amount = Integer.parseInt(money);

        Account accountToUpdate = accountRepository.findById((long) id).orElse(null);//.get()
        if (accountToUpdate != null) {
            if (accountToUpdate.getAccountBalance() < money)
                return "redirect:/accounts";
            accountToUpdate.setAccountBalance(accountToUpdate.getAccountBalance() - money);
        }

        Date date = new Date();
        Transaction transaction = new Transaction(TypeOfTransaction.WITHDRAW, money, date.getTime(), accountToUpdate);

        accountRepository.save(accountToUpdate);
        transactionRepository.save(transaction);
        return "redirect:/accounts";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        accountRepository.deleteById((long) id);
        return "redirect:/accounts";
    }

    @GetMapping("/history")
    public String showHistory(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        return "accounts/history";
    }
}
