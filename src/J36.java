class myVehicle{
    int modelYear;
    String modelName;
    public myVehicle(int modelYear, String modelName){
        this.modelYear=modelYear;
        this.modelName=modelName;
    }
}
public class J36 {
    public static void main(String[] args){
        System.out.println("Hello world");
        myVehicle v1=new myVehicle(2010,"Hero Passion");
        myVehicle v2=new myVehicle(2017,"TVS Jupiter");
        System.out.println(v1.modelName+" was purchased in: "+v1.modelYear);
        System.out.println(v2.modelName+" was purchased in: "+v2.modelYear);
    }
}
