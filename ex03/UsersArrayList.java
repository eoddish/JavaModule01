public class UsersArrayList implements UsersList {

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }

    private User [] users = new User[10];
    private static int numberOfUsers = 0;

    public void addUser(User user) {

        if (numberOfUsers == users.length) {
            users = new User[numberOfUsers += numberOfUsers / 2];
        }
        users[numberOfUsers] = user;
        numberOfUsers++;
    }
    public User getUserById(int id) {
        for (int i = 0; i < numberOfUsers; i++) {
            if (users[i].getIdentifier() == id)
                return users[i];
        }
        throw new UserNotFoundException("UserNotFound");
    }
    public User getUserByIndex(int index) {
        return users[index];
    }
    public int getNumberOfUsers() {
        return this.numberOfUsers;
    }
}
