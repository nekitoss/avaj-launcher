package ua.avaj.simulator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Tower {
  private List<Flyable> observers = new LinkedList<>();

  public void register(Flyable flyable){
    observers.add(flyable);
  }
  public void unregister(Flyable flyable){
    observers.remove(flyable);
  }
  protected void conditionsChanged(){
    for (Flyable oneOfFlyableListeners : observers)
    {
      oneOfFlyableListeners.updateConditions();
    }
  }
//  public List<Flyable> getObservers() {
//    return observers;
//  }
}
