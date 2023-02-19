import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int alarm_hour = input.nextInt();
        int alarm_min = input.nextInt();
        int alarm_time = (alarm_hour * 60) + alarm_min;

        int current_hour = input.nextInt();
        int current_min = input.nextInt();
        int current_time = (current_hour * 60) + current_min;

        int false_alarms = 0;

        if(current_time < alarm_time) {
            for(;current_time < alarm_time;) {
                false_alarms += 1;
                current_hour = input.nextInt();
                current_min = input.nextInt();
                current_time = (current_hour * 60) + current_min;
            }
        }
        System.out.println("false alarms: "+false_alarms);
    }
}