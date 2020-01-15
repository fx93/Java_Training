import java.util.Scanner;

public class Frog {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("If you want to check the Distance with time, press D. Or vice versa, Press T: ");
        char option = scanner.next().toUpperCase().charAt(0);
        System.out.println();
        System.out.print("Enter the respected value: ");
        int input = scanner.nextInt();
        System.out.println();

        if (option == 'D') {
            Frog.calculateDistance(input);
        } else if (option == 'T') {
            Frog.calculateTime(input);
        } else {
            System.out.println("Your input details were incorrect");
        }*/

        Frog.calculateDistance(53);
    }


    static void calculateTime(int d){
        int cycle = 0;

        if(cycle % 8 == 0){
            cycle = (d/8);
        }
        else{cycle = (d/8) + 1;}
        int interval = 8*cycle - d;

        if (interval <= 4){
            System.out.println("Least time is");
        }
    }

    static void calculateDistance(int t){
        int cycle = 0;
        int d = 0;

        if(cycle % 8 == 0){
            cycle = (t/8);
        }
        else{
            cycle = (t/8) + 1;
        }

        int interval = 8*cycle - t;

        System.out.println(cycle);
        System.out.println(t);
        System.out.println(interval);
        System.out.println(56/8);
        System.out.println(56%8);



        /*if (interval <= 4){
            d = 9*cycle;
            System.out.println("Distance is: "+ d);
        }
        else if(interval <= 6 && interval > 4){
            d = (9*(cycle-1)) + (8*cycle);
            System.out.println("Distance is: "+ d);
        }
        else if(interval == 7){
            d = (9*(cycle-1)) + (5*cycle);
            System.out.println("Distance is: "+ d);
        }
        else{
            System.out.println("system is down");
        }*/
    }
}