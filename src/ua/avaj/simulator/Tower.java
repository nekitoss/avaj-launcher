package ua.avaj.simulator;

import java.util.LinkedList;
import java.util.List;

public abstract class Tower {
    private List<Flyable> observers = new LinkedList<>();
    private List<Flyable> observersToRemove = new LinkedList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observersToRemove.add(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable oneOfFlyableListeners : observers) {
            oneOfFlyableListeners.updateConditions();
        }
        for (Flyable oneOfGoneFlyableListeners : observersToRemove) {
            observers.remove(oneOfGoneFlyableListeners);
        }
    }
//  public List<Flyable> getObservers() {
//    return observers;
//  }
}
