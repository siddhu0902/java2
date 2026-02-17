public class J39 {
    public static void main(String[] args){
        System.out.println("Hello world");
        String s1="";
        s1="malayalam";
        char c1;
        char c2;
        boolean isPalin =true;
        int len1=s1.length();
        if (len1%2==0){
         isPalin=false;
        }
        else{
            for (int i=0;i<len1/2;i++){
                c1=s1.toLowerCase().charAt(i);
                c2=s1.toLowerCase().charAt(len1-(i+1));
                if (c1!=c2){
                    isPalin=false;
                }
                System.out.println(c1+" - "+c2+" "+isPalin);
            }
        }
        if (isPalin){
            System.out.println(s1+" is a Palindrome");
        }
    }
}
