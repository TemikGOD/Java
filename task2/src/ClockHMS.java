public class ClockHMS extends ClockHM
{
    protected final int numberOfHands = 3;

    @Override
    public void setTime(int[] _time)
    {
        if (_time[2] < 0 || _time[2] > 59)
            error();
        else
            super.setTime(_time);
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
}
