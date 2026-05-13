abstract class Customer1{
    String name;
    int mobileNo;

    Customer1(String name,int mobileNo){
        this.name=name;
        this.mobileNo=mobileNo;
    }
    abstract void getDetails();
    abstract void placeOrder();
    abstract void calculateBill();
}

class OnlineCustomer1 extends Customer1 implements Payable{
    int discount = 10;
    final int MAX_ORDER_LIMIT = 5;
    OnlineCustomer1(String name,int mobileNo){
        super(name,mobileNo);
    }

    @Override
    void getDetails(){
        System.out.println("Customer "+this.name+ " logged into our website today");
    }
    void placeOrder(){
        try{
            System.out.println("Order Placed");
        }catch (Exception e){
            System.out.println("Order Failed");
        }finally{
            System.out.println("Place order on distributor");
        }

    }
    void calculateBill(){
        System.out.println("Bill Calculated");
    }
    public void processPayment(){
        try{
            System.out.println("UPI Payment done");
        }catch (Exception e){
            System.out.println("Payment Failed");
        }

    }
}
public class J63 {
    public static void main(String[] args) {
        System.out.println("Customer Demo");
        OnlineCustomer1 oc1 = new OnlineCustomer1("Ramesh", 456);
        oc1.getDetails();
    }
}
