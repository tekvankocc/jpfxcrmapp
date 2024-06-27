package com.teky.inputforms;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

public class InputSelect extends InputField
{
	public InputSelect(String labelText, String[] options, Pane parent) 
	{
		super(labelText, null, parent);
		if(options != null)
		{
			setOptions(options);
		}
	}	
	public InputSelect(String labelText, String[] options) 
	{
		this(labelText, options, null);
	}
	public InputSelect(String labelText) 
	{
		this(labelText, null, null);
	}

	@Override
	public String getValue() 
	{
		ComboBox comboBox = (ComboBox)field;
		int index = comboBox.getSelectionModel().getSelectedIndex();
		return Integer.toString(index);
	}
	@Override
	public void setValue(String value)
	{
		int index = (value == "" ? 0 : Integer.parseInt(value));
		ComboBox comboBox = (ComboBox)field;
		((ComboBox)field).getSelectionModel().select(index);
	}
	public void setOptions(String[] options)
	{
		var items = ((ComboBox)field).getItems();
		items.clear();
		items.addAll(options);
		
		((ComboBox)field).getSelectionModel().select(0);
	}
	
	@Override
	protected Control createField() 
	{
		return new ComboBox();
	}
	
}
