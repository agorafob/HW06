public class User {
    private int id;
    private String sName;
    private String name;
    private String fName;
    private int creditCartNumber;
    private Address address = new Address();
    private Phone phone = new Phone();

    public User(int id, String sName, String name, String fName, int creditCartNumber, String city, String street, int house, int flat) {
        setId(id);
        setsName(sName);
        setName(name);
        setfName(fName);
        setCreditCartNumber(creditCartNumber);
        setAddress(city, street, house, flat);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String city, String street, int house, int flat) {
        this.address.setCity(city);
        this.address.setStreet(street);
        this.address.setHouse(house);
        this.address.setFlat(flat);
    }

    public Phone getPhone() {
        return phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getCreditCartNumber() {
        return creditCartNumber;
    }

    public void setCreditCartNumber(int creditCartNumber) {
        this.creditCartNumber = creditCartNumber;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ",Surname: " + getsName() + ",Name: " + getName() + ",Fathers Name: " + getfName() + ",CC Number: " + getCreditCartNumber() + ",Address: " + getAddress().toString() + ",Phone details: " + getPhone().toString();
    }
}
