import java.util.Scanner;

public class Frog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("If you want to check the Distance with time, press D. Or vice versa, Press T: ");
        char option = scanner.next().toUpperCase().charAt(0);
        System.out.println();
        System.out.print("Enter the respected value: ");
        int input = scanner.nextInt();
        System.out.println();

        if (option == 'D') {
            if(input == 0){
                System.out.println("Distance is: 0");
            }
            else{
                Frog.calculateDistance(input);
            }
        } else if (option == 'T') {
            if(input == 0){
                System.out.println("Time is: 0");
            }
            else{
                Frog.calculateTime(input);
            }
        } else {
            System.out.println("Your input details were incorrect");
        }
    }

    static void calculateTime(int d){
        int cycle = (d/9) + 1;
        int t;
        int difference = (9*cycle) - d;

        // d vs t graph
        //0-0,5-1,8-2,9-4,
        //14-9,17-10,18-12,
        //23-17,26-18,27-20

        if(d % 9 == 0){
            t = (8*(d/9)) - 4;
            System.out.println("Time is: "+ t);
        }
        else{
            if(difference<4 && difference>=1){
                t = (8*cycle) - 6;
                System.out.println("Time is: "+ t);
            }
            else {
                t = (8*cycle) - 7;
                System.out.println("Time is: "+ t);
            }
        }
    }

    static void calculateDistance(int t){
        int cycle;
        int d;

        // t vs d graph
        //0-0,1-5,2-8,3-8,4-9,5.6.7.8-9
        //....9-14,10-17,11-17,12-18,13.14.15.16-18

        if(t % 8 == 0){
            cycle = (t/8);
        }
        else{
            cycle = (t/8) + 1;
        }
        int interval = 8*cycle - t;


        if (interval <= 4){
            d = 9*cycle;
            System.out.println("Distance is: "+ d);
        }
        else if(interval <= 6 && interval > 4){
            d = (9*(cycle-1)) + 8;
            System.out.println("Distance is: "+ d);
        }
        else if(interval == 7){
            d = (9*(cycle-1)) + 5;
            System.out.println("Distance is: "+ d);
        }
        else{
            System.out.println("system is down");
        }
    }
}