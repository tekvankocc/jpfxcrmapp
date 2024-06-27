package com.teky.jpfxcrmapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "crm__customers")
public class Customer {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 50)
    @NotBlank(message = "Név megadása kötelező")
    @Size(min = 3, message = "Név túl rövid")
    @Pattern(regexp = "^[a-zA-Zá-űÁ-Ű0-9. ]+$", message = "A név nem megengedett karaktereket tartalmaz")
    private String name;
    @NotBlank(message = "Cím megadása kötelező")
    private String address;
    @NotBlank(message = "Elérhetőség megadása kötelező")
    private String contact;
    private int information;

    public Customer(String name, String address, String contact, int information) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.information = information;
    }

    public Customer() {
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public int getInformation() {
        return information;
    }
    
    public String getInformationText() {
        return INFORMATION[information];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setInformation(int information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", information=" + information + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        return this.id == other.id;
    }

    public final static String[] INFORMATION = {"Magánszemély", "Cég", "Egyéb"};
}
