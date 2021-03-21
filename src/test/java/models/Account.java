package models;

public class Account {
    String accountName1;
    String phone;
    String website;
    String billingCity;
    String shippingCity;

    public Account(String accountName1, String phone, String website, String billingCity, String shippingCity) {
        this.accountName1 = accountName1;
        this.phone = phone;
        this.website = website;
        this.billingCity = billingCity;
        this.shippingCity = shippingCity;
    }

    public String getAccountName1() {
        return accountName1;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName1='" + accountName1 + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", shippingCity='" + shippingCity + '\'' +
                '}';
    }
}
