import java.util.*;
import java.io.*;
import basicMethods.*;
import translatorMethods.*;

public class AlBhedTranslator
{
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        
        do
        {    
            int choice = BasicMethods.menu(kb);

            String input = BasicMethods.readString(kb);
            String newInput;

            if(choice == 1)
            {
                newInput = TranslatorMethods.translate(input, 0);
                BasicMethods.printOut(newInput);
            }

            else if(choice == 2)
            {
                newInput = TranslatorMethods.translate(input, 1);
                BasicMethods.printOut(newInput);
            }

            else
            {
            System.out.println("");
            System.out.println("Goodbye");
            }

        }while(BasicMethods.goAgain(kb));
    }//end main
}//end class