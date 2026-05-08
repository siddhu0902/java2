interface FourWheeler3{
}
class Car3 implements FourWheeler3{
    void getDetails(){
        System.out.println("This is a Car");
    }
}
class ElectricCar3 extends Car3{
    void getDetails(){
        System.out.println("This is a ElectricCar");
    }
}