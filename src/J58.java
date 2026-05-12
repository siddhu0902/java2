abstract class Shape4{
    abstract void findArea();
}
abstract class LargeShape4 extends Shape4{
    abstract void findArea();
}
class Triangle4 extends LargeShape4{
    void findArea(){
        double area =  0.5*10*20;
        System.out.println("area is "+area);
    }
}
public class J58 {
    public static void main(String[] args) {
        System.out.println("Testing Inheritance concept");
        Triangle4 t4 = new Triangle4();
        t4.findArea();
    }
}
