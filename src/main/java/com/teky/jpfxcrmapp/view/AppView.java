package com.teky.jpfxcrmapp.view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class AppView {

    private Label title;
    private Pane container;

    public AppView(Label title, Pane container) {
        this.title = title;
        this.container = container;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setContent(Node content) {
        var children = this.container.getChildren();
        children.clear();
        children.add(content);
    }

    public Pane getEmptyContainer() {
        container.getChildren().clear();
        return container;
    }
}
