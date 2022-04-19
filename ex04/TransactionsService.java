import java.util.*;
public class TransactionsService {

    private UsersList usersList;

    public TransactionsService() {
        this.usersList = new UsersArrayList();
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }
    public int getBalance(int userId) {
        return usersList.getUserById(userId).getBalance();
    }
    public void transferTransaction(int recipient, int sender, int transferAmount) {

        Transaction transaction1 = new Transaction(usersList.getUserById(recipient), usersList.getUserById(sender), transferAmount);
        Transaction transaction2 = new Transaction(usersList.getUserById(sender), usersList.getUserById(recipient), -transferAmount);
        transaction2.setIdentifier(transaction1.getIdentifier());
        usersList.getUserById(recipient).getTransactionsList().addTransaction(transaction1);
        usersList.getUserById(sender).getTransactionsList().addTransaction(transaction2);

    }
    public Transaction[] retrieveTransfers(int userId) {
        return usersList.getUserById(userId).getTransactionsList().toArray();
    }
    public void removeTransaction(UUID transactionId, int userId) {
        usersList.getUserById(userId).getTransactionsList().removeTransactionById(transactionId);
    }
    public Transaction[] checkValidity() {
        TransactionsList checker = new TransactionsLinkedList();
        for (int i = 0; i < usersList.getNumberOfUsers(); i++) {
            Transaction[] userTransactions = usersList.getUserByIndex(i).getTransactionsList().toArray();
            for (int j = 0; j < userTransactions.length; j++) {
                try {
                    checker.removeTransactionById(userTransactions[j].getIdentifier());
                } catch (TransactionNotFoundException e) {
                    checker.addTransaction(userTransactions[j]);
                }
            }
        }
        return checker.toArray();
    }
}