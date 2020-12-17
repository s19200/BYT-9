package BYT9;

import java.util.Date;

public class Memento {
    private Date state;

    public Memento(Date state){
        this.state = state;
    }

    public Date getState(){
        return state;
    }
}
