package BYT9;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class Website implements Subject {
    public ConcreteObserver observer;
    public String address;
    public Date modifiedDate;

    public Website(String address){
        this.address = address;
    }

    public void updateModifiedDate() throws IOException, InterruptedException {
            URL address = new URL(this.address);
            URLConnection connect = address.openConnection();
            long time = connect.getLastModified();
            modifiedDate = new Date(time);
            notifyUpdate();
    }

    public Date getModifiedState(){
        return modifiedDate;
    }

    public Memento saveStateToMemento() throws IOException {
        Memento newMemento = new Memento(modifiedDate);
        String writeThis = newMemento.getState().toString();
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\IdeaProjects\\UTP\\src\\BYT9\\states"));
        writer.write(writeThis);
        writer.close();
        return newMemento;
    }

    @Override
    public void attach(ConcreteObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(ConcreteObserver observer) {
        this.observer = null;
    }

    @Override
    public void notifyUpdate() {
        observer.update();
    }





}
