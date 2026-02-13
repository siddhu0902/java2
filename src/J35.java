class MyCar{
    int modelYear;
    String modelName;
    public MyCar(int year, String name){
        modelYear=year;
        modelName=name;
    }
}
public class J35 {
    public static void main(String[] args){
        MyCar c1=new MyCar(2005,"Unknown");
        MyCar c2=new MyCar(2010,"Hyundai i10");
        MyCar c3=new MyCar(2017,"Honda Jazz");
        System.out.println(c1.modelName+" was purchased in: "+c1.modelYear);
        System.out.println(c2.modelName+" was purchased in: "+c2.modelYear);
        System.out.println(c3.modelName+" was purchased in: "+c3.modelYear);
    }
}
