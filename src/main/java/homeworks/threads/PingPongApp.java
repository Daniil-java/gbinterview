package homeworks.threads;

public class PingPongApp {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        Ping pong = new Ping(pingPong);
        Pong ping = new Pong(pingPong);
    }
}

class PingPong {
    private boolean flag = false;

    synchronized void ping() {
        while (!flag){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("ping");
        flag = false;
        notify();
    }

    synchronized void pong() {
        while (flag) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("pong");
        flag = true;
        notify();

    }
}

class Pong implements Runnable{
    PingPong ping;
    public Pong(PingPong ping){
        this.ping = ping;
        new Thread(this, "Pong").start();
    }
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100; i++) {
                ping.ping();
            }

        }
    }
}
class Ping implements Runnable{
    PingPong pong;
    public Ping(PingPong pong){
        this.pong = pong;
        new Thread(this, "Ping").start();
    }
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100; i++) {
                pong.pong();
            }
        }
    }
}





