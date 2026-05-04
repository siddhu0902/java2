class Vehicle{
    int speed;
    void run(){
        System.out.println("Vehicle is running");
    }
}
class Car1 extends Vehicle{
    int numberofDoors;
    void run(){
        System.out.println("Car is running");
    }
}
class ElectricCar extends Car1{
    int batteryCapacity;
    void run(){
        System.out.println("Electric Vehicle makes no noise");
    }
}
public class J43 {
    public static void main(String[] args){
        System.out.println("Inheritance");
        Vehicle v1 = new Vehicle();
        Car1 c1 = new Car1();
        ElectricCar ev1 = new ElectricCar();
        v1.run();
        c1.run();
        ev1.run();
    }
}
