package basicMethods;

import java.io.*;
import java.util.*;
import translatorMethods.*;

public class BasicMethods
{
    public static int menu(final Scanner kb)
    {
        //throws
        if(kb == null)
            throw new IllegalArgumentException("menu bad parameters");        
        int choice;

        do
        {
        System.out.println("");
        System.out.println("Please select one of the following");
        System.out.println("");
        System.out.println("1) Translate from English to Al-Bhed");
        System.out.println("2) Translate from Al-Bhed to English");
        System.out.println("3) Quit");
        System.out.println("");
        System.out.print("Choice --> ");

        choice = kb.nextInt();
        kb.nextLine();
 
        if (choice < 1 || choice >3)
            {
            System.out.println("");
            System.out.println("ERROR - PLEASE SELECT A VALID CHIOCE");
            System.out.println("");
            }
        }while(choice < 1 || choice > 3);
            
        return choice;
    }//end menu

    public static String readString(final Scanner kb)
    {
        //throws
        if(kb == null)
            throw new IllegalArgumentException("readString bad parameters");

        String input = "";
        boolean correct;

        do
        {
           do
            {
                System.out.println("");
                System.out.println("Please enter text to be translated:");
                System.out.print("--> ");

                input = kb.nextLine();
            }while(input.isEmpty());
        
            correct = confirm(input, kb);
        
        }while(correct == false);

        return input;
    }//end readString

    private static boolean confirm(final String input, final Scanner kb)
    {
        //throws
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException("confirm bad parameters");
        
        boolean yes, no;
        String choice;

        do
        {
            System.out.println("");
            System.out.println(input);
            System.out.println("");
            System.out.print("Translate this text? (y/n): ");

            choice = kb.nextLine();

            no = choice.trim().equalsIgnoreCase("n") || choice.trim().equalsIgnoreCase("no");
            yes = choice.trim().equalsIgnoreCase("y") || choice.trim().equalsIgnoreCase("yes");

            if(!yes && !no)
            {
                System.out.println("");
                System.out.println("ERROR - please enter yes or no (y/n)");
            }
        }while(!yes && !no);

        if(yes)
            return true;
        else
            return false;
    }//end confirm
    
    public static boolean goAgain(final Scanner kb)
    {
        boolean yes, no;
        String choice;

        do
        {
            System.out.println("");
            System.out.print("Go Again? (y/n) : ");

            choice = kb.nextLine();

            no = choice.trim().equalsIgnoreCase("n") || choice.trim().equalsIgnoreCase("no");
            yes = choice.trim().equalsIgnoreCase("y") || choice.trim().equalsIgnoreCase("yes");

            if(!yes && !no)
            {
                System.out.println("");
                System.out.println("ERROR - please enter yes or no (y/n)");
            }
        }while(!yes && !no);

        if(yes)
            return true;
        else
            return false;   
    }//end goAgain

    public static void printOut(final String str)
    {
         System.out.println("");
         System.out.println(str);
         System.out.println("");
    }//end printOut
}