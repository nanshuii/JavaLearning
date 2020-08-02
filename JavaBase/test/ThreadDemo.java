package test;

import java.sql.SQLOutput;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 线程
* 多线程
*
* getName() 获取线程名称
* 主线程 main
* 新线程 Thread-0 Thread-1 ...... Thread-9999
*
* setName() 给线程取名字
*
* sleep(long millis)
* 毫秒级别
*
* 以实现Runnable接口的方式创建线程
* 需要重写run
* 在调用时候需要先实例化接口实现对象，然后创建Thread对象，作为Thread对象的构造参数传入，Thread对象start
*
* 实现Runnable接口避免单继承，类继承了Thread不能继承其他的类
* 实现Runnable接口，重现Run方法，以及Thread的start方法，把设置线程任务和开启新线程进行了分离
*
* 匿名内部类方式实现线程的创建
*
* 线程安全
* 让其他线程等待当前线程的操作之后再执行
*
* 解决方式:
* 1. 同步代码块
* synchronized(锁对象) { ... }
* 锁对象可以是任何对象
* 多个线程使用的锁对象是同一个锁对象
* 同步中的线程没有执行完毕不会释放锁对象，同步外的线程没有锁对象进不去同步
* 频繁判断锁，创建锁，释放锁，程序效率降低
* 2. 同步方法
* public synchronized void 方法名() { ... }
* 同步方法锁住方法内部，只要一个线程执行；
* 3.lock锁
* 初始化
* Lock lock = new ReentrantLock();
* 加锁 lock.lock();
* 解锁 lock.unlock();
*
* 线程状态
* 计时等待 sleep
* 锁阻塞 Blocked
* 无限等待 Waiting
* 等待和唤醒的线程只有一个，使用同步
* wait等待
* wait(毫秒) wait可以加一个时间，如果在指定时间内还没被唤醒，那么自动唤醒
* notify唤醒
* 如果有多个等待，随机唤醒一个
* notifyAll 如果有多个等待，唤醒所有等待的线程
*
* 线程池
* 线程池的创建 指定线程数量
* ExecutorService executorService = Executors.newFixedThreadPool(2);
*
* submit 传递线程任务（实现类），开启线程，执行run方法
* 线程池会一直开启，使用完了线程，线程就会归还给线程池，继续使用
* executorService.submit(new RunnableTest());
* executorService.submit(new RunnableTest());
* executorService.submit(new RunnableTest());
*
* 线程池的关闭
* shutdown()
*
* */
public class ThreadDemo {
    public static void main(String[] args) {

//        threadTest01();

//        threadTest02();

//        threadTest03();

//        threadTest04();

//        threadTest05();

//        threadTest06();

//        threadTest07();

//        threadTest08();

        threadTest09();
    }

    // 多线程的实现一
    public static void threadTest01() {
        class Thread1 extends Thread{

            public Thread1() {

            }

            public Thread1(String name) {
                super(name);
            }

            @Override
            public void run() {
                System.out.println("获取线程名称: " + getName());
            }
        }

        Thread1 thread1 = new Thread1();
        thread1.setName("多线程名称更改");
        thread1.start();

        Thread1 thread11 = new Thread1("构造时候取的名字");
        thread11.start();
    }

    // 多线程的实现二
    public static void threadTest02() {

        class Thread1 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        }

        Thread1 thread1 = new Thread1();
        Thread thread = new Thread(thread1);
        thread.start();
    }

    // 匿名内部类方式实现线程的创建
    public static void threadTest03() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        }.start();

        Runnable runnable =  new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        };
        new Thread(runnable).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        }).start();
    }

    // 线程安全问题
    public static void threadTest04() {
        class Thread1 implements Runnable {

            private int num = 20;

            @Override
            public void run() {
                while (true) {
                    if (num > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "===" + num);
                        num--;
                    } else {
                        break;
                    }
                }
            }
        }

        Thread1 thread1 = new Thread1();
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread1);
        Thread t3 = new Thread(thread1);
        t1.start();
        t2.start();
        t3.start();

    }

    // 参照threadTest04()解决线程安全问题
    // 1.同步代码块
    public static void threadTest05() {
        class Thread1 implements Runnable {

            private int num = 20;

            Object obj = new Object();

            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        if (num > 0) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + "===" + num);
                            num--;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        Thread1 thread1 = new Thread1();
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread1);
        Thread t3 = new Thread(thread1);
        t1.start();
        t2.start();
        t3.start();
    }

    // 参照threadTest04()解决线程安全问题
    // 2.同步方法
    public static void threadTest06() {
        class Thread1 implements Runnable {

            private int num = 20;

            @Override
            public void run() {
                while (true) {
                    boolean b = threadTest06Method();
                    if (b) {
                        break;
                    }
                }
            }

            public synchronized Boolean threadTest06Method() {
                if (num > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "===" + num);
                    num--;
                } else {
                    return true;
                }
                return false;
            }
        }

        Thread1 thread1 = new Thread1();
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread1);
        Thread t3 = new Thread(thread1);
        t1.start();
        t2.start();
        t3.start();

    }

    // 参照threadTest04()解决线程安全问题
    // 3.lock
    public static void threadTest07() {
        class Thread1 implements Runnable {

            private int num = 20;

            Lock lock = new ReentrantLock();

            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    if (num > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "===" + num);
                        num--;
                    } else {
                        break;
                    }
                    lock.unlock();
                }
            }
        }

        Thread1 thread1 = new Thread1();
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread1);
        Thread t3 = new Thread(thread1);
        t1.start();
        t2.start();
        t3.start();

    }

    // 线程之间的通信 wait notify
    public static void threadTest08() {
        Object obj = new Object();
        new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("告知另一个线程");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("被唤醒了");
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("五秒后唤醒另一个线程");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    System.out.println("五秒到了");
                    obj.notify();
                }
            }
        }.start();
    }

    // 线程池
    public static void threadTest09() {
        class RunnableTest implements Runnable{
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");
            }
        }

        // 线程池的创建
        ExecutorService executorService = Executors.newFixedThreadPool(2); // 指定线程数量的线程池
        executorService.submit(new RunnableTest()); // submit 传递线程任务（实现类），开启线程，执行run方法
        executorService.submit(new RunnableTest());
        executorService.submit(new RunnableTest());
        executorService.shutdown();
    }
}

