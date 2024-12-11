package s466351.area;

import s466351.shorty.*;

public class Hangar implements Interactable{
    private boolean isDestroyed;

    public Hangar() {
        this.isDestroyed = false;
    }

    public void burn() {
        this.isDestroyed = true;
        System.out.println("Ангар сгорел");
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    @Override
    public void interact(Shorty shorty) {
        if (this.isDestroyed) {
            System.out.println("на месте ангара осталсь груда горящих обломков");
        } else {
            System.out.println("Ангар стоит на своём месте");
        }
    }
}
