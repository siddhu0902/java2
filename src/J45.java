abstract class Shape{

}
abstract class Rectangle extends Shape{

}
class Square extends Rectangle{

}
public class J45 {
    public static void main(String[] args) {
        System.out.println("Abstract Class");
        Square s1 =  new Square();
    }
}
