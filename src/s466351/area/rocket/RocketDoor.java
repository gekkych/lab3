package s466351.area.rocket;

import s466351.shorty.Job;

public class RocketDoor implements Breakable {
    private boolean open;
    private final int durability;
    private Status status;
    protected RocketDoor(int durability, Status status) {
        this.durability = durability;
        this.status = status;
        this.open = true;
    }

    public void getStatus() {
        System.out.println("дверь ракеты " + Status.getTranslation(this.status));
    }

    public void openDoor() {
            if(this.open) {
                System.out.println("двери уже открыты");
            } else {
                System.out.println("двери открылись");
                this.status = Status.UNDAMAGED;
                this.open = true;
            }
    }

    @Override
    public void repair(Job job) {
        if (!(job == Job.ENGINEER || job == Job.SCIENTIST)) {
            System.out.println("коротышка не умеет чинить ракеты");
            return;
        }
        if (this.status == Status.BROKEN) {
            this.status = Status.UNDAMAGED;
            System.out.println("Двери отремонтированы");
        }
    }

    @Override
    public void toBreak() {
        System.out.println("Двери автоматически закрылись из-за взрыва");
        this.open = false;
        this.status = Status.BROKEN;
    }

    public boolean isUndamaged() {
        return this.status == Status.UNDAMAGED;
    }

    public int getDurability() {
        return this.durability;
    }
}
