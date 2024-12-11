package s466351.area.rocket;

public class RocketIsAlrightException extends RuntimeException {
    public RocketIsAlrightException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "всё хорошо, скоро произойдёт запуск ракеты";
    }
}
