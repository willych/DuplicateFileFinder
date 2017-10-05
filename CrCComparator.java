/**
Willy Choi
ISTE 121 03

Comparator class
*/

import java.util.Comparator;
public class CrCComparator implements Comparator<Info>
{
   public int compare(Info o1, Info o2)
   {
      //Compares the two Info Objects
      if(o1.getCRC() < o2.getCRC())
      {
         return 1;
      }
      else if(o1.getCRC() > o2.getCRC())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }
   
}