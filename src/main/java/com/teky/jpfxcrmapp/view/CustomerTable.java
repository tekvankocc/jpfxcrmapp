package com.teky.jpfxcrmapp.view;

import com.teky.gui.Table;
import com.teky.jpfxcrmapp.model.Customer;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CustomerTable extends Table<Customer> {

    public CustomerTable(AppView appView) {
        super(appView.getEmptyContainer());
        VBox.setVgrow(this, Priority.ALWAYS);

        addColumn("Név", "name", 150);
        addColumn("Cím", "address", 175);
        addColumn("Elérhetőség", "contact", 200);
        addColumn("Infó", "informationText", 75);

        setPlaceholder("Nincsenek Ügyfelek");
    }
}
