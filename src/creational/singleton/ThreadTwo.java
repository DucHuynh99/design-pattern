package creational.singleton;

public class ThreadTwo implements Runnable {
    @Override
    public void run() {
        System.out.println(ThreadSafeSingleton.getInstance("Two").value);
    }
}
