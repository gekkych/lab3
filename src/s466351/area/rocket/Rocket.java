package s466351.area.rocket;

import s466351.area.Interactable;
import s466351.shorty.*;

public class Rocket implements Interactable {
    private boolean isTurned;
    private final Engine engine;
    private final Engine.Button button;
    private final Illuminator illuminator;
    private final RocketDoor door;
    private final RocketTail tail;

    public Rocket() {
        this.isTurned = false;
        this.illuminator = new Illuminator(5, Status.UNDAMAGED);
        this.door = new RocketDoor(1, Status.UNDAMAGED);
        this.tail = new RocketTail(6, Status.UNDAMAGED);
        this.engine = new Engine(3, Status.UNDAMAGED);
        this.button = engine.new Button(door);
    }

    @Override
    public void interact(Shorty shorty) throws RocketIsAlrightException{
        if (!isTurned() && getDoor().isUndamaged() && getEngine().isUndamaged() && getIlluminator().isUndamaged() && getTail().isUndamaged()) {
            throw new RocketIsAlrightException("ракета готова к запуску");
        } else {
            System.out.println("ракета сломана");
        }
    }

     public void turn() {
        this.isTurned = !this.isTurned;
    }

    public boolean isTurned() {
        return this.isTurned;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Illuminator getIlluminator() {
        return this.illuminator;
    }

    public RocketDoor getDoor() {
        return this.door;
    }

    public RocketTail getTail() {
        return this.tail;
    }

    public Engine.Button getButton() {
        return this.button;
    }
}
