package com.greedy.section02.reflection;

public class Account {

	private String backCode;
	private String accNo;
	private String accPwd;
	private int balance;
	
	public Account() {

	}

	public Account(String backCode, String accNo, String accPwd) {
		super();
		this.backCode = backCode;
		this.accNo = accNo;
		this.accPwd = accPwd;
	}

	public Account(String backCode, String accNo, String accPwd, int balance) {
		super();
		this.backCode = backCode;
		this.accNo = accNo;
		this.accPwd = accPwd;
		this.balance = balance;
	}
	
	public String getBalance() {
		
		return this.accNo + " 계좌의 현재 잔액은 " + this.balance + "원 입니다.";
	}
	
	public String deposit(int money) {
		
		String str = "";
		
		if(money >= 0) {
			
			this.balance += money;
			str = money + "원이 입금되었습니다.";
		} else {
			
			str = "금액을 잘못 입력하셨습니다.";
		}
		
		return str;
	}
	
	public String withDraw(int money) {
		
		String str = "";
		
		if(this.balance >= money) {
			
			this.balance -= money;
			str = money + "원이 출금되었습니다.";
		} else {
			
			str = "잔액이 부족합니다. 잔액을 확인해주세요";
		}
		
		return str;
	}
	
}
