import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Calculator{
    public static List<Integer> calculate(int num1, int num2){
        List<Integer> list1=new ArrayList<>();
        int sum1=num1+num2;
        int dif1=num1-num2;
        int mul1=num1*num2;
        list1.add(sum1);
        list1.add(dif1);
        list1.add(mul1);
        return list1;
    }
}
public class J33 {
    public static void main(String[] args){
        System.out.println("Hello World");
        Calculator c1=new Calculator();
        System.out.println(c1.calculate(8,4));
        System.out.println(c1.calculate(8,5));
        System.out.println(c1.calculate(5,8));
    }
}
