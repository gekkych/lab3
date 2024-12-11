package s466351.area.rocket;

public enum Status {
    UNDAMAGED,
    BROKEN;

    public static String getTranslation(Status status) {
        return switch(status) {
            case UNDAMAGED -> "в порядке";
            case BROKEN -> "сломано";
        };
    }
}
