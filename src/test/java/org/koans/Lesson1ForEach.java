package org.koans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.koans.helpers.Koans;

public class Lesson1ForEach extends Koans
{
  @Test
  public void forEach()
  {
    String names[] = {"Fry",
                      "Hubert J. Farnsworth",
                      "Bender",
                      "Calculon",
                      "Amy",
                      "Hermes",
                      "Professor Farnsworth",
                      "Zoidberg",
                      "Nibbler",
                      "Zapp Brannigan",
                      "Kif"};
    String yKnot = "";
    for (String name : names)
    {
      if (name.length() == 8)
      {
        yKnot = name;
      }
    }
    assertEquals(yKnot, ___);
  }
}
