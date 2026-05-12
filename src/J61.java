class CalcTexas{
    void calc(int num1,int num2){
        double result;
        System.out.println("(10/3)*3 gives 9.999999");
    }
}
class CalcCasio extends CalcTexas{
    void calc(int num1,int num2){
        System.out.println("(10/3)*3 gives 10.0");
    }
}

public class J61 {
    public static void main(String[] args) {
        System.out.println("Test on Overriding");
        CalcTexas ct1 = new CalcTexas();
        CalcCasio cc1 = new CalcCasio();
        ct1.calc(10,3);
        cc1.calc(10,3);
    }
}
