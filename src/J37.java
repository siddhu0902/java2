class myVillage{
    private void getHouseDetails(){         //Access modifier is private, so method in line 13 wil not execute.
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
//        mv1.getHouseDetails();      //Java code will not compile because method is 'private'
        mv1.getTempleDetails();
    }
}
