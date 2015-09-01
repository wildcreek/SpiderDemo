package com.example.bean;

public class ColumnItem {
	private int id;

	/**
	 * ����
	 */
	private String title;
	/**
	 * ����
	 */
	private String link;
	/**
	 * ��������
	 */
	private String date;
	/**
	 * ����
	 */
	private String content;

	/**
	 * ����
	 * 
	 */
	private int columnType;


	public int getColumnType() {
		return columnType;
	}

	public void setColumnType(int columnType) {
		this.columnType = columnType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ColumnItem [id=" + id + ", title=" + title + ", link=" + link
				+ ", date=" + date + ", content=" + content + ", columnType="
				+ columnType + "]";
	}


}
