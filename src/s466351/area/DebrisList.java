package s466351.area;

import s466351.shorty.*;

import java.util.ArrayList;

public class DebrisList implements Interactable{
    ArrayList<Debris> debrisList;
    public record Debris(int size) {}

    public DebrisList() {
        int numberOfDebris = (int) (Math.random() * 7 + 1);
        debrisList = new ArrayList<>();
        fillList(numberOfDebris);
    }

    public void addDebris(Debris debris) {
        debrisList.add(debris);
    }

    public void removeDebris(int index) {
        debrisList.remove(index);
    }

    private void fillList(int length) {
        for (int i = 0; i < length; i++) {
            addDebris(new Debris((int)(Math.random()*3 + 1)));
        }
    }

    public int getSize() {
        return debrisList.size();
    }

    public int getMass() {
        int size = 0;
        for (DebrisList.Debris debris : debrisList) {
            size += debris.size();
        }
        return size;
    }

    @Override
    public void interact(Shorty shorty) {

    }
}

