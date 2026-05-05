interface C{
    void show();
    void config();
}
class D implements C{
    public void show(){
        System.out.println("in show");
    }
    public void config(){
        System.out.println("in config");
    }
}
public class J54 {
    public static void main(String[] args) {
        C obj;
        obj = new D();
        obj.show();
        obj.config();

    }

}
