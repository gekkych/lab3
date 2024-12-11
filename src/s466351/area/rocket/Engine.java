package s466351.area.rocket;

import s466351.area.Interactable;
import s466351.shorty.*;

public class Engine implements Breakable {
    private final int durability;
    private Status status;
    public class Button implements Interactable {
        RocketDoor connectedDoor;

        public Button(RocketDoor connectedDoor) {
            this.connectedDoor = connectedDoor;
        }

        @Override
        public void interact(Shorty shorty) {
            System.out.println("на кнопку, активирующую мотор, нажали");
            if (Engine.this.isUndamaged()) {
                this.connectedDoor.openDoor();
                return;
            }
            System.out.println("мотор сломан и дверь не открылась");
        }
    }

    protected Engine(int durability, Status status) {
        this.durability = durability;
        this.status = status;
    }

    public void getStatus() {
        System.out.println("двигатель " + Status.getTranslation(this.status));
    }

    @Override
    public void toBreak() {
        this.status = Status.BROKEN;
        System.out.println("Двигатель ракеты больше не работает");
    }

    @Override
    public void repair(Job job) {
        if (!(job == Job.ENGINEER || job == Job.SCIENTIST)) {
            System.out.println("коротышка не умеет чинить ракеты");
            return;
        }
        if (this.status == Status.BROKEN) {
            this.status = Status.UNDAMAGED;
            System.out.println("Двигатель отремонтирован");
        }
    }


    public boolean isUndamaged() {
        return this.status == Status.UNDAMAGED;
    }

    public int getDurability() {
        return this.durability;
    }
}

