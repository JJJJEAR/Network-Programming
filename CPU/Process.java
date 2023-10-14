public class Process extends Thread {
    String name;
    CPU[] cpu;
    int nCPU;
    
    public  Process(String name, CPU[] cpu, int nCPU) {
        this.name = name;this.cpu  = cpu;this.nCPU = nCPU;
    }
    
    public void run() { }

}
