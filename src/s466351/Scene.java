package s466351;

import s466351.area.*;
import s466351.area.rocket.*;
import s466351.shorty.*;

public class Scene {
    public static void main(String[] args) {
        DayTime dayTime = DayTime.EVENING;
        DebrisList debris;
        Shorty fuksia = new Fuksia();
        Shorty seledochka = new Seledochka();
        Klepka klepka = new Klepka(40);
        Shorties shorties = new Shorties();
        Explosion exp = new Explosion((int)(Math.random()*7));
        Hangar hangar = new Hangar();
        Rocket rocket = new Rocket();

        try {
            debris = exp.explode(rocket, hangar);
            fuksia.runTo(Destination.HANGAR);
            seledochka.runTo(Destination.HANGAR);
            hangar.interact(seledochka);
            shorties.react(exp,rocket,debris,dayTime);
            rocket.interact(klepka);
            rocket.getButton().interact(seledochka);
            klepka.restore();
            if (!rocket.getDoor().isUndamaged()) {
                klepka.climb(rocket.getIlluminator());
                klepka.repairRocket(rocket);
                rocket.getButton().interact(klepka);
            }
            rocket.interact(klepka);
        } catch (RocketIsAlrightException e) {
            System.out.println(e.getMessage());
        } catch (RocketCannotBeRepairedException e) {
            System.out.println(e.getMessage());
       }
    }
}
