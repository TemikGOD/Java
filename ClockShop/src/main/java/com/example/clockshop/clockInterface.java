package com.example.clockshop;

import java.util.Scanner;
public interface clockInterface
{
    public String getName();

    public int getCost();

    public int[] getTime();

   default int inputPrice(int _price)
   {
       System.out.println("Input price: ");
       Scanner sc = new Scanner(System.in);
       if (sc.nextInt() < 0)
           throw new IllegalArgumentException("Price can't be negative");
       else
           return sc.nextInt();
   }

   default String inputName()
   {
       System.out.println("Input name: ");
       Scanner sc = new Scanner(System.in);
       return sc.nextLine();
   }

    int[] inputTime();

    void printClock();

    void changeTime();
}
