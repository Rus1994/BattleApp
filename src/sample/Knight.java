package sample;

public class Knight extends AbstractWarrior {
    static int counterID = 0;

    Knight(String nameSquad) {
        super(nameSquad);
        counterID++;
        IDwarrior = counterID;
        nameClass = "Рыцарь";
        health = 110;
        damage = 40;
    }
}
