
public class ThrowsExample {
    public static void main(String a[]){
        ThrowsExample mytc = new ThrowsExample();
        try{
            for(int i=0; i<5; i++){
                mytc.getJunk();
                System.out.println(i);
            }
        } catch (InterruptedException iex){
            iex.printStackTrace();
        }
    }

    public void getJunk() throws InterruptedException {
        Thread.sleep(1000);
    }
}
