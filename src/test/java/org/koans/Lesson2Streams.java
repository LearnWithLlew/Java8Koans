package org.koans;

import static org.junit.Assert.assertEquals;

import java.io.Closeable;
import java.io.IOException;
import java.util.stream.Stream;

import org.junit.Test;
import org.koans.helpers.Koans;
import org.koans.helpers.Microwavable;

public class Lesson2Streams extends Koans
{
  @Test
  public void streamFilters()
  {
    Microwavable result = ObjectsInMicrowave().filter(x -> x.Name == "Ping Pong Ball").findFirst().get();
    assertEquals(___, result.Name);
  }
  @Test
  public void filter()
  {
    Microwavable result = ObjectsInMicrowave().filter(x -> x.Name == ___).findFirst().get();
    assertEquals("CD", result.Name);
  }
  @Test
  public void mapToObject()
  {
    Microwavable result = ObjectsInMicrowave()//
        .filter(oim -> oim.Effect.contains("S"))//
        .map(oim -> ____)//
        .findFirst().get();
    assertEquals("CD", result.Name);
  }
  @Test
  public void mapToField()
  {
    String result = ObjectsInMicrowave()//
        .filter(x -> x.Name.startsWith("Fire"))//
        .map(x -> x.___)//
        .findFirst().get();
    assertEquals("Firecrackers", result);
  }
  @Test
      public void LinqSelectPieces()

      {
    Microwavable result = ObjectsInMicrowave.Where(x -> x.Effect == "Glows").map(x -> new {x.Name, x.___})//
              .findFirst().get();
          assertEquals("Glows", result.___);
          assertEquals("Light Bulbs", result.Name);
      }
  @Test
  public void TheLeastFun()
  {
    Microwavable result = ObjectsInMicrowave.OrderBy(x -> x.___)//
        .findFirst().get();
    assertEquals("Boils", result.Effect);
  }
  @Test
  public void StackingOrderBys()
  {
    Microwavable result = ObjectsInMicrowave.OrderByDescending(x -> x.FunFactor).OrderByDescending(x -> x.Name)//
        .findFirst().get();
    assertEquals(___, result.FunFactor);
  }
  @Test
  public void MulitpleOrderBys()
  {
    Microwavable result = ObjectsInMicrowave.OrderByDescending(x -> x.FunFactor).ThenByDescending(x -> x.___)//
        .findFirst().get();
    assertEquals(10, result.FunFactor);
    assertEquals("Twinkies", result.Name);
  }
  @Test
      public void GroupBy()
      {
          var results = ObjectsInMicrowave.GroupBy(x -> x.FunFactor / 5).map(groupName -> groupName)
              .OrderBy(g -> g.Key);
          foreach (IGrouping<int, Microwavable> g in results)
          {
              Console.WriteLine(g.Key + ": " + String.Join(", ", g.map(m -> m.Name)));
          }
          assertEquals(results.First().Key, ___);
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
  public static String BlankText = "Please Fill in the Blank ___";
  public static Stream<Microwavable> ObjectsInMicrowave()
  {
    return Stream.of(Microwavable.create().Name("Ping Pong Ball").FunFactor(10).Effect("Ball Of Fire"),
        Microwavable.create().Name("CD").FunFactor(8).Effect("Sparks"),
        Microwavable.create().Name("Firecrackers").FunFactor(7).Effect("Boom"),
        Microwavable.create().Name("Marshmallow Peeps").FunFactor(9).Effect("Expanding Maddness"),
        Microwavable.create().Name("Soap").FunFactor(9).Effect("Bubbles"),
        Microwavable.create().Name("Eggs").FunFactor(8).Effect("Explosion"),
        Microwavable.create().Name("Gremlins").FunFactor(8).Effect("Explosion"),
        Microwavable.create().Name("Twinkies").FunFactor(10).Effect("Expanding Middle"),
        Microwavable.create().Name("Etch a Sketch").FunFactor(5).Effect("Melted Iron Beads"),
        Microwavable.create().Name("Light Bulbs").FunFactor(9).Effect("Glows"),
        Microwavable.create().Name("Water").FunFactor(1).Effect("Boils"),
        Microwavable.create().Name(BlankText).FunFactor(5).Effect(BlankText));
  }
  public Microwavable ____ = ObjectsInMicrowave().reduce((first, second) -> second).get();
}
