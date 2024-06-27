package com.teky.jpfxcrmapp.view;

import com.teky.gui.Table;
import com.teky.jpfxcrmapp.model.Contract;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ContractTable extends Table<Contract> {

    public ContractTable(AppView appView) {
        super(appView.getEmptyContainer());
        VBox.setVgrow(this, Priority.ALWAYS);

        addColumn("Szerződés neve", "title", 140);
        addColumn("Szerződés leírása", "description", 200);
        addColumn("Ügyfél", "customerName", 100);
        addColumn("Bruttó díj/hó", "priceHuf", 55);
        addColumn("Állapot", "statusText", 55);
        
        setPlaceholder("Nincsenek szerződések");
    }

}
