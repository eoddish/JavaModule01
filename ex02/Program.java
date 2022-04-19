import java.util.*;
public class Program {
    public static void main(String args[]) {
        User A = new User("Alice", 42000);
        User B = new User("Bob", 21000);

        System.out.print(A.getIdentifier() + " " + A.getName() + " ");
        System.out.println(A.getBalance());
        System.out.print(B.getIdentifier() + " " + B.getName() + " ");
        System.out.println(B.getBalance());

        UsersList usersList = new UsersArrayList();
        usersList.addUser(A);
        usersList.addUser(B);
        System.out.println("number of users: " + usersList.getNumberOfUsers());
        System.out.println("first user: " + usersList.getUserByIndex(0).getName());
        System.out.println("second user: " + usersList.getUserByIndex(1).getName());
        System.out.println("user with an id of user B: " + usersList.getUserById(B.getIdentifier()).getName());
        System.out.println("user with an id of user A: " + usersList.getUserById(A.getIdentifier()).getName());
        System.out.println("user with a non-existent id: " + usersList.getUserById(42).getName());



    }
}
