/**
Willy Choi
ISTE 121 03

Checks Dir for files
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.util.zip.*;

public class FindDups
{
   int fileNum;
   private final int BF_SIZE = 8192;
   ArrayList<Object> fileArray = new ArrayList<Object>();
   public FindDups(String dir)
   {
      check(dir);
   }
   public void check(String dir)
   {
      File startingDir = new File(dir);
      File[] dirList = startingDir.listFiles();
      
      for(File f : dirList)
      {
         //Checks if f is a directory
         if(f.isDirectory())
         {
            check(f.toString());
         }
         //Checks if f is a file
         else if(f.isFile())
         {
            Object info = new Info(f.toString(),getCrc(f));
            fileArray.add(info);
            fileNum++;
         }
         else
         {
            System.out.println(f + " is Hidden");
         }
      }
      System.out.println("Files Processed: " + fileNum);
      new TestDups(fileArray);
   }
   public long getCrc( File aFile )
   {
      
      byte [] buffer = new byte[BF_SIZE];
      CRC32 crc = new CRC32();
      int len = 0;
      long crcValue = -1;

      crc.reset();
      try
      {
         //Creates a BufferedInputStream to read
         BufferedInputStream bis = new BufferedInputStream(new FileInputStream(aFile));

         while ((len = bis.read(buffer)) > -1) 
         {
            crc.update(buffer,0,len);
         }
         
         //Gets the CRC Value
         crcValue = crc.getValue();
         bis.close();
      }
      //Catches any Exceptions
      catch ( Exception e )
      {
         e.printStackTrace();
      }
      
      return crcValue;
		
   } // end getCrc() method

   
}