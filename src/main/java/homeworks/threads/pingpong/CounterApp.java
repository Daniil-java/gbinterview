package homeworks.threads.pingpong;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterApp {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ConcurrencyLockExample concurrencyLockExample = new ConcurrencyLockExample(counter);
        ConcurrencyLockExample concurrencyLockExample1 = new ConcurrencyLockExample(counter);
        ConcurrencyLockExample concurrencyLockExample2 = new ConcurrencyLockExample(counter);

        Thread.sleep(5000);
        System.out.println(counter.getCount());
    }
}

class Counter {
    int count = 0;

    public void increase() {
        System.out.println(++count);
    }

    public int getCount() {
        return count;
    }
}

class ConcurrencyLockExample implements Runnable{

    private Counter counter;
    private Lock lock;

    public ConcurrencyLockExample(Counter c){
        this.counter = c;
        this.lock = new ReentrantLock();
        new Thread(this, this.toString()).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                counter.increase();
            } finally{
                lock.unlock();
            }
        }
    }

}

