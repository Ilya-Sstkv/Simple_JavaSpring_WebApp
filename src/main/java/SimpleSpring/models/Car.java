package SimpleSpring.models;

import jakarta.validation.constraints.Size;

public class Car {
    private int id;
    @Size(min = 3, max = 20, message = "- Field 'name' must contain from 3 to 20 characters -")
    private String name;
    @Size(min = 3, max = 20, message = "- Field 'model' must contain from 3 to 20 characters -")
    private String model;
    private int wheelNum;

    public Car(int id, String name, String model, int wheelNum){
        this.id = id;
        this.name = name;
        this.model = model;
        this.wheelNum = wheelNum;
    }

    public Car(){
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWheelNum(int wheelNum) {
        this.wheelNum = wheelNum;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getModel(){
        return this.model;
    }

    public int getWheelNum(){
        return this.wheelNum;
    }
}