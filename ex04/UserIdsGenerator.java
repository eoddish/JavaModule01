public  class UserIdsGenerator {
    private int numberOfIds = 0;
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();

    private UserIdsGenerator() {}
    public static UserIdsGenerator getInstance() {
        return INSTANCE;
    }
    public int generateId() {
        return numberOfIds++;
    }
}
