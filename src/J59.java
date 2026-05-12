interface Flyabble{

}
interface NationalFlag{
    String color = "Tri-Color";
}
class Aeroplane1 implements Flyabble,NationalFlag{
    String company;
    int yearOfMfg;
    void getDetails(int yearOfMfg,String company,String color){
        System.out.println("The aeroplane was manufactured in "+yearOfMfg+" by "+company+" It's Color is "+color);
    }
}
public class J59 {
    public static void main(String[] args) {
        System.out.println("Learning interfaces");
        Aeroplane1 a1 = new Aeroplane1();
        a1.getDetails(1990,"Boeing","Red");
    }
}
