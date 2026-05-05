public class J50{
    public static void main(String[] args) {
        System.out.println("Handling");
        int num1 = 8;
        int num2 = 0;
        int result = 0;
        try{
            result = num1/num2;
            System.out.println(result);
        }catch(ArithmeticException e){
            System.out.println("Divide by zero not allowed");
        }
    }
}
