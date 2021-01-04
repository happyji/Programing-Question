package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


/*

Producer

 take lock
 wait if its full
 produce
 notify
 remove lock



Consumer

 take lock
 wait if its empty
 consume
 notify
 remove lock

 */


class CustomBlockingQueue {

    private Queue queue;
    int size;

    CustomBlockingQueue(int size){
        this.queue = new LinkedList();
        this.size = size;
    }

    public void put(Integer input) throws InterruptedException {
        synchronized (this){
            while (queue.size() >= size){
                wait();
            }

            System.out.println(Thread.currentThread().getName() + "Produced  : "+ input);
            queue.add(input);

            notify();
        }
    }

    public Integer take() throws InterruptedException {

        synchronized (this){
            while (queue.size() == 0){
                wait();
            }

            Integer poll = (Integer) queue.poll();
            System.out.println(Thread.currentThread().getName() + "Consumed : "+ poll);

            notify();
            return poll;
        }
    }

}


public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        CustomBlockingQueue blockingQueue = new CustomBlockingQueue(2);

        Runnable producerRunnable = new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                try {
                    while (true) {
                        counter++;
                        blockingQueue.put(counter);
                       // System.out.println("Produced : " + counter);

                        Thread.sleep(2000);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread producer1 = new Thread(producerRunnable,"producer1");
        Thread producer2 = new Thread(producerRunnable,"producer2");

        Runnable consumerRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {

                        Integer take = (Integer) blockingQueue.take();
                       // System.out.println("Consumed : " + take);

                        Thread.sleep(2000);

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

            Thread consumer1 = new Thread(consumerRunnable,"consumer1");
            Thread consumer2 = new Thread(consumerRunnable,"consumer2");

        producer1.start();
        producer2.start();


        consumer1.start();
        consumer2.start();

    }

}
