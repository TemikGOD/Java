import java.util.Scanner;

public class ClockHM implements clockInterface
{
    protected String name;
    protected int cost;
    protected final int numberOfHands = 2;
    protected int[] time = new int[numberOfHands];

    public ClockHM()
    {
        name = "Unknown";
        cost = 0;
        time = new int[numberOfHands];
    }

    public ClockHM(String _name, int _cost, int _time[]){
        name = _name;
        cost = _cost;
        time = _time;
    }

    public String getName()
    {
        return name;
    }

    public int getCost()
    {
        return cost;
    }

    public int[] getTime()
    {
        return time;
    }

    public void setTime(int _time[])
    {
        if (_time[0] > 23 || time[0] < 0 || time[1] > 59 || time[1] < 0)
            error();
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
        System.out.println("-----------------------------------");
        System.out.println("Name = " + name);
        System.out.println("Cost = " + cost);
        System.out.println("Time = ");
        for (int i = 0; i < numberOfHands; i++)
        {
            System.out.print(time[i]);
            if (i != numberOfHands)
                System.out.print('.');
        }
    }
}
