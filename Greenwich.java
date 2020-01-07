
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Greenwich {
    public static void main(String[] args) {
        Scanner userTime = new Scanner(System.in);
        System.out.println("Enter the Date and Time (yyyy-MM-dd HH:mm:ss): ");
        String input = userTime.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(input, formatter);


        ZoneId zid = ZoneId.systemDefault();
        ZoneId utcid = ZoneId.of("UTC");
        ZoneId pstid = ZoneId.of("America/Los_Angeles");

        ZonedDateTime zTime = dateTime.atZone(zid);
        ZonedDateTime utcTime = zTime.withZoneSameInstant(utcid);
        ZonedDateTime pstTime = zTime.withZoneSameInstant(pstid);
        System.out.println(utcTime);
        System.out.println(pstTime);
    }
}