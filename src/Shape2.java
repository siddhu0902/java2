class Shape2 {
    void getShape(){
        System.out.println("This is a Shape");
    }
}
class Rectangle2 extends Shape2{
    @Override
    void getShape() {
        System.out.println("This is a Rectangle");
    }
}