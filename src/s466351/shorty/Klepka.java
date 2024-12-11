package s466351.shorty;

import s466351.area.Destination;
import s466351.area.rocket.Illuminator;
import s466351.area.rocket.Rocket;
import s466351.area.rocket.RocketCannotBeRepairedException;

public final class Klepka extends Shorty {
    public Klepka(int condition) {
        super("Клепка", Job.ENGINEER, condition);
    }

    public void climb(Illuminator illuminator) {
        if (!illuminator.isUndamaged()) {
            System.out.println("Клепка перелез через разбитый иллюминатор в кабину ракеты");
            this.position = Destination.INSIDEROCKET;
        } else {
            System.out.println("Клепка подумал пролезть в ракету через иллюминатор, но ломать его ему не хотелось");
        }
    }

    public void repairRocket(Rocket rocket) throws RocketCannotBeRepairedException {
        if (condition >= 80 && position == Destination.INSIDEROCKET) {
            rocket.getEngine().repair(this.job);
            rocket.getIlluminator().repair(this.job);
            rocket.getTail().repair(this.job);
            rocket.getDoor().repair(this.job);
        } else {
            throw new RocketCannotBeRepairedException("Клепке не удало починить ракету и коротышки не смогли улететь на луну");
        }
    }

    @Override public String toString() {
        return "Клепка инженер";
    }

    @Override
    public void runTo(Destination d) {
        this.position = d;
        System.out.println(Job.getTranslation(this.job) + " " + getName() + " побежал к " + Destination.getTranslation(d));
    }
}
