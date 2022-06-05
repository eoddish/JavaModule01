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


        TransactionsService transactionsService = new TransactionsService();
        transactionsService.addUser(A);
        transactionsService.addUser(B);
        System.out.println("Balance of A " + transactionsService.getBalance(A.getIdentifier()));
        System.out.println("Balance of B " + transactionsService.getBalance(B.getIdentifier()));
        transactionsService.transferTransaction(A.getIdentifier(), B.getIdentifier(), 1000);
        transactionsService.transferTransaction(A.getIdentifier(), B.getIdentifier(), -5000);
        transactionsService.transferTransaction(B.getIdentifier(), A.getIdentifier(), 500);
        transactionsService.transferTransaction(A.getIdentifier(), B.getIdentifier(), 2000);

        Transaction transactions[] = transactionsService.retrieveTransfers(A.getIdentifier());
        System.out.println("Transactions by A:");
        for (int i = 0; i < transactions.length; i++) {
            System.out.print(transactions[i].getIdentifier() + " Recipient: " + transactions[i].getRecipient().getName());
            System.out.print(", Sender: " + transactions[i].getSender().getName());
            System.out.print(", Transfer category: " + transactions[i].getTransferCategory());
            System.out.println(", Transfer amount: " + transactions[i].getTransferAmount());
        }
        transactions = transactionsService.retrieveTransfers(B.getIdentifier());
        System.out.println("Transactions by B:");
        for (int i = 0; i < transactions.length; i++) {
            System.out.print(transactions[i].getIdentifier() + " Recipient: " + transactions[i].getRecipient().getName());
            System.out.print(", Sender: " + transactions[i].getSender().getName());
            System.out.print(", Transfer category: " + transactions[i].getTransferCategory());
            System.out.println(", Transfer amount: " + transactions[i].getTransferAmount());
        }

        System.out.println("Balance of A " + transactionsService.getBalance(A.getIdentifier()));
        System.out.println("Balance of B " + transactionsService.getBalance(B.getIdentifier()));

        System.out.println("Unpaired transactions before removal:");
        transactions = transactionsService.checkValidity();
        for (int i = 0; i < transactions.length; i++) {
            System.out.print(transactions[i].getIdentifier() + " Recipient: " + transactions[i].getRecipient().getName());
            System.out.print(", Sender: " + transactions[i].getSender().getName());
            System.out.print(", Transfer category: " + transactions[i].getTransferCategory());
            System.out.println(", Transfer amount: " + transactions[i].getTransferAmount());
        }

        transactionsService.removeTransaction(A.getTransactionsList().toArray()[0].getIdentifier(), A.getIdentifier());
        transactions = transactionsService.retrieveTransfers(A.getIdentifier());
        System.out.println("Transactions by A after removal:");
        for (int i = 0; i < transactions.length; i++) {
            System.out.print(transactions[i].getIdentifier() + " Recipient: " + transactions[i].getRecipient().getName());
            System.out.print(", Sender: " + transactions[i].getSender().getName());
            System.out.print(", Transfer category: " + transactions[i].getTransferCategory());
            System.out.println(", Transfer amount: " + transactions[i].getTransferAmount());
        }

        System.out.println("Unpaired transactions after removal:");
        transactions = transactionsService.checkValidity();

        for (int i = 0; i < transactions.length; i++) {
            System.out.print(transactions[i].getIdentifier() + " Recipient: " + transactions[i].getRecipient().getName());
            System.out.print(", Sender: " + transactions[i].getSender().getName());
            System.out.print(", Transfer category: " + transactions[i].getTransferCategory());
            System.out.println(", Transfer amount: " + transactions[i].getTransferAmount());
        }


    }
}
