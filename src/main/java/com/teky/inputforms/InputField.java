package com.teky.inputforms;

import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class InputField 
{
	private VBox container;
	private Label label;
	protected Control field;

	public InputField(String labelText, String fieldText, Pane parent) 
	{
		container = new VBox();
		label = new Label(labelText);
		field = createField();
		
		container.getChildren().add(label);
		container.getChildren().add(field);
		
		if(fieldText != null){ setValue(fieldText); }
		if(parent != null){ placeTo(parent); }
	}
	public InputField(String labelText, Pane parent)
	{
		this(labelText, "", parent);
	}
	public InputField(String labelText)
	{
		this(labelText, "", null);
	}
	
	public void placeTo(Pane parent)
	{
		parent.getChildren().add(container);
	}
	
	public void setValue(String value)
	{
		((TextField)field).setText(value);
	}
	public String getValue()
	{
		return ((TextField)field).getText();
	}
	
	protected Control createField()
	{
		return new TextField();
	}
}
