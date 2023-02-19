package phone;

import phone.Phonable;

public class Phone implements Phonable {

    private int debt;
    private int credit;
    private int phoneTimeCity;
    private int phoneTimeBetweenCities;
    private int gb;
    private int internetTraffic;

    public int getDebt() {
        return debt;
    }


    public int getCredit() {
        return credit;
    }

    public int getPhoneTimeCity() {
        return phoneTimeCity;
    }


    public int getPhoneTimeBetweenCities() {
        return phoneTimeBetweenCities;
    }


    public int getGb() {
        return gb;
    }

    public int getInternetTraffic() {
        return internetTraffic;
    }


    @Override
    public String toString() {
        return "Credit: " + getCredit() + ",Debt: " + Math.abs(getDebt()) + ",Call Time in City: " + getPhoneTimeCity() + ",Call Time Between Cities: " + getPhoneTimeBetweenCities() + ",Internet Traffic: " + getInternetTraffic();
    }

    @Override
    public void addCredit(int amount) {
        if (amount > 0 && this.credit == 0 && this.debt == 0) {
            this.credit = this.credit + amount;
        } else if (amount > 0 && this.credit == 0 && this.debt < 0 && (this.debt + amount) > 0) {
            this.credit = (this.debt + amount);
            this.debt = 0;
        } else if (amount > 0 && this.credit == 0 && this.debt < 0 && (this.debt + amount) <= 0) {
            this.debt += amount;
        } else {
            System.out.println("Wrong input");
        }
    }

    @Override
    public void callCity(int minutes) {
        if (minutes > 0 && this.credit > 0 && (this.credit - minutes) >= 0) {
            this.credit -= minutes;
            this.phoneTimeCity += minutes;
        } else if (minutes > 0 && this.credit > 0 && (this.credit - minutes) < 0) {
            this.debt -= (minutes - this.credit);
            this.credit = 0;
            this.phoneTimeCity += minutes;
        } else if (minutes > 0 && this.credit == 0) {
            this.debt -= minutes;
            this.phoneTimeCity += minutes;
        } else {
            System.out.println("Wrong input");
        }
    }

    @Override
    public void callBetweenCities(int minutes) {
        if (minutes > 0 && this.credit > 0 && (this.credit - (minutes * 2)) >= 0) {
            this.credit -= (minutes * 2);
            this.phoneTimeBetweenCities += minutes;
        } else if (minutes > 0 && this.credit > 0 && (this.credit - (minutes * 2)) < 0) {
            this.debt -= ((minutes * 2) - this.credit);
            this.credit = 0;
            this.phoneTimeBetweenCities += minutes;
        } else if (minutes > 0 && this.credit == 0) {
            this.debt -= (minutes * 2);
            this.phoneTimeBetweenCities += minutes;
        } else {
            System.out.println("Wrong input");
        }

    }

    @Override
    public void buyInternet(int gb) {
        if (gb > 0 && this.credit > 0 && (this.credit - (gb * 2)) >= 0) {
            this.credit -= (gb * 2);
            this.gb += gb;
        } else if (gb > 0 && this.credit > 0 && (this.credit - (gb * 2)) < 0) {
            this.debt -= ((gb * 2) - this.credit);
            this.credit = 0;
        } else if (gb > 0 && this.credit == 0) {
            this.debt -= (gb * 2);
        } else {
            System.out.println("Wrong input");
        }
    }

    @Override
    public void useInternet(int gb) {
        if (gb > 0 && (this.gb - gb) >= 0) {
            this.internetTraffic += gb;
            this.gb -= gb;
        } else if (gb > 0 && (this.gb - gb) < 0) {
            this.internetTraffic += gb;
            buyInternet((gb - this.gb));
            this.gb = 0;
        } else {
            System.out.println("Wrong input");
        }
    }
}
