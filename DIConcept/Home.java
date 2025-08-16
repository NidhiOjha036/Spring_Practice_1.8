package com.mikado;

public class Home
{
    static int homes;
    int homeNo;

    public Home()
    {
        homes = homes+1;
        homeNo = homes;
    }
    public String toString()
    {
        return "Home Number="+homeNo;
    }
}