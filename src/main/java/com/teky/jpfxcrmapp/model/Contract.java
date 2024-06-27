package com.teky.jpfxcrmapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "crm__contracts")
public class Contract {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 25)
    @NotBlank(message = "Szerződés név megadása kötelező")
    @Size(min = 3, max = 25, message = "A szerződés neve 3-25 karakterig terjedhet")
    @Pattern(regexp = "^[a-zA-Zá-űÁ-Ű0-9. ]+$", message = "Szerződés neve nem megengedett karaktereket tartalmaz")
    private String title;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Szerződés leírása kötelező")
    private String description;
    @NotBlank(message = "Ár megadása kötelező")
    @Pattern(regexp = "^[0-9]+$", message = "Pozitív egész szám engedett, szóköz nélkül")
    private String price;
    private boolean status;

    @ManyToOne
    private Customer customer;

    public Contract(String title, String description, String price) {
        this.title = title;
        this.description = description;
        this.price = price;

        status = false;
        customer = null;
    }

    public Contract() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getStatus() {
        return status;
    }

    public String getPrice() {
        return price;
    }
    public String getPriceHuf() {
        return price+" HUF";
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public String getCustomerName() {
        if (customer != null) {
            return customer.getName();
        }
        return "-";
    }

    public String getStatusText() {
        return status ? "Aktív" : "Inaktív";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" + "id=" + id + ", title=" + title + ", description=" + description + ", price=" + price + ", status=" + status + ", customer=" + customer + '}';
    }



}
