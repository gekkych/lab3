package s466351.area;

import s466351.area.rocket.RocketIsAlrightException;
import s466351.shorty.Shorty;

public interface Interactable {
    void interact(Shorty shorty) throws RocketIsAlrightException;
}
