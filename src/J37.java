class myVillage{
    public void getHouseDetails(){
        System.out.println("These are the details of my private house");
    }
    public void getTempleDetails(){
        System.out.println("These are the details of our public temple");
    }
}
public class J37 {
    public static void main(String[] args){
        System.out.println("Hello world");
        myVillage mv1=new myVillage();
        mv1.getHouseDetails();
        mv1.getTempleDetails();
    }
}
