package s466351.shorty;

import s466351.area.Destination;

public final class Seledochka extends Shorty {
    public Seledochka() {
        super("Селёдочка", Job.SCIENTIST);
    }

    @Override
    public String toString() {
        return "Селедочка учённая";
    }

    public void runTo(Destination d) {
        this.position = d;
        System.out.println(this + " бросилась к " + Destination.getTranslation(d));
    }
}