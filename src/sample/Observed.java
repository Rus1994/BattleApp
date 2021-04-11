package sample;

public interface Observed {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void sendMessage(String msg);
}
