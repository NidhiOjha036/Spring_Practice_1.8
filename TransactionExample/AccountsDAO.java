package com.mikado;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

//@Transactional
public class AccountsDAO {

    private SimpleJdbcTemplate simpleJdbcTemplate;

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate)
    {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    private AccountsDAO1 accountsDAO1;

    public void setAccountsDAO1(AccountsDAO1 accountsDAO1)
    {
        this.accountsDAO1 = accountsDAO1;
    }

    //@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
    public void performTransaction(Account account1, Account account2, double amount) throws Exception
    {
        accountsDAO1.withdraw(account1.getId(),amount);
        accountsDAO1.deposit(account2.getId(),amount);
    }

    //@Transactional(readOnly=true, propagation=Propagation.MANDATORY)
    public Account getAccount(final int id)
    {
        Account account = simpleJdbcTemplate.queryForObject("select name,balance from accounts where id = ?",new ParameterizedRowMapper<Account>()
        {
            public Account mapRow(ResultSet rs, int rowNum)
            {
                Account account = new Account();
                try {
                    account.setId(id);
                    account.setName(rs.getString("name"));
                    account.setBalance(rs.getDouble("balance"));
                } catch (Exception e) {
                    System.out.println(e);
                }
                return account;
            }

        },id);
        return account;
    }

    //@Transactional(readOnly=false, propagation=Propagation.MANDATORY)
    public void storeAccount(Account account)
    {
        int i = simpleJdbcTemplate.update("update accounts set balance = ? where id = ?",account.getBalance(),account.getId());
    }
}
