package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerWithBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new LinkedBlockingDeque();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter =0;
                try {
                    while (true){
                        counter++;
                        blockingQueue.put(counter);
                        System.out.println("Produced : "+ counter);

                        Thread.sleep(2000);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        Thread consumer = new Thread(()->{

            try {
                while (true){

                    Integer take = (Integer) blockingQueue.take();
                    System.out.println("Consumed : "+ take);

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
