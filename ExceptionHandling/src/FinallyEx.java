public class FinallyEx {
    public static void main(String[] a){

        try{
            int i = 10/0;
        } catch(Exception ex){
            System.out.println("Inside 1st catch Block");
        } finally {
            System.out.println("Inside 1st finally block");
        }

        try{
            int i = 10/10;
        } catch(Exception ex){
            System.out.println("Inside 2nd catch Block");
        } finally {
            System.out.println("Inside 2nd finally block");
        }
    }
}