package BYT9;

import oracle.jdbc.driver.Message;

import java.util.Observer;

public interface Subject {
    public void attach(ConcreteObserver observer);
    public void detach(ConcreteObserver observer);
    public void notifyUpdate();
}
