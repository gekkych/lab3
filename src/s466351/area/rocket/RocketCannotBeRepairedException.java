package s466351.area.rocket;

public class RocketCannotBeRepairedException extends Exception {
    public RocketCannotBeRepairedException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "Клепке не удало починить ракету и коротышки не смогли улететь на луну";
    }
}
