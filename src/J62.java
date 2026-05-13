class Customer{
    String name;
    int mobileNo;

    Customer(String name,int mobileNo){
        this.name=name;
        this.mobileNo=mobileNo;
    }
    void getDetails(){
        System.out.println("Customer "+ this.name+ " visited our shop today");
    }

}
class OnlineCustomer extends Customer{
    int discount = 10;
    OnlineCustomer(String name,int mobileNo){
        super(name,mobileNo);
    }

    @Override
    void getDetails(){
        System.out.println("Customer "+this.name+ " logged into our website today");
    }
}
public class J62 {
    public static void main(String[] args) {
        System.out.println("Customer Demo");
        Customer c1 = new Customer("Suresh", 123);
        OnlineCustomer oc1 = new OnlineCustomer("Ramesh", 456);
        c1.getDetails();
        oc1.getDetails();
    }
}
