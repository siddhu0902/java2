//Creating of Abstract

abstract class Car2{
    public abstract void drive();
    public void playMusic(){
        System.out.println("play music");
    }
}

class WagonR extends Car2{
    public void drive(){
        System.out.println("driving wagonR");
    }
}
public class J53 {
    public static void main(String[] args) {
        Car2 obj = new WagonR();
        obj.drive();
        obj.playMusic();
    }
}
