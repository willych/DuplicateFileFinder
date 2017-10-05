/**
Willy Choi
ISTE 121 03

When no command line arg is entered calls default constructor
*/

import java.io.*;
import java.util.*;
import java.text.*;

public class TestDups
{
   int fileNum;
   public static void main(String[] args)
   {
      //When command line arg is entered passes the String into constructor
      if(args.length!=0)
      {
         new TestDups(args[0]);
      }
      //When no command line arg is entered calls default constructor
      else
      {
         
         new TestDups();
      }
   }
   public TestDups()
   {
      //Sets default directory to public and calls FindDups
      String defaultDir = "C:\\Public";
      new FindDups(defaultDir);
   }
   public TestDups(String dir)
   {
      //Calls FindDups
      new FindDups(dir);
   }
   public TestDups(ArrayList files)
   {
      //Creates the array and sorts it
      ArrayList fileArray = files;
      CrCComparator ccc = new CrCComparator();
      System.out.println("Sorting Array");
      Collections.sort(fileArray,ccc);
      
      //Prints to file
      System.out.println("Printing File");
      try
      {
         FileWriter outFile = new FileWriter("FindDups.txt");
         PrintWriter out = new PrintWriter(outFile);
         
         for(Object i: fileArray)
         {
            out.write(i.toString());
            //out.newLine();
         }
         out.close();
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }

}