public class Deadlock {
    
    public static void main(String [] args) {
        Line l1 = new Line(1.0,1.0,4.0,4.0);
        Line l2 = new Line(3.0,0.0,1.0,43.0);

        System.out.println("Program starts");

        Runnable thread1 = new Runnable(){
            
            @Override
            public void run(){
                try {
                    synchronized(l1) {
                        Thread.sleep(1000);
                        synchronized (l2) {
                            System.out.println(l1.parallelTo(l2));
                        }
                    }
                } catch (Exception e){
                    System.err.print(e);
                }
            }
        };

        Runnable thread2 = new Runnable(){
            
            @Override
            public void run(){
                try {
                    synchronized(l2) {
                        Thread.sleep(1000);
                        synchronized (l1) {
                            System.out.println(l2.parallelTo(l1));
                        }
                    }
                } catch (Exception e){
                    System.err.print(e);
                }
            }
        };

        new Thread(thread1).start();
        new Thread(thread2).start();
        
        System.out.println("Program ended.");
        
    }
}
