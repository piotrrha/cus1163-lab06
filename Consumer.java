static class Consumer implements Runnable {
        private SharedBuffer buffer;

        public Consumer(SharedBuffer buffer) {
            this.buffer = buffer;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.consume();
                }
                System.out.println("[Consumer] finished consuming 10 items");
            } catch (InterruptedException e) {
                System.out.println("[Consumer] was interrupted");
            }
        }
    }