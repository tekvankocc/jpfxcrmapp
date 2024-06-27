package com.teky.jpfxcrmapp.view;

import com.teky.inputforms.InputField;
import com.teky.inputforms.InputForm;
import com.teky.inputforms.InputSelect;
import com.teky.jpfxcrmapp.model.Customer;
import com.teky.jpfxcrmapp.model.Contract;
import java.util.List;
import java.util.function.Consumer;

public class ContractForm extends InputForm {

    private List<Customer> customers;
    private Contract instance;

    public ContractForm(AppView appView) {
        super(appView.getEmptyContainer());

        add("customer", new InputSelect("Ügyfélhez rendelés"));
        add("title", new InputField("Szerződés neve"));
        add("description", new InputField("Szerződés leírása"));
        add("price", new InputField("Bruttó díj/hó"));

        instance = null;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
        String[] options = new String[customers.size() + 1];

        options[0] = "- Ügyfél nélkül -";
        for (int i = 1; i < options.length; i++) {
            options[i] = customers.get(i - 1).getName();
        }

        ((InputSelect) getField("customer")).setOptions(options);
    }

    public void setValues(Contract contract) {
        setValue("title", contract.getTitle());
        setValue("description", contract.getDescription());
        setValue("price", contract.getPrice());

        Customer customer = contract.getCustomer();
        if (customer != null) {
            int index = customers.indexOf(customer);
            setValue("customer", Integer.toString(index + 1));
        }

        instance = contract;
    }

    public void setSubmit(String buttonText, Consumer<Contract> method) {
        addButton(buttonText);
        onSubmit(e
                -> {
            String title = getValue("title");
            String desc = getValue("description");
            String price = getValue("price");
            
            int customerIndex = Integer.parseInt(getValue("customer"));

            Contract contract;
            if (instance == null) {
                contract = new Contract(title, desc, price);
            } else {
                contract = instance;
                contract.setTitle(title);
                contract.setDescription(desc);
                contract.setPrice(price);
            }

            if (customerIndex != 0) {
                Customer customer = customers.get(customerIndex - 1);
                contract.setCustomer(customer);
            } else {
                contract.setCustomer(null);
            }

            method.accept(contract);
        });
    }
}
