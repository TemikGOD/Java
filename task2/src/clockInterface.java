public interface clockInterface
{
   void inputPrice(int _price);

   void inputName(String _name);

   void inputTime();

    void printClock();

    default void error()
    {
        System.out.println("Incorrect value");
    }


}
