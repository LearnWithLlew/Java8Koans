package org.koans;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Objects;

import org.junit.Test;
import org.koans.helpers.Koans;

public class Lesson1ForEach extends Koans
{
  @Test
  public void forEach()
  {
    String names = ["john"]
        
  }
  @Test
  public void toNullerCase()
  {
    try
    {
      String name = getName2();
      String display = name.trim().toUpperCase();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      assertEquals(25, e.getStackTrace()[0].getLineNumber());
    }
  }
  @Test
  public void codeWithoutNulls()
  {
    try
    {
      String name = Objects.requireNonNull(getName2());
      String display = name.trim().toUpperCase();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      assertEquals(38, e.getStackTrace()[1].getLineNumber());
    }
  }
  @Test
  public void testName() throws Exception
  {
    String name = "Zach";
    int number = 42;
    double pi = 3.14;
    assertEquals(-1325618168, Objects.hash(name, number, pi));
  }
  public void testname() throws Exception
  {
    long debt = 100_000_000_000_000L;
    int flags = 0b0_0011_1001;
    HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();
  }
  /********************************** helper code below ********************/
  /**
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * @return
   */
  private String getName1()
  {
    return "Neo";
  }
  private String getName2()
  {
    return null;
  }
}
