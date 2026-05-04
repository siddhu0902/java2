public class J42 {
    public static void main(String[] args){
        System.out.println("Days in a year");
        int[] years={2026,2027,2028,2029,2030};
        int[] isLeap={0,0,1,0,0};
        String[] months={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        int year1=0;
        int[][] cal1=new int[12][];             // 2-D Array
        for (int i=0;i<12;i++){
            cal1[0][i]=days[i];
            System.out.println(cal1[0][i]);
        }
    }
}
