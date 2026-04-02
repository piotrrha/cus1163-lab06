import java.util.ArrayList;

public class ProducerConsumerLab {
    

    static class SharedBuffer {
        private ArrayList<Integer> buffer;
        private int capacity;
        
        public SharedBuffer(int capacity) {
            this.buffer = new ArrayList<>();
            this.capacity = capacity;
            System.out.println("Buffer created with capacity: " + capacity);
        }
        
        public synchronized void produce(int value) throws InterruptedException {
            while (buffer.size() >= capacity) {
                System.out.println("[Producer] Buffer FULL - waiting...");
                wait();
            }
            buffer.add(value);
            System.out.println("[Producer] Produced: " + value + " | Buffer: " + buffer);
            notifyAll();
        }
        
        public synchronized int consume() throws InterruptedException {
            while (buffer.isEmpty()) {
                System.out.println("[Consumer] Buffer EMPTY - waiting...");
                wait();
            }
            int value = buffer.remove(0);
            System.out.println("[Consumer] Consumed: " + value + " | Buffer: " + buffer);
            notifyAll();
            return value;
        }
    }