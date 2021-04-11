package sample;

import java.text.SimpleDateFormat;
import java.util.*;

class DateHelper {
    //    private Date currentTime;
    private final GregorianCalendar startCal;
    private GregorianCalendar currentCal;

    DateHelper() {
        startCal = new GregorianCalendar();
        startCal.add(Calendar.YEAR, -1500);
        currentCal = (GregorianCalendar) startCal.clone();
    }

    public String getFormattedStartDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MMM-y");
        return formatter.format(startCal.getTime());
    }

    public void skipTime() {
        currentCal.add(Calendar.MINUTE, 45);
    }

    public String getFormattedDiff() {
//        currentTime = currentCal.getTime();
//        long diffTime = currentCal.getTime().getTime() - startCal.getTime().getTime();
//        System.out.println(diffTime);
        currentCal.add(Calendar.YEAR, (-startCal.get(Calendar.YEAR)));
        currentCal.add(Calendar.MONTH, -startCal.get(Calendar.MONTH));
        currentCal.add(Calendar.DAY_OF_MONTH, -startCal.get(Calendar.DAY_OF_MONTH) + 1);
        currentCal.add(Calendar.HOUR_OF_DAY, -startCal.get(Calendar.HOUR_OF_DAY));
        currentCal.add(Calendar.MINUTE, -startCal.get(Calendar.MINUTE));

        int y = currentCal.get(Calendar.YEAR) - 1;
        int m = currentCal.get(Calendar.MONTH);
        int d = currentCal.get(Calendar.DAY_OF_MONTH) - 1;
        int h = currentCal.get(Calendar.HOUR_OF_DAY);
        int min = currentCal.get(Calendar.MINUTE);

        return h + ":" + min + "  " + d + "-" + m + "-" + y;
    }
}

public class Battle implements Observed{

    private ArrayList<Observer> observersList = new ArrayList<>();

    private boolean attackFirst;
    private boolean isFinish;

    public void fight(Squad squad1, Squad squad2) {
        attackFirst = true;
        isFinish = false;
        AbstractWarrior war1, war2;
        DateHelper dataManager = new DateHelper();

        sendMessage(dataManager.getFormattedStartDate());

        while (!isFinish) {
            war1 = (AbstractWarrior) squad1.getRandomWarrior();
            war2 = (AbstractWarrior) squad2.getRandomWarrior();
            if (attackFirst) {
                attack(war1, war2, squad2);
            } else {
                attack(war2, war1, squad1);
            }
            dataManager.skipTime();
        }
        boolean winnerFirst = !attackFirst;
        Squad winner = winnerFirst ? squad1 : squad2;
        sendMessage("Победитель --> " + winner.getNameSquad());
        sendMessage("Время битвы = " + dataManager.getFormattedDiff());
    }

    private void attack(AbstractWarrior attacking, AbstractWarrior attacked, Squad squadAttacked){
        attacked.takeDamage(attacking.attack());
        attackFirst = !attackFirst;
        if (!squadAttacked.hasAliveWarriors()){
            isFinish = true;
        }
        sendMessage(attacking.toString() + " атаковал " + attacked.toString());
    }

    @Override
    public void addObserver(Observer observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observersList.remove(observer);
    }

    @Override
    public void sendMessage(String msg) {
        for(Observer obs : observersList){
            obs.showMessage(msg);
        }
    }
}
