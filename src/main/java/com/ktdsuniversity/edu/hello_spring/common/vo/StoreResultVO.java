package com.ktdsuniversity.edu.hello_spring.common.vo;

public class StoreResultVO {
	
	// 파일명이 한번 결정되면 바뀌어선 안된다.
	private String originFileName;
	private String obfuscatedFileName;
	
	public StoreResultVO(String originFileName, String obfuscatedFileName) {
		this.originFileName = originFileName;
		this.obfuscatedFileName = obfuscatedFileName;
	}
	
	public String getOriginFileName() {
		return originFileName;
	}
	
	public String getObfuscatedFileName() {
		return obfuscatedFileName;
	}
	
	
	
}
