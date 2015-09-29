package com.labouardy.tp1;

abstract public class Builder {
	protected StringBuffer content;
	
	public Builder(){
		content=new StringBuffer();
	}
	
	public abstract void startDocument();
	
	public abstract void addText(String str);
	
	public abstract void newLine();
	
	public abstract void endDocument();
	
	public String getContent(){
		return content.toString();
	}
}
