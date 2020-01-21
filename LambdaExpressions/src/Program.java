
//Without Lambda Expression
public abstract class Program implements Calculator{
    public static void main(String[] args) {
        Calculator c = new Calculator() {
            @Override
            public int power(int x) {
                return x*x;
            }
        };

        System.out.println(c.power(5));
    }
}
