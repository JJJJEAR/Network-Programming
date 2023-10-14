public class Fork {
    volatile boolean taked = false;
    String holderName = "  ";
    
    public String getHolderName() {
        return holderName;
    }

    public synchronized boolean take(String holderName) {
        if (!taked) {
            taked = true;
            this.holderName = holderName;
            return true;
        }
        return false;
    }

    public synchronized void putDown() {
        taked = false;
        holderName = " ";
    }
}