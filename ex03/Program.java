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

        TransactionsList transactionsList = new TransactionsLinkedList();
        transactionsList.addTransaction(first);
        transactionsList.addTransaction(second);

        Transaction[] transactions = transactionsList.toArray();
        for (int i = 0; i < transactions.length; i++) {
            System.out.print(transactions[i].getIdentifier() + " Recipient: " + transactions[i].getRecipient().getName());
            System.out.print(", Sender: " + transactions[i].getSender().getName());
            System.out.print(", Transfer category: " + transactions[i].getTransferCategory());
            System.out.println(", Transfer amount: " + transactions[i].getTransferAmount());
        }

        System.out.println("Remove transaction by id:");
        transactionsList.removeTransactionById(first.getIdentifier());
        transactions = transactionsList.toArray();
        for (int i = 0; i < transactions.length; i++) {
            System.out.print(transactions[i].getIdentifier() + " Recipient: " + transactions[i].getRecipient().getName());
            System.out.print(", Sender: " + transactions[i].getSender().getName());
            System.out.print(", Transfer category: " + transactions[i].getTransferCategory());
            System.out.println(", Transfer amount: " + transactions[i].getTransferAmount());
        }

        System.out.println("Remove transaction by non-existent id:");
        transactionsList.removeTransactionById(UUID.randomUUID());
    }
}
