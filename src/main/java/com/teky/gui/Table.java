package com.teky.gui;

import java.util.List;
import java.util.function.Consumer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class Table <T> extends TableView<T>
{
	public Table(Pane root)
	{
		super();
		root.getChildren().add(this);
	}
	
	public void addColumn(String header, String propertyName, int width)
	{
		TableColumn<T, String> column = new TableColumn<>(header);
		column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
		column.setMinWidth(width);
		getColumns().add(column);
	}
	public void addAction(String buttonText, Consumer<T> onClick)
	{
		TableColumn<T, String> column = new TableColumn<>();
		Callback<TableColumn<T, String>, TableCell<T, String>> factory;
		factory = new Callback<>() {
			@Override
			public TableCell<T, String> call(TableColumn<T, String> param) 
			{
				TableCell<T, String> cell = new TableCell<>()
				{
					@Override
					protected void updateItem(String item, boolean empty) 
					{
						super.updateItem(item, empty);
						
						if(empty)
						{
							setGraphic(null);
						}
						else
						{
							Button button = new Button(buttonText);
							button.setOnAction(e -> 
							{
								int index = getIndex();
								//T entity = getTableView().getItems().get(index);
								T entity = getTableRow().getItem();
								
								onClick.accept(entity);
							});
							setGraphic(button);
						}
						setText(null);
					}
					
				};
				return cell;
			}
		};
		column.setCellFactory(factory);
		getColumns().add(column);
	}
	public void setItems(List<T> items)
	{
		var list = getItems();
		list.clear();
		list.addAll(items);
	}
	public void setPlaceholder(String placeholder)
	{
		setPlaceholder(new Label(placeholder));
	}
}
