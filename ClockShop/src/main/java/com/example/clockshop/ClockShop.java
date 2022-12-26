package com.example.clockshop;

import java.io.Serializable;
import java.util.*;

public class ClockShop implements Serializable {
    protected List<clockInterface> Shop_of_clocks = new ArrayList<>();

    public List<clockInterface> getShop_of_clocks(){
        return Shop_of_clocks;
    }

    public void setShop_of_clocks(List<clockInterface> _Shop_of_clocks){
        Shop_of_clocks = _Shop_of_clocks;
    }

    public ClockShop()
    {
        int[] time1 = {22, 33};
        int[] time2 = {22, 55, 59};
        Collections.addAll(Shop_of_clocks, new ClockHM(), new ClockHMS(),
                                   new ClockHM("Abiba", 55565, time1),
                                   new ClockHMS("Aboba", 546400, time2));
    }

    /*public ClockShop(ClockHM ... clocks)
    {
        for (ClockHM o: clocks)
            Collections.addAll(Shop_of_clocks, clocks);
    }*/

    public void addElem(clockInterface _clock)
    {
        Shop_of_clocks.add(_clock);
    }

    public clockInterface mostExpensiveClock()
    {
        Comparator<clockInterface> comparator = Comparator.comparingInt(clockInterface::getCost);
        return Collections.max(Shop_of_clocks, comparator);
    }

    public void setTimeOnAllClocks(int[] _time)
    {
        for (clockInterface o: Shop_of_clocks)
            o.setTime(_time);
    }

    public String getMostPopularName()
    {
        HashMap<Integer, String> HMap = new HashMap<>();
        for (int i = 0; i < Shop_of_clocks.size(); i++)
            HMap.put(i, Shop_of_clocks.get(i).getName());
        int key = 0;
        int biggestCount = 1;
        for (int i = 0; i < Shop_of_clocks.size() - 1; i++)
        {
            int count = 1;
            for (int j = i + 1; j < Shop_of_clocks.size(); j++)
            {
                if (HMap.get(i).equals(HMap.get(j)))
                    count++;
                if (count >= Shop_of_clocks.size() / 2 + 1)
                    break;
            }
            if (count >= Shop_of_clocks.size() / 2 + 1)
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
        for (clockInterface o : Shop_of_clocks)
            SortClock.add(o.getName());
        return SortClock;
    }
}