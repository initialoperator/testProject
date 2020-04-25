package com.chrystian.yelp;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args){
        TimeRange query = new TimeRange(4, 10);
        TimeRange b1 = new TimeRange(0, 5);
        TimeRange b2 = new TimeRange(9, 10);
        TimeRange b3 = new TimeRange(5, 8);

        List<TimeRange> openHours = new ArrayList<>();
        openHours.add(b1);
        openHours.add(b2);
        openHours.add(b3);
        System.out.println(openHoursRatio(query, openHours));
    }


private static class TimeRange{
        float start;
        float end;

        public TimeRange(float start, float end){
            this.start = start;
            this.end = end;
        }

}

    public static float openHoursRatio(TimeRange queryTimeRange, List<TimeRange> openHours) {
        int startHour = (int)queryTimeRange.start;
        int startMin = (int)((queryTimeRange.start - startHour) * 100);
        int endHour = (int)queryTimeRange.end;
        int endMin = (int)((queryTimeRange.end - endHour) * 100);
        int[][] range = new int[24][60];//24hours 60 minutes, initial slot is all 0

        for(TimeRange o: openHours){
            int oStartHour = (int)o.start;
            int oStartMin = (int)((o.start - oStartHour) * 100);
            int oEndHour = (int)o.end;
            int oEndMin = (int)((o.end - oEndHour) * 100);

            for(int h = oStartHour; h <= oEndHour; h++){
                for(int m = oStartMin; m < (h  == oEndHour?oEndMin:60); m++){
                    range[h][m] = 1;
                }
            }
        }
        int countOpenMinute = 0;
        int totalMinute = 0;
        for(int h = startHour; h <= endHour; h++){
            for(int m = startMin; m < (h  == endHour?endMin:60); m++){
                if(range[h][m] == 1)
                    countOpenMinute++;
                totalMinute++;
            }
        }
        return (float)countOpenMinute / (float)totalMinute;
    }
}
