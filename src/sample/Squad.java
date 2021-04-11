package sample;

import java.util.Vector;

public class Squad implements Cloneable{
    private Vector<Warrior> warriorsVector = new Vector<Warrior>();
    private String nameSquad;


    public Squad() {}

    public Squad(Squad obj) {           // добавить копирование вектора войнов
        this.nameSquad = obj.nameSquad;
    }

    public void setNameSquad(String nameSquad) {
        this.nameSquad = nameSquad;
        if(warriorsVector.isEmpty()){
            return;
        }

        for(Warrior war : warriorsVector){
            war.setSquadName(nameSquad);
        }
    }

    public String getNameSquad() {
        return nameSquad;
    }


    public Warrior getRandomWarrior() {
        Warrior war;
        do {
            int numWar = (int) (Math.random() * warriorsVector.size());
            war = warriorsVector.get(numWar);
        } while (!war.isAlive());
        return war;
    }

    public boolean hasAliveWarriors() {
        for (Warrior war : warriorsVector) {
            if (war.isAlive())
                return true;
        }
        return false;
    }

    public void addWarrior(Warrior warrior){
        warriorsVector.add(warrior);
    }

    @Override
    public String toString() {
        return "Отряд: " + nameSquad + "\n";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Squad(this);
    }
}
