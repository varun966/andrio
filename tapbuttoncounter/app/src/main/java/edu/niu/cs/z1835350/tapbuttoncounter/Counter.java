package edu.niu.cs.z1835350.tapbuttoncounter;

//Model for counter creates a new counter object, adds 1 to it
public class Counter {

    private Integer counter;

    public Counter(){
        counter = 0;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public void addCounter(){
        counter++;
    }
}
