package translatorMethods;

import java.util.*;
import java.io.*;

public class TranslatorMethods
{
    public static String translate(final String str, final int choice)
    {
        char[] temp = str.toCharArray();
        char[] lowArray = str.toLowerCase().toCharArray();
        Character [] array= new Character[temp.length];
        
        for(int x=0; x<array.length; x++)
        {
            array[x] = temp[x];
        }
        
        Character[] newArray = new Character[array.length];
        int group;
        String str2 = "";

        for(int x = 0; x<array.length; x++)
        {
                  boolean check = Character.isUpperCase(array[x]);;
                
                if(check)
                  group = findGroup(lowArray[x]);
                else
                  group = findGroup(array[x]);

                //vowels - 0
                if(group == 0)
                {
                    if(check)
                        newArray[x] = vowelSwitch(lowArray[x], choice);
                    else
                        newArray[x] = vowelSwitch(array[x], choice);      
                }      

                //doubles - 1
                else if(group == 1)
                {                    
                    if(check)
                        newArray[x] = doubleSwitch(lowArray[x]);
                    else
                        newArray[x] = doubleSwitch(array[x]);       
                }

                //triples - 2
                else if(group == 2)
                {                  
                    if(check)
                        newArray[x] = tripleSwitch(lowArray[x], choice);
                    else
                        newArray[x] = tripleSwitch(array[x], choice);   
                }                         

                //quads - 3
                else if(group == 3)
                {                                        
                    if(check)
                        newArray[x] = quadSwitch(lowArray[x], choice);
                    else 
                        newArray[x] = quadSwitch(array[x], choice);
                    
                }  

                //petna - 4
                else if(group == 4)
                {
                    if(check)
                        newArray[x] = pentaSwitch(lowArray[x], choice); 
                    else
                        newArray[x] = pentaSwitch(array[x], choice);    
                }

                //non-alphabet character
                else
                    newArray[x] = array[x];
                    
                if(check)
                {
                  String tempC = "";
                  tempC += newArray[x].charValue();
                  tempC = tempC.toUpperCase();
                  newArray[x] = tempC.charAt(0);
                }
        }

        for(int x=0; x<newArray.length; x++)
        {
            str2 += newArray[x];
        }

        return str2;
        
    }

    private static int findGroup(final char ch)
    {
        //ch is in vowel group - 0
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y')
            return 0;

        //ch is in doubles group - 1
        else if(ch == 't' || ch == 'd' || ch == 'x' || ch == 'q' || ch == 'b' || ch == 'p' || ch == 'g' || ch == 'k')
            return 1;

        //ch is in triples group - 2
        else if(ch == 'r' || ch == 'h' || ch == 'n')
            return 2;

        //ch is in quads group - 3
        else if(ch == 'c' || ch == 'l' || ch == 'm' || ch == 's')
            return 3;

        //ch is in penta group - 4
        else if(ch == 'f' || ch == 'v' || ch == 'j' || ch == 'z' || ch == 'w')
            return 4;

        //ch is not in the alphabet
        else
            return 5;
    }
    
    //group 0
    private static char vowelSwitch(final char ch, final int type)
    {
        //english to alBhed
        if(type == 0)
        {
            if(ch == 'a')
                return 'y';
            if(ch == 'y')
                return 'o';
            if(ch == 'o')
                return 'u';
            if(ch == 'u')
                return 'i';
            if(ch == 'i')
                return 'e';
            if(ch == 'e')
                return 'a';
            
            return '-';//shut up compiler

        }

        //alBhed to Enlgish
        else//type == 1
        {
            if(ch == 'a')
                return 'e';
            if(ch == 'y')
                return 'a';
            if(ch == 'o')
                return 'y';
            if(ch == 'u')
                return 'o';
            if(ch == 'i')
                return 'u';
            if(ch == 'e')
                return 'i';

            return '-';//shut up compiler
        }
    }//end vowelSwitch

    //group 1
    private static char doubleSwitch(final char ch)
    {
        if(ch == 'd')
            return 't';
        if(ch == 't')
            return 'd';
        if(ch == 'q')
            return 'x';
        if(ch == 'x')
            return 'q';
        if(ch == 'b')
            return 'p';
        if(ch == 'p')
            return 'b';
        if(ch == 'k')
            return 'g';
        if(ch == 'g')
            return 'k';

        return '-';//shut up compiler
        
    }

    //group 2
    private static char tripleSwitch(final char ch, final int type)
    {     
        //english to Albhed   
        if(type == 0)
        {
            if(ch == 'r')
                return 'n';
            if(ch == 'n')
                return 'h';
            if(ch == 'h')
                return 'r';
        }

        //albhed to english
        else//type ==1
        {
            if(ch == 'r')
                return 'h';
            if(ch == 'h')
                return 'n';
            if(ch == 'n')
                return 'r';
        }
        
        return '-';// shut up compiler
    }

    //group 3
    private static char quadSwitch(final char ch, final int type)
    {
        if(type == 0)
        {
            if(ch == 'c')
                return 'l';
            if(ch == 'l')
                return 'm';
            if(ch == 'm')
                return 's';
            if(ch == 's')
                return 'c';
        }

        //albhed to english
        else//type ==1
        {
            if(ch == 'c')
                return 's';
            if(ch == 's')
                return 'm';
            if(ch == 'm')
                return 'l';
            if(ch == 'l')
                return 'c';
        } 
        
      return '-';//shut up compiler
    }

    //group 4
    private static char pentaSwitch(final char ch, final int type)
    {
        if(type == 0)
        {
            if(ch == 'f')
                return 'v';
            if(ch == 'v')
                return 'j';
            if(ch == 'j')
                return 'z';
            if(ch == 'z')
                return 'w';
            if(ch == 'w')
                return 'f';    
        }

        //albhed to english
        else//type ==1
        {
            if(ch == 'f')
                return 'w';
            if(ch == 'w')
                return 'z';
            if(ch == 'z')
                return 'j';
            if(ch == 'j')
                return 'v';
            if(ch == 'v')
                return 'f';
        } 
        
        return '-';//shut up compiler
    }
    

}//end class