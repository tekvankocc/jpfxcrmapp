package com.teky.jpfxcrmapp.view;

import com.teky.inputforms.InputField;
import com.teky.inputforms.InputForm;
import com.teky.inputforms.InputSelect;
import com.teky.jpfxcrmapp.model.Customer;
import java.util.function.Consumer;

public class CustomerForm extends InputForm {

    private Customer instance;

    public CustomerForm(AppView appView) {
        super(appView.getEmptyContainer());

        add("name", new InputField("Ügyfél neve"));
        add("address", new InputField("Cím"));
        add("contact", new InputField("Elérhetőség"));
        add("information", new InputSelect("Infó", Customer.INFORMATION));

        instance = null;
    }

    public void setValues(Customer customer) {
        setValue("name", customer.getName());
        setValue("address", customer.getAddress());
        setValue("contact", customer.getContact());
        setValue("information", Integer.toString(customer.getInformation()));

        instance = customer;
    }

    public void setSubmit(String buttonText, Consumer<Customer> method) {
        addButton(buttonText);
        onSubmit(e
                -> {
            String name = getValue("name");
            String address = getValue("address");
            String contact = getValue("contact");
            int information = Integer.parseInt(getValue("information"));

            Customer customer;
            if (instance == null) {
                customer = new Customer(name, address, contact, information);
            } else {
                customer = instance;
                customer.setName(name);
                customer.setAddress(address);
                customer.setContact(contact);
                customer.setInformation(information);
            }
            method.accept(customer);
        });
    }
}
