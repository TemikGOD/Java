package com.example.clockshop;

import java.util.Scanner;

public class ClockHM implements clockInterface {
    protected String name;
    protected int cost;
    private final int numberOfHands = 2;
    protected int[] time = new int[numberOfHands];

    public ClockHM() {
        name = "Unknown";
        cost = 0;
    }

    public ClockHM(String _name, int _cost, int[] _time) {
        name = _name;
        cost = _cost;
        time = _time;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int[] getTime() {
        return time;
    }

    public String getTimeAsString()
    {
        StringBuilder result = new StringBuilder();
        for (int j : time) result.append(j).append(".");
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public void setTime(int[] _time)
    {
        if (_time[0] > 23 || time[0] < 0)
            throw new IllegalArgumentException(_time[0] + " > 23 or < 0");
        else
            if (time[1] > 59 || time[1] < 0)
                throw new IllegalArgumentException(_time[1] + " > 59 or < 0");
            if (time.length != 2)
            {
                time[0] = _time[0];
                time[1] = _time[1];
            }
            else
                time = _time;
    }

    protected void checkTime()
    {
        if (time[1] > 59)
        {
            time[0] += time[1] / 60;
            time[1] %= 60;
        }
        if (time[0] > 23)
            time[0] %= 24;
    }

    public void plusTime(int[] _time)
    {
        time[0] += _time[0];
        time[1] += _time[1];
        checkTime();
    }

    @Override
    public void printClock()
    {
        System.out.println("Name = " + name);
        System.out.println("Cost = " + cost);
        System.out.println("Time = " + getTimeAsString());
    }

    @Override
    public int[] inputTime()
    {
        System.out.println("Input time: ");
        Scanner sc = new Scanner(System.in);
        int[] _time = new int[time.length];
        for (int i = 0; i < time.length; i++)
        {
            if (sc.nextInt() < 0)
                throw new IllegalArgumentException(_time[i] + " < 0");
            else
                if (i == 0 && sc.nextInt() > 23)
                    throw new IllegalArgumentException(_time[i] + " > 23");
                else
                    if (i > 0 && sc.nextInt() > 59)
                        throw new IllegalArgumentException(_time[i] + " > 59");
                    else
                        _time[i] = sc.nextInt();
        }
        return _time;
    }

    @Override
    public void changeTime()
    {
        System.out.println("Input how you want to change time: ");
        Scanner sc = new Scanner(System.in);
        int[] _time = new int[time.length];
        for (int i = 0; i < time.length; i++)
            _time[i] = sc.nextInt();
        plusTime(_time);
    }
}
