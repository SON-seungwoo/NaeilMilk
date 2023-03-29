package com.project.naeil.admin.goods.service;

import java.util.List;
import java.util.Map;

import com.project.naeil.goods.vo.GoodsVO;
import com.project.naeil.goods.vo.ImageFileVO;
import com.project.naeil.order.vo.OrderVO;

public interface AdminGoodsService {
	
	//상품 추가
	public int  addNewGoods(Map newGoodsMap) throws Exception;
	
	//새상품 목록
	public List<GoodsVO> listNewGoods(Map condMap) throws Exception;
	
	//상품 상세정보
	public Map goodsDetail(int goods_id) throws Exception;
	
	//상품 이미지 추가
	public void addNewGoodsImage(List imageFileList) throws Exception;
	
	//상품 이미지 목록
	public List goodsImageFile(int goods_id) throws Exception;
	
	//상품 정보수정
	public void modifyGoodsInfo(Map goodsMap) throws Exception;
	
	//상품이미지 수정
	public void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception;
	
	//주문상품 목록
	public List<OrderVO> listOrderGoods(Map condMap) throws Exception;
	
	//주문 수정
	public void modifyOrderGoods(Map orderMap) throws Exception;
	
	//이미지 삭제
	public void removeGoodsImage(int goods_id) throws Exception;
	
	//상품 삭제
	public void removeGoods(int goods_id) throws Exception;
}