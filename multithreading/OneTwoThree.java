package multithreading;

import java.util.concurrent.Semaphore;

public class OneTwoThree {

    private int n;

    int counter = 0;

    private Semaphore semaphore0;
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    public OneTwoThree(int n){
        this.n = n;

        semaphore0 = new Semaphore(1);
        semaphore1 = new Semaphore(0);
        semaphore2 = new Semaphore(0);
    }

    void printZero() throws InterruptedException {

        for(int i=0;i<n ;i++){
            semaphore0.acquire();

            System.out.println(++counter);

            if(counter%3 == 0){
                semaphore0.release();
            }
            else if(counter%3 == 1){
                semaphore1.release();
            } else if(counter%3 == 2) {
                semaphore2.release();
            }
        }

    }

    void printOne() throws InterruptedException {
        for(int i=0;i<n ;i++){
            semaphore1.acquire();

            System.out.println(++counter);

            if(counter%3 == 0){
                semaphore0.release();
            }
            else if(counter%3 == 1){
                semaphore1.release();
            } else if(counter%3 == 2) {
                semaphore2.release();
            }
        }
    }

    void printTwo() throws InterruptedException {
        for(int i=0;i<n ;i++){
            semaphore2.acquire();

            System.out.println(++counter);


            if(counter%3 == 0){
                semaphore0.release();
            }
            else if(counter%3 == 1){
                semaphore1.release();
            } else if(counter%3 == 2) {
                semaphore2.release();
            }
        }
    }


    public static void main(String[] args) {
        OneTwoThree oneTwoThree = new OneTwoThree(3);

        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oneTwoThree.printZero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oneTwoThree.printOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oneTwoThree.printTwo();
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
