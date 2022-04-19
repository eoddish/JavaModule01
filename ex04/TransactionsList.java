import java.util.*;
public interface TransactionsList {
    public void addTransaction(Transaction transaction);
    public void removeTransactionById(UUID uuid);
    public Transaction[] toArray();
}