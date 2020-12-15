package multithreading;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {
    private int n;

    int counter =0;
    private Semaphore semaphore0;
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    public ZeroEvenOdd(int n){
        this.n = n;
        semaphore0 = new Semaphore(1);
        semaphore1 = new Semaphore(0);
        semaphore2 = new Semaphore(0);
    }

    void printZero() throws InterruptedException {

        for(int i=0;i<n ;i++){
            semaphore0.acquire();
            counter++;
            System.out.println(0);


            if(counter%2 == 1){
                semaphore1.release();
            } else {
                semaphore2.release();
            }
        }

    }

    void printOdd() throws InterruptedException {
        for (int i = 0; i < Math.ceil((double)n/2); i++) {
            semaphore1.acquire();
            System.out.println(counter);
            semaphore0.release();
        }
    }

    void printEven() throws InterruptedException {
        for (int i=0;i< n/2;i++){
            semaphore2.acquire();
            System.out.println(counter);
            semaphore0.release();
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);

        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.printZero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread0.start();
        thread1.start();
        thread2.start();
    }

}
