
class MyThread extends Thread {
    private String name;
    public MyThread(String name) {
        this.name = name;
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + name + " printing " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("A");
        MyThread t2 = new MyThread("B");
        t1.start();
        t2.start();
    }
}
