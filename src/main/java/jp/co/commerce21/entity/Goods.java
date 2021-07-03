package jp.co.commerce21.entity;

import lombok.Data;

@Data
public class Goods {

	private Long goodsNo;
	private String goodsName;	
	private String goodsDisplay;	
	private String goodsAbility;	
	private String goodsMemory;	
	private String goodsStorage;	
	private String goodsBattery;
	private String attributes;
	private String stockCnt;
}

