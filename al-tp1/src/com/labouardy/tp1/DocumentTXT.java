package com.labouardy.tp1;

public class DocumentTXT extends Builder{

	@Override
	public void startDocument() {}

	@Override
	public void addText(String str) {
		content.append(str);
	}

	@Override
	public void newLine() {
		content.append("\n");
	}

	@Override
	public void endDocument() {}

}
