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

            notify();
            return poll;
        }
    }

}


public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        CustomBlockingQueue blockingQueue = new CustomBlockingQueue(2);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                try {
                    while (true) {
                        counter++;
                        blockingQueue.put(counter);
                        System.out.println("Produced : " + counter);

                        Thread.sleep(2000);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        Thread consumer = new Thread(() -> {

            try {
                while (true) {

                    Integer take = (Integer) blockingQueue.take();
                    System.out.println("Consumed : " + take);

                    Thread.sleep(2000);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });


        producer.start();
        consumer.start();


        producer.join();
        consumer.join();

    }

}
