package zw.kevin.multipledatabasesapp.accountdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zw.kevin.multipledatabasesapp.accountdb.entity.Account;
import zw.kevin.multipledatabasesapp.accountdb.repository.AccountRepository;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountRepository accountRepository;
    @PostMapping("api/v1/account")
    public Account saveAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }
    @GetMapping("api/v1/accounts")
    public List<Account> getAccountList(){
        return accountRepository.findAll();

    }
}
