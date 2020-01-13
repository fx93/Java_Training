
public class Pattern {
    public static void main(String args[]){

        int value = 21;
        int num = (value+1)/2;

        for(int i=1; i<=num; i++){
            for(int k=num-i; k>0; k--){
                System.out.print(" ");
            }
            for(int j=1; j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();

        }


        for(int i=1; i<=num-1; i++){
            for(int k=1; k<=i; k++){
                System.out.print(" ");
            }
            for(int j=1; j<=(-2*i)+(2*num-1);j++){
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
