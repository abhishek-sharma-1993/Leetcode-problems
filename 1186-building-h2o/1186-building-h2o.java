class H2O {
    Semaphore sO;
    Semaphore sH;

    public H2O() {
        sO = new Semaphore(0);
        sH = new Semaphore(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		sH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        sO.release();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        sO.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        sH.release(2);
    }
}