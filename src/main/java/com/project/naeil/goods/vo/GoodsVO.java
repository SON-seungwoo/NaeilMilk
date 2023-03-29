package com.project.naeil.goods.vo;

import java.sql.Date;

public class GoodsVO {
	private int goods_id; //상품번호
	private String goods_sort; // 대분류
	private String goods_title; //이름
	private String goods_publisher; //상품 제조사
	private int goods_price; // 가격
	private int goods_sales_price; //세일 가격
	private int goods_point; //포인트 
	private Date goods_published_date; //입고 일자
	private Date goods_delivery_date; //배송 날짜
	private String goods_status; //소분류
	private String goods_intro; //상품소개
	private String goods_fileName; //이미지파일이름
	private Date goods_credate; //상품 입고일
	
	private int goods_avg_star; // 리뷰 별점
	private int goods_review_count; //평균 리뷰
	
	private int image_id; //이미지 아이디
	private String image_fileName; //이미지 이름

	public GoodsVO() {
	}

	
	//Getter, Setter
	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_title() {
		return goods_title;
	}

	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_publisher() {
		return goods_publisher;
	}

	public void setGoods_publisher(String goods_publisher) {
		this.goods_publisher = goods_publisher;
	}

	public String getGoods_sort() {
		return goods_sort;
	}

	public void setGoods_sort(String goods_sort) {
		this.goods_sort = goods_sort;
	}

	public int getGoods_sales_price() {
		return goods_sales_price;
	}

	public void setGoods_sales_price(int goods_sales_price) {
		this.goods_sales_price = goods_sales_price;
	}

	public int getGoods_point() {
		return goods_point;
	}

	public void setGoods_point(int goods_point) {
		this.goods_point = goods_point;
	}

	public Date getGoods_published_date() {
		return goods_published_date;
	}

	public void setGoods_published_date(Date goods_published_date) {
		this.goods_published_date = goods_published_date;
	}

	public Date getGoods_delivery_date() {
		return goods_delivery_date;
	}

	public void setGoods_delivery_date(Date goods_delivery_date) {
		this.goods_delivery_date = goods_delivery_date;
	}

	public String getGoods_fileName() {
		return goods_fileName;
	}

	public void setGoods_fileName(String goods_fileName) {
		this.goods_fileName = goods_fileName;
	}

	public String getGoods_status() {
		return goods_status;
	}

	public void setGoods_status(String goods_status) {
		this.goods_status = goods_status;
	}

	public String getGoods_intro() {
		return goods_intro;
	}

	public void setGoods_intro(String goods_intro) {
		this.goods_intro = goods_intro;
	}

	public Date getGoods_credate() {
		return goods_credate;
	}

	public void setGoods_credate(Date goods_credate) {
		this.goods_credate = goods_credate;
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public String getImage_fileName() {
		return image_fileName;
	}

	public void setImage_fileName(String image_fileName) {
		this.image_fileName = image_fileName;
	}

	public int getGoods_avg_star() {
		return goods_avg_star;
	}

	public void setGoods_avg_star(int goods_avg_star) {
		this.goods_avg_star = goods_avg_star;
	}

	public int getGoods_review_count() {
		return goods_review_count;
	}

	public void setGoods_review_count(int goods_review_count) {
		this.goods_review_count = goods_review_count;
	}
	
}