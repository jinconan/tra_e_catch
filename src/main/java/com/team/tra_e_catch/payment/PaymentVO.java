package com.team.tra_e_catch.payment;

public class PaymentVO {
	private int dtype_no;
	private String path;
	private String content;
	private int doc_no;
	private String up_date;
	private int emp_no;
	
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public int getDtype_no() {
		return dtype_no;
	}
	public void setDtype_no(int dtype_no) {
		this.dtype_no = dtype_no;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}
	public String getUp_date() {
		return up_date;
	}
	public void setUp_date(String up_date) {
		this.up_date = up_date;
	}
	
}
