class Bird{
    String color="";
    int noOfLegs=2;
    boolean canFly=true;
}
public class J32 {
    public static void main(String[] args){
        System.out.println("hello world");
        Bird parrot1=new Bird();
        Bird crow1 =new Bird();
        parrot1.color="green";
        crow1.color="black";

        System.out.println("about parrot: ");
        System.out.println(parrot1.color);

        System.out.println("about crow: ");
        System.out.println(crow1.color);
    }
}
