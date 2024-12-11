 package s466351.shorty;

public enum Job {
    JOBLESS,
    SCIENTIST,
    ENGINEER,
    WORKER;

    public static String getTranslation(Job job) {
        return switch(job) {
            case ENGINEER -> "инженер";
            case SCIENTIST -> "учённый";
            case JOBLESS -> "ни чем не занимается";
            case WORKER -> "обычный рабочий";
        };
    }
}
