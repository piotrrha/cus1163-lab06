static class Producer implements Runnable {
        private SharedBuffer buffer;
        
        public Producer(SharedBuffer buffer) {
            this.buffer = buffer;
        }
        
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.produce(i);
                }
                System.out.println("[Producer] finished producing 10 items");
            } catch (InterruptedException e) {
                System.out.println("[Producer] was interrupted");
            }
        }
    }