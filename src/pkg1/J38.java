package pkg1;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

enum Months1{
    Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec
}
public class J38 {
    public static void main(String[] args){
        System.out.println("hello world");

        LocalDate dt1=LocalDate.now();
        System.out.println(dt1);

        LocalTime lt1=LocalTime.now();
        System.out.println(lt1);

        LocalDateTime ldt1=LocalDateTime.now();;
        System.out.println(ldt1);

        Months1 m1= Months1.Feb;
        System.out.println("ShivaRathri festival is in the month of: "+m1);
    }
}
