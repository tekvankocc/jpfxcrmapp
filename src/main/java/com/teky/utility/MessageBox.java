package com.teky.utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageBox 
{
	public static void Show(String title, String header, String content, int type)
	{
		AlertType aType = AlertType.INFORMATION;
		if(type == WARN){ aType = AlertType.WARNING; }
		else if(type == ERROR){ aType = AlertType.ERROR; }
		
		Alert message = new Alert(aType);
		message.setTitle(title);
		message.setHeaderText(header);
		message.setContentText(content);
		message.showAndWait();
	}
	public static void Show(String title, String header, String content)
	{
		Show(title, header, content, 0);
	}
	public static void Show(String title, String content)
	{
		Show(title, null, content, 0);
	}
	
	public static final int INFO = 0;
	public static final int WARN = 1;
	public static final int ERROR = 2;
}
