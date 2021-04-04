import java.util.Arrays;

public class Storage implements PhoneInfo {
    private User[] storage = new User[10000];
    private int storageSize = 0;

    public void clear() {
        Arrays.fill(this.storage, null);
        this.storageSize = 0;
        System.out.println("Storage cleared");
    }

    public void save(User user) {
        this.storage[this.storageSize] = user;
        this.storageSize++;
    }

    public void delete(int id) {
        for (int i = 0; i < this.storageSize; i++) {
            if (this.storage[i].getId() == id) {
                this.storage[i] = this.storage[this.storageSize - 1];
                this.storage[this.storageSize - 1] = null;
                this.storageSize--;
            }
        }
    }

    public User[] getAll() {
        User[] allUsers = new User[this.storageSize];
        if (this.storageSize == 0) {
            System.out.println("Storage is empty");
        } else {
            allUsers = Arrays.copyOf(this.storage, this.storageSize);
        }
        return allUsers;
    }

    public int size() {
        return this.storageSize;
    }

    public void print(User[] users) {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Override
    public void getUserByCityCall(int minutes) {
        for (User user : getAll()) {
            if (user.getPhone().getPhoneTimeCity() >= minutes) {
                System.out.println(user.toString());
            }
        }
    }

    @Override
    public void getUserByCallBetweenCities() {
        for (User user : getAll()) {
            if (user.getPhone().getPhoneTimeBetweenCities() > 0) {
                System.out.println(user.toString());
            }
        }
    }

    @Override
    public void getAllUsersByAlphabet() {
        User[] u = getAll();
        User temp;
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < u.length; j++) {
                if (u[i].getName().toLowerCase().compareTo(u[j].getName().toLowerCase()) <= 0) {
                    temp = u[i];
                    u[i] = u[j];
                    u[j] = temp;
                }
            }

        }
        print(u);
    }

    @Override
    public void getInternetUsers() {
        User[] u = getAll();
        User temp;
        int counter = 0;
        for (int i = 0; i < u.length; i++) {
            for (int j = i; j < u.length; j++) {
                if (u[i].getPhone().getInternetTraffic() < u[j].getPhone().getInternetTraffic()) {
                    temp = u[i];
                    u[i] = u[j];
                    u[j] = temp;
                }
            }
        }
        while (u[counter].getPhone().getInternetTraffic() != 0 && counter != 10) {
            System.out.println(u[counter]);
            counter++;
        }
    }
}
