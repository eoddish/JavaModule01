import java.util.*;
public class TransactionsLinkedList implements TransactionsList {

    public class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }

    private Transaction first;
    private int size;

    public void addTransaction(Transaction transaction) {
       transaction.next = first;
       first = transaction;
       size++;
    }
    public void removeTransactionById(UUID uuid) {
        Transaction temp = first;
        if (temp.getIdentifier() == uuid) {
            first = temp.next;
            return;
        }
        while (temp.next != null) {
            if (temp.next.getIdentifier() == uuid) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
        throw new TransactionNotFoundException("TransactionNotFound");
    }
    public Transaction[] toArray() {
        Transaction[] result = new Transaction[this.size];
        Transaction temp = first;
        for (int i = 0; i < this.size; i++) {
            result[i] = temp;
            temp = temp.next;
        }
        return result;
    }
}