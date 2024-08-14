class H2O {
    Semaphore sO = new Semaphore(0);
    Semaphore sH = new Semaphore(2);

    public H2O() {
        
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