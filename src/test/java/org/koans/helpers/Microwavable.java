package org.koans.helpers;

public class Microwavable
{
  public String Name;
  public int    FunFactor;
  public String Effect;
  public String ___ = Koans.___;
  public static Microwavable create()
  {
    return new Microwavable();
  }
  public Microwavable Name(String name)
  {
    this.Name = name;
    return this;
  }
  public Microwavable FunFactor(int funFactor)
  {
    this.FunFactor = funFactor;
    return this;
  }
  public Microwavable Effect(String effect)
  {
    this.Effect = effect;
    return this;
  }
  @Override
  public String toString()
  {
    return Name + "(" + FunFactor + ")";
  }
}
