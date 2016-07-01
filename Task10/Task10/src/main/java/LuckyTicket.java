public class LuckyTicket {

    static Integer count = 0;
    static Integer result = 0;

    static class LuckyThread extends Thread {
        private int start;
        private int end;

        LuckyThread(int start, int end){
            this.start = start;
            this.end = end;
        }

        public void run() {
            while (start <= end) {
                start++;
                if ((start % 10) + (start / 10) % 10 + (start / 100) % 10 == (start / 1000)
                        % 10 + (start / 10000) % 10 + (start / 100000) % 10) {
                    result++;
                }
            }
            synchronized (count) {
                count += result;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread(0,333333);
        Thread t2 = new LuckyThread(333333,666666);
        Thread t3 = new LuckyThread(666666,999999);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + count);
    }
}