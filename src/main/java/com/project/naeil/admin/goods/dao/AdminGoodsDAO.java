package com.project.naeil.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.project.naeil.goods.vo.GoodsVO;
import com.project.naeil.goods.vo.ImageFileVO;
import com.project.naeil.order.vo.OrderVO;

public interface AdminGoodsDAO {
	
	//새상품 추가
	public int insertNewGoods(Map newGoodsMap) throws DataAccessException;
	
	//새 상품 
	public List<GoodsVO>selectNewGoodsList(Map condMap) throws DataAccessException;
	
	//상품 상세조회
	public GoodsVO selectGoodsDetail(int goods_id) throws DataAccessException;
	
	//상품이미지 파일 목록
	public List selectGoodsImageFileList(int goods_id) throws DataAccessException;
	
	//이미지 파일 추가
	public void insertGoodsImageFile(List fileList)  throws DataAccessException;
	
	//상품정보 수정
	public void updateGoodsInfo(Map goodsMap) throws DataAccessException;
	
	//상품 이미지 수정
	public void updateGoodsImage(List<ImageFileVO> imageFileList) throws DataAccessException;
	
	//상품이미지 삭제
	public void deleteGoodsImage(int goods_id) throws DataAccessException;
//	public void deleteGoodsImage(List fileList) throws DataAccessException;
	
	//주문목록 조회
	public List<OrderVO> selectOrderGoodsList(Map condMap) throws DataAccessException;
	
	//주문상품 수정
	public void updateOrderGoods(Map orderMap) throws DataAccessException;
	
	//상품 삭제
	public void deleteGoods(int goods_id) throws DataAccessException;
	
}