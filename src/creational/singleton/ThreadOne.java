package creational.singleton;

public class ThreadOne implements Runnable{
    @Override
    public void run() {
        System.out.println(ThreadSafeSingleton.getInstance("One").value);
    }
}
