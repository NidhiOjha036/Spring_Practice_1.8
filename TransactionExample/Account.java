package com.mikado;

public class Account implements Comparable<Account>
{
    private int id;
    private String name;
    private double balance;

    public Account()
    {

    }
    public Account(final int id, final String name, final double balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public void setId(final int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    public void setName(final String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setBalance(final double balance)
    {
        this.balance = balance;
    }
    public double getBalance()
    {
        return balance;
    }
    public String toString()
    {
        return id+" "+name+" "+balance;
    }
    public boolean equals(Object o)
    {
        if(o instanceof Account)
        {
            return ((Account)o).getId() == id;
        }
        else
        {
            return false;
        }
    }
    public int hashCode()
    {
        return id;
    }
    public int compareTo(Account account)
    {
        if(account.getId() > id)
         return -1;
        else if(account.getId() == id)
         return 0;
        else
         return 1;
    }

}
