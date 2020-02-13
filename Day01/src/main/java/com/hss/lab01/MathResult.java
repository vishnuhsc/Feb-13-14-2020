package com.hss.lab01;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MathResult {

	private String operation;
	
	@JsonProperty(value = "parameter1")
	private int num1;
	
	@JsonProperty(value = "parameter2")
	private int num2;
	private int result;
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
}
