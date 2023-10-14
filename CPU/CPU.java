public class CPU {
    String pName = "--";
    boolean taked = false;
    boolean run = false;

    public String getProcess() {
        if(run) return pName;
        else return "--";
    }
    
    public void run() {
        run = true;
    }
    
    public synchronized boolean take(String pName) {
        this.pName = pName;
        if(!taked){
            taked = true;
            return true;
        }
        return false;
    }
    
    public synchronized void release() {
        pName = "--";
        taked = false;
        run = false;
    }

}
