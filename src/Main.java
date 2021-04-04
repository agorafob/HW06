public class Main {
    static final Storage NEW_STORAGE = new Storage();

    public static void main(String[] args) {

        User u1 = new User(1, "b", "b", "b", 5, "k", "l", 4, 55);
        u1.getPhone().addCredit(100);
        u1.getPhone().callBetweenCities(20);
        u1.getPhone().callCity(10);
        u1.getPhone().buyInternet(10);
        u1.getPhone().useInternet(15);
        u1.getPhone().callCity(30);

        User u2 = new User(2, "c", "C", "c", 15, "o", "v", 15, 103);
        u2.getPhone().addCredit(80);
        u2.getPhone().callCity(35);
        u2.getPhone().buyInternet(5);
        u2.getPhone().useInternet(3);
        u2.getPhone().callCity(20);

        User u3 = new User(3, "a", "a", "a", 10, "l", "b", 12, 20);
        u3.getPhone().addCredit(200);
        u3.getPhone().callBetweenCities(45);
        u3.getPhone().callCity(20);

        User u4 = new User(4, "e", "E", "e", 30, "z", "y", 3, 14);
        u4.getPhone().addCredit(150);
        u4.getPhone().callBetweenCities(35);
        u4.getPhone().callCity(30);
        u4.getPhone().buyInternet(10);
        u4.getPhone().useInternet(5);


        NEW_STORAGE.save(u1);
        NEW_STORAGE.save(u2);
        NEW_STORAGE.save(u3);
        NEW_STORAGE.save(u4);
        System.out.println("Пользователи по внутрегородским звонкам");
        NEW_STORAGE.getUserByCityCall(30);
        System.out.println("Пользователи по международным звонкам");
        NEW_STORAGE.getUserByCallBetweenCities();
        System.out.println("Пользователи в алфавитном порядке");
        NEW_STORAGE.getAllUsersByAlphabet();
        System.out.println("Пользователи интернета");
        NEW_STORAGE.getInternetUsers();

    }
}
