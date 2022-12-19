package com.example.clockshop;

public interface clockInterface
{
    String getName();

    void setName(String _name);

    int getCost();

    void setCost(int _cost);

    void setTime(int[] _time);

    String getTimeAsString();

    int[] getTime();

    void printClock();

    void plusTime(int[] time );
}
