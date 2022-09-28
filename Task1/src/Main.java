public class Main {
    public static void main(String[] args) {
        Clock clock_1 = new Clock();
        clock_1.printClock();
        Clock clock_2 = new Clock("Bebroid", 1905, 27, 43);
        clock_2.printClock();
        clock_2.plusTime(21, 59);
        clock_2.printClock();
    }
}