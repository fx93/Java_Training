package anonymousInner;

abstract class AbsInner{
    public abstract void print();
}

public class AnonymousInner{
    public static void main(String [] args){
        AbsInner inner = new AbsInner(){
            public void print(){
                System.out.println("Wow Congratz...!");
            }
        };
        inner.print();
    }
}