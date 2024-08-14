class Foo {
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(0);
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s1.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s1.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}