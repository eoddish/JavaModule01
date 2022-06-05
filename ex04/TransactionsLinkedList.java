import java.util.*;
public class TransactionsLinkedList implements TransactionsList {

    private Transaction first;
    private int size;

    public void addTransaction(Transaction transaction) {
        Transaction newtransaction = new Transaction(transaction);
       newtransaction.setNext(first);
       first = newtransaction;
       size++;
    }
    public void removeTransactionById(UUID uuid) {
        if (size == 0)
            throw new TransactionNotFoundException("TransactionNotFound");
        Transaction temp = first;
        if (first.getIdentifier() == uuid) {
            first = first.getNext();
            size--;
            return;
        }
        while (temp != null && temp.getNext() != null) {
            if (temp.getNext().getIdentifier() == uuid) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            }
            temp = temp.getNext();
        }
        throw new TransactionNotFoundException("TransactionNotFound");
    }
    public Transaction[] toArray() {
        Transaction[] result = new Transaction[this.size];
        Transaction temp = first;
        for (int i = 0; i < this.size && temp != null; i++) {
            result[i] = temp;
            temp = temp.getNext();
        }

        return result;
    }
}