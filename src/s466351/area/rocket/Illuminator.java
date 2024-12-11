package s466351.area.rocket;

import s466351.shorty.Job;

public class Illuminator implements Breakable{
    private final int durability;
    private Status status;
    protected Illuminator(int durability, Status status) {
        this.durability = durability;
        this.status = status;
    }

    public void getStatus() {
        System.out.println("иллюминатор " + Status.getTranslation(this.status));
    }

    @Override
    public void repair(Job job) {
        if (!(job == Job.ENGINEER || job == Job.SCIENTIST)) {
            System.out.println("коротышка не умеет чинить ракеты");
            return;
        }
        if (this.status == Status.BROKEN) {
            this.status = Status.UNDAMAGED;
            System.out.println("Иллюминатор отремонтирован");
        }
    }

    @Override
    public void toBreak() {
        System.out.println("Иллюминатор разбит");
        this.status = Status.BROKEN;
    }

    public boolean isUndamaged() {
        return this.status == Status.UNDAMAGED;
    }

    public int getDurability() {
        return this.durability;
    }
}

