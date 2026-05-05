public class J51 {
    public static void main(String[] args) {
        System.out.println("Using finally command");
        int num1 = 8;
        int num2 = 4;
        int result = 0;
        try{
            result = num1/num2;
            System.out.println(result);
        }catch(ArithmeticException e){
            System.out.println("Divide by zero not allowed");
        }finally {
            System.out.println("Clean up of resources before exiting");
        }
    }
}
