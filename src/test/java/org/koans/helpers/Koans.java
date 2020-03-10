package org.koans.helpers;

public class Koans
{
  public static String ___   = "Please fill in the blank";
  public int           _____ = 0;
  public String decode(String string)
  {
    int offshift = 9;
    return push(string, offshift);
  }
  public String push(String string, int offshift)
  {
    StringBuffer b = new StringBuffer();
    for (char c : string.toCharArray())
    {
      b.append((char) (c + offshift));
    }
    return b.toString();
  }
}