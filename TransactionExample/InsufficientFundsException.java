package com.mikado;

public class InsufficientFundsException extends Exception
{
    String message;
    public InsufficientFundsException(String message)
    {
        this.message = message;
    }
    public String toString()
    {
        return message;
    }
}
