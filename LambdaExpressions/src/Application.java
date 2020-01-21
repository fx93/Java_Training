
//With Lambda Expression
public class Application {
    public static void main(String[] args) {
        Calculator c=x->x*x;
        int y = c.power(5);
        System.out.println(y);
    }
}
