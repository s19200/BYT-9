package BYT9;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Website web = new Website("http://www.pja.edu.pl/");
        Website web = new Website("https://sinoptik.pl/");

        ConcreteObserver observer = new ConcreteObserver(web);

        CareTaker careTaker = new CareTaker();
        while(true){
            web.updateModifiedDate();
            careTaker.add(web.saveStateToMemento());
           // Memento newMemento = new Memento(web.modifiedDate);
           // System.out.println(newMemento.getState().toString());

            Thread.sleep(2000);

        }



    }
}

