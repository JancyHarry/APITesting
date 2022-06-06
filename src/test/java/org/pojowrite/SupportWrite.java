package org.pojowrite;

public class SupportWrite {
	private String url;
	private String text;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public SupportWrite(String url, String text) {
		super();
		this.url = url;
		this.text = text;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
