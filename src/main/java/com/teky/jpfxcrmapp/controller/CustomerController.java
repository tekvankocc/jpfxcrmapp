package com.teky.jpfxcrmapp.controller;

import com.teky.jpfxcrmapp.model.Customer;
import com.teky.jpfxcrmapp.service.DataService;
import com.teky.jpfxcrmapp.view.CustomerForm;
import com.teky.jpfxcrmapp.view.CustomerTable;
import com.teky.utility.MessageBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerController extends BaseController {

    @Autowired
    DataService service;
    CustomerTable table;

    @Override
    public void newActivity() {
        appView.setTitle("Új Ügyfél rögzítése");

        CustomerForm form = new CustomerForm(appView);
        form.setSubmit("Létrehoz", customer
                -> {
            if (service.saveCustomer(customer)) {
                MessageBox.Show("Létrehozva", "Az új Ügyfél rögzítése megtörtént");
                form.clear();
            } else {
                MessageBox.Show("Hibásan kitöltve", null, service.getError(), MessageBox.ERROR);
            }
        });
    }

    @Override
    public void listActivity() {
        appView.setTitle("Ügyfelek listája");

        table = new CustomerTable(appView);
        table.setItems(service.getCustomers());
        table.addAction("...", customer -> editActivity(customer));
        table.addAction("X", customer -> delActivity(customer));
    }

    public void editActivity(Customer customer) {
        appView.setTitle("Ügyfél szerkesztése");

        CustomerForm form = new CustomerForm(appView);
        form.setValues(customer);
        form.setSubmit("Adatok mentése", modifiedProject
                -> {
            if (service.saveCustomer(customer)) {
                MessageBox.Show("Módosítva", "Az Ügyfél adatai módosítva");
            } else {
                MessageBox.Show("Hibásan kitöltve", null, service.getError(), MessageBox.ERROR);
            }
        });
    }

    public void delActivity(Customer customer) {
        service.deleteCustomer(customer);
        table.setItems(service.getCustomers());
    }
}
