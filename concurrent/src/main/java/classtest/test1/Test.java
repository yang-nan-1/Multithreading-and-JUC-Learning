package classtest.test1;

public class Test {
    /**
     * 简单模拟卖票的过程
     */
    private static int tickets = 1000; // 总票数

    public static void main(String[] args) {
        // 创建两个窗口线程（模拟两个窗口）
        Thread window1 = new Thread(new TicketSeller());
        Thread window2 = new Thread(new TicketSeller());
        window1.start();
        window2.start();
    }

    // 同步方法：保证线程安全地操作共享资源（票数）
    static synchronized boolean sellTicket() {
        if (tickets > 0) {
            tickets--;
            System.out.println("剩余票数: " + tickets);
            return true; // 成功卖出
        }
        return false; // 票已卖完
    }
}


class TicketSeller implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                if (!Test.sellTicket())
                    break;
                // 卖出后暂停3秒（模拟间隔）
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
