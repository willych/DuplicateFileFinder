/**
Willy Choi
ISTE 121 03

Object class for Object called Info
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.util.zip.*;

public class Info
{
   String fName;
   long CRC;
   public Info(String f,long i)
   {
      String fName = f;
      long CRC = i;
   }
   
   public String getFile()
   {
      return fName;
   }
   
   public long getCRC()
   {
      return CRC;
   }
   
   public String toString()
   {
      return getFile() + getCRC();
   }
}