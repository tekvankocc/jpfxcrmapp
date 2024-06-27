package com.teky.jpfxcrmapp.controller;

import com.teky.jpfxcrmapp.model.Contract;
import com.teky.jpfxcrmapp.service.DataService;
import com.teky.jpfxcrmapp.view.ContractForm;
import com.teky.jpfxcrmapp.view.ContractTable;
import com.teky.utility.MessageBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractController extends BaseController {

    @Autowired
    DataService service;
    ContractTable table;

    @Override
    public void newActivity() {
        appView.setTitle("Új szerződés rögzítés");

        ContractForm form = new ContractForm(appView);
        form.setCustomers(service.getCustomersForList());
        form.setSubmit("Létrehoz", contract
                -> {
            if (service.saveContract(contract)) {
                MessageBox.Show("Létrehozva", "Új szerződés rögzítve");
                form.clear();
            } else {
                MessageBox.Show("Hibásan kitöltve", null, service.getError(), MessageBox.ERROR);
            }
        });
    }

    @Override
    public void listActivity() {
        appView.setTitle("Szerződések listája");

        table = new ContractTable(appView);
        table.setItems(service.getContracts());
        table.addAction("...", contract -> editActivity(contract));
        table.addAction("Állapot vált.", contract -> doneActivity(contract));
    }

    public void editActivity(Contract contract) {
        appView.setTitle("Feladat szerkesztése");

        ContractForm form = new ContractForm(appView);
        form.setCustomers(service.getCustomersForList());
        form.setValues(contract);
        form.setSubmit("Adatok mentése", modifiedContract
                -> {
            if (service.saveContract(contract)) {
                MessageBox.Show("Módosítva", "A szerződés adatai sikeresen módosultak");
            } else {
                MessageBox.Show("Hibásan kitöltve", null, service.getError(), MessageBox.ERROR);
            }
        });
    }

    public void doneActivity(Contract contract) {
        service.updateContractAsDone(contract);
        table.setItems(service.getContracts());
    }
}
