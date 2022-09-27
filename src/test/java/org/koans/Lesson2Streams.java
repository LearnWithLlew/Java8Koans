package org.koans;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.koans.helpers.Koans;
import org.koans.helpers.Microwavable;

public class Lesson2Streams extends Koans
{
  @Test
  public void introducingItems() throws Exception
  {
    List<Microwavable> objects = ObjectsInMicrowave().collect(Collectors.toList());
    for (Microwavable item : objects)
    {
      String format = "name[fun factor, effect] = %s[%s, %s]";
      System.out.println(String.format(format, item.Name, item.FunFactor, item.Effect));
    }
    assertEquals("Firecrackers", objects.get(_____).Name);
  }
  @Test
  public void streamFilters()
  {
    Microwavable result = ObjectsInMicrowave().filter(x -> x.Name == "Ping Pong Ball").findFirst().get();
    assertEquals(result.Name, ___);
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
  public void selectingPieces()
  {
    Object[] result = ObjectsInMicrowave()//
        .filter(x -> x.Effect == "Glows")//
        .map(x -> new Object[]{x.Name, x.___})//
        .findFirst().get();
    assertEquals("Glows", result[1]);
    assertEquals("Light Bulbs", result[0]);
  }
  @Test
  public void theLeastFun()
  {
    Microwavable result = ObjectsInMicrowave()//
        .sorted((a, b) -> a.___.compareTo(b.___))//
        .findFirst().get();
    assertEquals("Boils", result.Effect);
  }
  @Test
  public void betterSorting()
  {
    Comparator<Microwavable> comparator = Comparator.comparing(m -> m.___);
    Microwavable result = ObjectsInMicrowave()//
        .sorted(comparator)//
        .findFirst().get();
    assertEquals("Boils", result.Effect);
  }
  @Test
  public void StackingOrderBys()
  {
    Comparator<Microwavable> byFun = Comparator.comparing(m -> m.FunFactor);
    Comparator<Microwavable> thenByName = Comparator.comparing(m -> m.Name);
    Microwavable result = ObjectsInMicrowave()//
        .sorted(byFun)//
        .sorted(thenByName.reversed())//
        .findFirst().get();
    assertEquals(___, result.FunFactor);
  }
  @Test
  public void MulitpleOrderBys()
  {
    Comparator<Microwavable> byFun = Comparator.comparing(m -> m.FunFactor);
    Comparator<Microwavable> byName = Comparator.comparing(m -> m.___);
    Comparator<Microwavable> thenByName = byFun.reversed().thenComparing(byName.reversed());
    Microwavable result = ObjectsInMicrowave()//
        .sorted(thenByName)//
        .findFirst().get();
    assertEquals(10, (int)result.FunFactor);
    assertEquals("Twinkies", result.Name);
  }
  @Test
  public void GroupBy()
  {
    Map<Integer, List<Microwavable>> results = ObjectsInMicrowave()//
        .collect(Collectors.groupingBy(x -> x.FunFactor));
    List<Entry<Integer, List<Microwavable>>> sorted = results.entrySet().stream()//
        .sorted(Comparator.comparing(e -> e.getKey()))//
        .collect(Collectors.toList());
    for (Entry<Integer, List<Microwavable>> entry : sorted)
    {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
    assertEquals(sorted.get(0).getKey(), ___);
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
