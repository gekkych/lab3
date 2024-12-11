package s466351.area;

import s466351.area.rocket.*;

public record Explosion(int power) {

    public DebrisList explode(Rocket rocket, Hangar hangar) {
        if (power > 0) {
            System.out.println("прогремел взрыв силой " + power());
            burnHangar(hangar);
            brokeTail(rocket);
            rotateRocket(rocket);
            brokeIlluminator(rocket);
            brokeEngine(rocket);
            brokeDoor(rocket);
            return doDebris();
        } else {
            System.out.println("взрыва не произошло");
            return null;
        }
    }

    private void burnHangar(Hangar hangar) {
        hangar.burn();
    }

    private DebrisList doDebris() {
        DebrisList debris = new DebrisList();
        System.out.println("упало " + debris.getSize() + " обломков общей массой " + debris.getMass());
        System.out.println();
        return debris;
    }

    private void rotateRocket(Rocket rocket) {
        rocket.turn();
        System.out.println("ракету перевернуло набок");
    }

    private void brokeIlluminator(Rocket rocket) {
        if (this.power > rocket.getIlluminator().getDurability()) {
            rocket.getIlluminator().toBreak();
        }
    }

    private void brokeDoor(Rocket rocket) {
        if (this.power > rocket.getDoor().getDurability()) {
            rocket.getDoor().toBreak();
        }
    }

    private void brokeTail(Rocket rocket) {
        if (this.power > rocket.getTail().getDurability()) {
             rocket.getTail().toBreak();
        }
    }

    private void brokeEngine(Rocket rocket) {
        if (this.power > rocket.getEngine().getDurability()) {
            rocket.getEngine().toBreak();
        }
    }
}
