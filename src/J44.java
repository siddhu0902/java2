interface Flyable{

}
interface BirdShape{

}
class Aeroplane implements BirdShape, Flyable{          //Multiple Inheritance
    int numberofWings;
    int numberofEngines;
    void run(){
        System.out.println("Aeroplane flies at 30000 feet");
    }

}
public class J44 {
    public static void main(String[] args) {
        System.out.println("Multiple Inheritance for interfaces only");
        Aeroplane a1= new Aeroplane();
        a1.run();
    }
}
