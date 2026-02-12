class Car{
    public void getSpeed(int maxSpeed){
        System.out.println(maxSpeed);
    }
}
public class J34 {
    public static void main(String[] args){
        System.out.println("Hello World");
        Car maruthi1=new Car();
        Car thar1=new Car();
        Car bmw1=new Car();
        Car benz1=new Car();
        Car volvo1=new Car();
        Car lamborghini1=new Car();

        maruthi1.getSpeed(120);
        thar1.getSpeed(130);
        bmw1.getSpeed(140);
        benz1.getSpeed(150);
        volvo1.getSpeed(160);
        lamborghini1.getSpeed(200);
    }
}
