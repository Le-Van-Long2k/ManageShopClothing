package longlevan2k.com.example.manageshopclothing.model.entity;

import longlevan2k.com.example.manageshopclothing.main.Customer;

public class Bill {
    private int id;
    private Customer customer;
    private Item item;
    private String time;
    private boolean status;

    public Bill(int id, Customer customer, Item item, String time, boolean status) {
        this.id = id;
        this.customer = customer;
        this.item = item;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
