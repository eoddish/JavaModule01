import java.util.*;
public class Program {
    public static void main(String args[]) {
        User A = new User("Alice", 42000);
        User B = new User("Bob", 21000);

        System.out.print(A.getIdentifier() + " " + A.getName() + " ");
        System.out.println(A.getBalance());
        System.out.print(B.getIdentifier() + " " + B.getName() + " ");
        System.out.println(B.getBalance());

    }
}
