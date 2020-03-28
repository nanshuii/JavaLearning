package test;

import java.sql.SQLOutput;

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
* */
public class ThreadDemo {
    public static void main(String[] args) {

//        threadTest01();

//        threadTest02();

        threadTest03();

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
}

