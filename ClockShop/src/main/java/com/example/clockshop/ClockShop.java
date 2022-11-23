package com.example.clockshop;

import java.util.*;

public class ClockShop {
    protected ArrayList<ClockHM> ArList = new ArrayList<>();

    public ClockShop()
    {
        int[] time1 = {22, 33};
        int[] time2 = {22, 55, 59};
        Collections.addAll(ArList, new ClockHMS(), new ClockHM(),
                                   new ClockHM("Abiba", 55565, time1),
                                   new ClockHMS("Aboba", 546400, time2));
    }

    public void addElem(ClockHM _clock)
    {
        ArList.add(_clock);
    }

    public ClockHM mostExpensiveClock()
    {
        Comparator<ClockHM> comparator = Comparator.comparingInt(ClockHM::getCost);
        return Collections.max(ArList, comparator);
    }

    public void setTimeOnAllClocks(int[] _time)
    {
        for (ClockHM o: ArList)
            o.setTime(_time);
    }

    public String getMostPopularName()
    {
        HashMap<Integer, String> HMap = new HashMap<>();
        for (int i = 0; i < ArList.size(); i++)
            HMap.put(i, ArList.get(i).getName());
        int key = 0;
        for (int i = 0; i < ArList.size() - 1; i++)
        {
            int count = 1;
            for (int j = i + 1; j < ArList.size(); j++)
            {
                if (HMap.get(i).equals(HMap.get(j)))
                    count++;
                if (count >= ArList.size())
                    break;
            }
            if (count >= ArList.size())
            {
                key = i;
                break;
            }
        }
        return HMap.get(key);
    }

    public SortedSet<String> getSortedNames()
    {
        SortedSet<String> SortClock = new TreeSet<>();
        for (ClockHM o : ArList)
            SortClock.add(o.getName());
        return SortClock;
    }
}