public class Problem {
    public static void main(String[] args) {
        int numCPU = 6, numProcess = 10;
        
        CPU[] cpu = new CPU[numCPU];
        for(int i = 0; i < numCPU; i++) {
            cpu[i] = new CPU();}

            Process[] p = new Process[numProcess];
            for(int i = 0; i < numProcess; i++) {
                p[i] = new Process("P" + i, cpu, (i%3)+1); p[i].start();}

                String status;
                for(int i = 0; i < 15; i++) {
                    status = "|";
                    for(int j = 0; j < numCPU; j++) {
                        status += (cpu[j].getProcess() + "|");}
                        System.out.println(status);
                        try {
                            Thread.sleep(500);
                        } catch(Exception e){ }
                    }
                }
            }