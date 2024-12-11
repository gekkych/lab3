package s466351.shorty;

import s466351.area.*;
import s466351.area.rocket.Rocket;
import s466351.area.rocket.RocketDoor;

import java.util.ArrayList;

public class Shorties {
    protected ArrayList<Shorty> shorties;
    private final int numberOfGroup;
    private Destination position;
    private final class OrdinaryShorty extends Shorty {
            private OrdinaryShorty() {
                super(Shorties.this.position);
            }
            @Override
            public void runTo(Destination d) {
                System.out.println("один из коротышек побежал к " + Destination.getTranslation(d));
                Shorties.this.shorties.remove(Shorties.this.shorties.size()-1);
            }
    }

    public Shorties() {
        this.numberOfGroup = (int) (Math.random() * 7 + 1);
        this.position = Destination.DEFAULT;
    }

    public void makeGroup() {
        for (int i = 0; i < numberOfGroup; i++) {
            shorties.add(new OrdinaryShorty());
        }
    }

    public void react(Explosion explosion, Rocket rocket, DebrisList debris, DayTime dayTime) {
        if (explosion.power() > 0) {
            this.shorties = new ArrayList<>();
            makeGroup();
            runTo(Destination.DEBRIS);
            work(rocket, debris, dayTime);
        }
    }

    public void runTo(Destination d) {
        this.position = d;
        System.out.println("группа коротышек побежала к " + Destination.getTranslation(d));
    }

    public void work(Rocket rocket, DebrisList debrises, DayTime dayTime) {
            int spentTime = (debrises.getMass() * 2 / this.numberOfGroup)+1;
            for (int i = 0; i < debrises.getSize(); i++) {
                debrises.removeDebris(i);
            }
            System.out.println();
            System.out.println(this.numberOfGroup + " коротышек приступили за работу. Время : " + DayTime.getTranslation(dayTime));
            DayTime.changeTime(dayTime, spentTime);
            System.out.println("коротышки расчистили развал");
            if (rocket.isTurned()) {
                rocket.turn();
                System.out.println("коротышки поставили ракету на место");
            }
            System.out.println();
    }

    public void addShorty(Shorty shorty) {
        this.shorties.add(shorty);
    }

    public void removeShorty(int index) {
        this.shorties.remove(index);
    }
}
