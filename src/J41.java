public class J41 {
    public static int[] calcDays(){
        int[] years={2026,2027,2028,2029,2030};     //Single dimension Array
        int[] isLeap={0,0,1,0,0};
        int[] totalDays={0,0,0,0,0};
        String[] months={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        int year1=0;
        int total=0;
        for (int j=0;j<years.length;j++){
            year1=years[j];
            total=0;
            for (int i=0;i<months.length;i++){
                total=total+days[i];
            }
            total=total+isLeap[j];
            totalDays[j]=total;
        }
        return totalDays;
    }
    public static void main(String[] args){
        System.out.println("Days in a year");
        int[] result=calcDays();
        for(int i=0;i<result.length;i++){
            System.out.println("There are "+result[i]+" days in the year");
        }
    }
}
