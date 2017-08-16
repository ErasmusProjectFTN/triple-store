package com.ErasmusProject.util;

public class ResponseSignInFlag {

	public static enum Flag {STUDENT, ADMIN};
	
	
	private Flag flag;

	public ResponseSignInFlag(Flag flag) {
		super();
		
		this.flag = flag;
	}
	
	
	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	
	
}
