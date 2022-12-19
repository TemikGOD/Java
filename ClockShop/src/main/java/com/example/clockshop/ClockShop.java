package com.example.clockshop;

import java.io.Serializable;
import java.util.*;

public class ClockShop implements Serializable {
    protected List<clockInterface> ArList = new ArrayList<>();

    public List<clockInterface> getArList(){
        return ArList;
    }

    public void setArList(List<clockInterface> _ArList){
        ArList = _ArList;
    }

    public ClockShop()
    {
        int[] time1 = {22, 33};
        int[] time2 = {22, 55, 59};
        Collections.addAll(ArList, new ClockHM(), new ClockHMS(),
                                   new ClockHM("Abiba", 55565, time1),
                                   new ClockHMS("Aboba", 546400, time2));
    }

    /*public ClockShop(ClockHM ... clocks)
    {
        for (ClockHM o: clocks)
            Collections.addAll(ArList, clocks);
    }*/

    public void addElem(ClockHM _clock)
    {
        ArList.add(_clock);
    }

    public clockInterface mostExpensiveClock()
    {
        Comparator<clockInterface> comparator = Comparator.comparingInt(clockInterface::getCost);
        return Collections.max(ArList, comparator);
    }

    public void setTimeOnAllClocks(int[] _time)
    {
        for (clockInterface o: ArList)
            o.setTime(_time);
    }

    public String getMostPopularName()
    {
        HashMap<Integer, String> HMap = new HashMap<>();
        for (int i = 0; i < ArList.size(); i++)
            HMap.put(i, ArList.get(i).getName());
        int key = 0;
        int biggestCount = 1;
        for (int i = 0; i < ArList.size() - 1; i++)
        {
            int count = 1;
            for (int j = i + 1; j < ArList.size(); j++)
            {
                if (HMap.get(i).equals(HMap.get(j)))
                    count++;
                if (count >= ArList.size() / 2 + 1)
                    break;
            }
            if (count >= ArList.size() / 2 + 1)
            {
                key = i;
                break;
            }
            else
                if (count > biggestCount) {
                    key = i;
                    biggestCount = count;
                }
        }
        if (biggestCount == 1)
            return "N/A";
        else
            return HMap.get(key);
    }

    public SortedSet<String> getSortedNames()
    {
        SortedSet<String> SortClock = new TreeSet<>();
        for (clockInterface o : ArList)
            SortClock.add(o.getName());
        return SortClock;
    }
}