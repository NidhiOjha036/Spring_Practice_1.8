package com.mikado;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

//@Transactional
public class AccountsDAO1 {

    private SimpleJdbcTemplate simpleJdbcTemplate;
    private AccountsDAO accountsDAO;

    public void setAccountsDAO(AccountsDAO accountsDAO)
    {
        this.accountsDAO = accountsDAO;
    }

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate)
    {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    //@Transactional(readOnly=false, propagation=Propagation.MANDATORY,rollbackFor=InsufficientFundsException.class)
    public void withdraw(int id, double amount) throws InsufficientFundsException
    {
        Account account = accountsDAO.getAccount(id);
        double balance = account.getBalance();
        if(balance <= 5000)
         throw new InsufficientFundsException("Funds Insufficient");
        balance = balance-amount;
        account.setBalance(balance);
        accountsDAO.storeAccount(account);
    }

    //@Transactional(readOnly=false, propagation=Propagation.NEVER,rollbackFor=InsufficientFundsException.class)
    public void deposit(int id, double amount) throws Exception
    {
        Account account = accountsDAO.getAccount(id);
        double balance = account.getBalance();
        account.setBalance(balance+amount);
        accountsDAO.storeAccount(account);
    }
   
}
