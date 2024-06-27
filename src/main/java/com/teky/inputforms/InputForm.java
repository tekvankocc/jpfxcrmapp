package com.teky.inputforms;

import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class InputForm 
{
	private HashMap<String, InputField> fields;
	private VBox container;
	private Button button;
	
	public InputForm(Pane root) 
	{
		container = new VBox();
		container.setSpacing(20);
		container.setPadding(new Insets(20, 20, 20, 20));
		root.getChildren().add(container);
		
		fields = new HashMap<>();
	}	

	public void add(String key, InputField field) 
	{
		fields.put(key, field);
		field.placeTo(container);
	}
	public InputField getField(String key)
	{
		return fields.get(key);
	}
	public String getValue(String key) 
	{
		if(fields.containsKey(key))
		{
			return fields.get(key).getValue();
		}
		return "";
	}
	public void setValue(String key, String value)
	{
		if(fields.containsKey(key))
		{
			fields.get(key).setValue(value);
		}
	}
	public void clear()
	{
		fields.forEach((key, field) -> 
		{
			field.setValue("");
		});
	}

	public void addButton(String buttonText) 
	{
		button = new Button(buttonText);
		container.getChildren().add(button);
	}
	public void onSubmit(EventHandler<ActionEvent> action)
	{
		button.setOnAction(action);
	}
}
