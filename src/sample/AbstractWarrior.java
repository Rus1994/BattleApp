package sample;

public abstract class AbstractWarrior implements Warrior{
    protected int health;
    protected int damage;
    protected String nameSquad;
    protected String nameClass;
    protected int IDwarrior = 0;

    AbstractWarrior(String nameSquad) {
        this.nameSquad = nameSquad;
    }

    @Override
    public int attack() {
        return damage;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void setSquadName(String name) {
        nameSquad = name;
    }

    @Override
    public String toString() {
        return nameClass + " №" + IDwarrior + " Отряд: " + nameSquad;
    }
}
