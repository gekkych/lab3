package s466351.area;

public enum Destination {
    HANGAR,
    DEBRIS,
    ROCKET,
    DEFAULT,
    INSIDEROCKET;

    public static String getTranslation(Destination d) {
        return switch (d) {
            case HANGAR -> "ангар";
            case DEBRIS -> "обломки";
            case ROCKET -> "ракета";
            case DEFAULT -> "на улице";
            case INSIDEROCKET -> "в ракете";
        };
    }
}
