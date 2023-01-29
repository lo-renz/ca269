import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int alarm_hour = input.nextInt();
        int alarm_min = input.nextInt();
        int alarm_in_mins = (60 * alarm_hour) + alarm_min;

        int current_hour = 0;
        int current_min = 0;
        int current_in_mins = (60 * current_hour) + current_min;

        int false_alarm = -1;

        do {
            current_hour = input.nextInt();
            current_min = input.nextInt();
            current_in_mins = (60 * current_hour) + current_min;
            false_alarm += 1;
        } while(current_in_mins < alarm_in_mins);

        System.out.println("false alarms: " + false_alarm);
    }
}
