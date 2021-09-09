import java.util.Random;

public class AssignmentThree{
    BoundedBuffer b;

    public AssignmentThree(){
        b = new BoundedBuffer(50, 0, 0);
    }

    public class Consumer extends Thread {

        @Override
        public void run(){
            while(true){
                try{
                    synchronized(b){
                        if(b.count == 0){
                            Thread.sleep(100);
                        } else{
                            b.remove();
                            System.out.println("Current position is: "+b.pos+".");
                            System.out.println("Current itemCount is: "+b.count+".");
                        }
                    }
                } catch(Exception a) {
                    a.printStackTrace();
                }
            }
        }   
    }   

    public class Producer extends Thread {

        @Override
        public void run(){
            while(true){
                try{
                    synchronized(b){
                        if(b.count == b.size){
                            Thread.sleep(100);
                        } else{
                            Random r = new Random();
                            int a = r.nextInt(100);
                            b.put(a);
                            System.out.println("Current position is:"+b.pos+".");
                            System.out.println("Last value added was: "+a);
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String [] args) {


        AssignmentThree a = new AssignmentThree();

        Producer prod = a.new Producer();
        Consumer cons = a.new Consumer();

        prod.start();
        cons.start();
    }
}