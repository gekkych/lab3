package s466351.shorty;

import s466351.area.Destination;

public final class Fuksia extends Shorty {
    public Fuksia() {
        super("Фуксия", Job.SCIENTIST);
    }

    @Override
    public String toString() {
        return "Фуксия учённая";
    }

    public void runTo(Destination d) {
        this.position = d;
        System.out.println(this + " бросилась к " + Destination.getTranslation(d));
    }
}
