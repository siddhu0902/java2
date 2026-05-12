class Calculator1{
    int num1;
    int num2;
    int num3;
    int sum1;
    double num4;
    double num5;
    double num6;
    void calc(int num1,int num2){
        System.out.println(num1+num2);
    }
    void calc(int num1,int num2, int num3){
        System.out.println(num1+num2+num3);;
    }
    void calc(double num4,double num5,double num6){
        System.out.println(num4+num5+num6);
    }
}
public class J60 {
    public static void main(String[] args) {
        System.out.println("Concept of Overloading");
        Calculator1 c1 = new Calculator1();
        c1.calc(5,4);
        c1.calc(5,4,3);
        Calculator1 c2 = new Calculator1();
        c2.calc(5.0,4.0,3.0);
    }
}
