package s466351.area;

public enum   DayTime {
    MORNING,
    AFTERNOON,
    EVENING,
    NIGHT;

    public static String getTranslation(DayTime time) {
        return switch(time) {
            case MORNING -> "утро";
            case AFTERNOON -> "день";
            case EVENING -> "вечер";
            case NIGHT -> "ночь";
        };
    }

    public static DayTime changeTime(DayTime time, int iteration) {
        int day = 0;
        for (int i = 0; i < iteration; i++) {
            time = switch (time) {
                case MORNING -> DayTime.AFTERNOON;
                case AFTERNOON -> DayTime.EVENING;
                case EVENING -> DayTime.NIGHT;
                case NIGHT -> DayTime.MORNING;
            };
            day++;
        }
        if ((day/4) == 0) {
            System.out.println("наступил " + DayTime.getTranslation(time));
        } else {
            System.out.println("наступил " + DayTime.getTranslation(time) + ", и прошло " + (day / 4) + " дней");
        }
        return time;
    }
}
