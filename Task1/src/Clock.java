public class Clock {
    protected String name;
    protected int cost;
    protected int hours;
    protected int minutes;

    public Clock()
    {
        name = "Unknown";
        cost = 0;
        hours = 0;
        minutes = 0;
    }

    public Clock(String _name, int _cost, int _hours, int _minutes){
        name = _name;
        cost = _cost;
        hours = _hours;
        minutes = _minutes;
        checkTime();
    }

    public String getName()
    {
        return name;
    }

    public int getCost()
    {
        return cost;
    }

    public int getHours()
    {
        return hours;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public void setHours(int hours)
    {
        this.hours = hours;
    }

    public void setMinutes(int minutes)
    {
        this.minutes = minutes;
    }

    private void checkTime()
    {
        if (minutes > 59)
        {
            hours += minutes / 60;
            minutes %= 60;
        }
        if (hours > 23)
            hours %= 24;
    }

    public void plusTime(int _hours, int _minutes)
    {
        hours += _hours;
        minutes += _minutes;
        checkTime();
    }

    public void printClock()
    {
        System.out.println("Name = " + name);
        System.out.println("Cost = " + cost);
        System.out.println("Hours = " + hours);
        System.out.println("Minutes = " + minutes);
    }
}
