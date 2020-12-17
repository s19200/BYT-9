package BYT9;


import assignment10.ConnectionManager;

public class ConcreteObserver extends Observer {


    public ConcreteObserver(Website w){
        this.website = w;
        w.attach(this);
    }
    @Override
    public void update() {
        System.out.println("The webpage has been updated: " + website.getModifiedState());
    }
}
