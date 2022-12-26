package com.example.clockshop;

import jakarta.persistence.*;

public class ClockHMS extends ClockHM
{
    public ClockHMS()
    {
        name = "Unknown";
        cost = 0;
        time = new int[] {10, 15, 10};
    }

    public ClockHMS(String _name, int _cost, int[] _time)
    {
        name = _name;
        cost = _cost;
        time = _time;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String _name) {
        name = _name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int[] getTime() {
        return time;
    }

    @Override
    public void setCost(int _cost) {
        cost = _cost;
    }
    @Override
    public String getTimeAsString()
    {
        StringBuilder result = new StringBuilder();
        for (int j : time) result.append(j).append(".");
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    @Override
    public void setTime(int[] _time)
    {
        if (_time.length == 2) {
            if (_time[0] > 23 || _time[0] < 0)
                throw new IllegalArgumentException(_time[0] + " > 23 or < 0");
            else if (_time[1] > 59 || _time[1] < 0)
                throw new IllegalArgumentException(_time[1] + " > 59 or < 0");
            else {
                time[0] = _time[0];
                time[1] = _time[1];
                time[2] = 0;
            }
        }
        else
            if (_time.length == 3) {
                if (_time[0] > 23 || _time[0] < 0)
                    throw new IllegalArgumentException(_time[0] + " > 23 or < 0");
                else if (_time[1] > 59 || _time[1] < 0)
                    throw new IllegalArgumentException(_time[1] + " > 59 or < 0");
                else if (_time[2] > 59 || _time[2] < 0)
                    throw new IllegalArgumentException(_time[2] + " > 59 or < 0");
                else
                    time = _time;
            }
            else
                throw new IllegalArgumentException("Length of time massive must be 2 or 3");
    }

    @Override
    protected void checkTime()
    {
        if (time[2] > 59)
        {
            time[1] += time[2] / 60;
            time[2] %= 60;
        }
        super.checkTime();
    }
    @Override
    public void plusTime(int[] _time)
    {
        time[0] += _time[0];
        time[1] += _time[1];
        time[2] += _time[2];
        checkTime();
    }

    @Override
    public void printClock()
    {
        System.out.println("Name = " + name);
        System.out.println("Cost = " + cost);
        System.out.println("Time = " + getTimeAsString());
    }
}
