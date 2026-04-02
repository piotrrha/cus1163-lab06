public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5);
        
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        
        System.out.println();
        producerThread.start();
        consumerThread.start();
        
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            return;
        }
        
        System.out.println("\nAll threads completed successfully!");
    }
