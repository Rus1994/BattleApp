package sample;

public class Viking extends AbstractWarrior {
    static int counterID = 0;

    Viking(String nameSquad) {
        super(nameSquad);
        counterID++;
        IDwarrior = counterID;
        nameClass = "Викинг";
        health = 100;
        damage = 50;
    }
}
