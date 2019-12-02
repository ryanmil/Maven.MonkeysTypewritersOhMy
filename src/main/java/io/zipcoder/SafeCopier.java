package io.zipcoder;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        try {
            while (stringIterator.hasNext()) {
                Thread.sleep(100);
                if (stringIterator.hasNext()) {
                    doStuff();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void doStuff() {
        copied += this.stringIterator.next() + " ";
    }

}
