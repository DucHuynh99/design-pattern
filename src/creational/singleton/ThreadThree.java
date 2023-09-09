package creational.singleton;

public class ThreadThree implements Runnable {
    @Override
    public void run() {
        System.out.println(BillPughSingleton.getInstance());
    }
}
