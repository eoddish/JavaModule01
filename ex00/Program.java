import java.util.*;

public class Program {

    public static void main(String args[]) {
        User A = new User("Alice", 42000);
        User B = new User("Bob", 21000);
        Transaction first = new Transaction(A, B, 2000);
        Transaction second = new Transaction(B, A, -2000);

        System.out.print(A.getName() + " ");
        System.out.println(A.getBalance());
        System.out.print(B.getName() + " ");
        System.out.println(B.getBalance());

        System.out.print(first.getIdentifier() + " Recipient: " + first.getRecipient().getName());
        System.out.print(", Sender: " + first.getSender().getName());
        System.out.print(", Transfer category: " + first.getTransferCategory());
        System.out.println(", Transfer amount: " + first.getTransferAmount());

        System.out.print(second.getIdentifier() + " Recipient: " + second.getRecipient().getName());
        System.out.print(", Sender: " + second.getSender().getName());
        System.out.print(", Transfer category: " + second.getTransferCategory());
        System.out.println(", Transfer amount: " + second.getTransferAmount());
    }
}
