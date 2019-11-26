package tugasalpro.utilities;

import java.util.concurrent.TimeUnit;

public class TimeUnitUtility {
 
 public String convertToHHMMSS(long miliSeconds)
 {
  int hrs = (int) TimeUnit.MILLISECONDS.toHours(miliSeconds) % 24;
  int min = (int) TimeUnit.MILLISECONDS.toMinutes(miliSeconds) % 60;
  int sec = (int) TimeUnit.MILLISECONDS.toSeconds(miliSeconds) % 60;
  return String.format("%02d.%02d.%02d", hrs, min, sec);
 }

 public String convertToHHMM(long miliSeconds)
 {
  int hrs = (int) TimeUnit.MILLISECONDS.toHours(miliSeconds) % 24;
  int min = (int) TimeUnit.MILLISECONDS.toMinutes(miliSeconds) % 60;
  int sec = (int) TimeUnit.MILLISECONDS.toSeconds(miliSeconds) % 60;
  return String.format("%02d.%02d", hrs, min, sec);
 }

 public String convToHHMM(long miliSeconds) {
    return String.format("%02d.%02d", TimeUnit.MILLISECONDS.toHours(miliSeconds),
            TimeUnit.MILLISECONDS.toMinutes(miliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(miliSeconds)));
 }

 public long HHMMtoMilis(String jam) {
    final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
    String hour = jam.substring(0,2);
    System.out.println(hour);
    String minute = jam.substring(3,5);
    System.out.println(minute);
    return Integer.valueOf(hour)*60*ONE_MINUTE_IN_MILLIS+Integer.valueOf(minute)*ONE_MINUTE_IN_MILLIS;
 }

}