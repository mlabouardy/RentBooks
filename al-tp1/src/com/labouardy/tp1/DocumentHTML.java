package com.labouardy.tp1;

public class DocumentHTML extends Builder{

	@Override
	public void startDocument() {
		content.append("<html><head></head><body>");
	}

	@Override
	public void addText(String str) {
		content.append(str);
	}

	@Override
	public void newLine() {
		content.append("<br/>");
	}

	@Override
	public void endDocument() {
		content.append("</body></html");
	}

}
