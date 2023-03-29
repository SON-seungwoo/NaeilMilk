package com.project.naeil.goods.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.project.naeil.goods.vo.GoodsVO;
import com.project.naeil.goods.vo.ImageFileVO;

public interface GoodsDAO {
	//상품 조회
	public List<GoodsVO> selectGoodsList(String goodsStatus ) throws DataAccessException;
	
	//키워드 검색
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;
	
	//상품 상세 조회
	public GoodsVO selectGoodsDetail(String goods_id) throws DataAccessException;
	
	//상품 이미지 조회
	public List<ImageFileVO> selectGoodsDetailImage(String goods_id) throws DataAccessException;
	
	//검색 상품 단어
	public List<GoodsVO> selectGoodsBySearchWord(String searchWord) throws DataAccessException;
	
	//평균 별점
	public List<GoodsVO> selectGoodsAvgStar(String goodsStatus) throws DataAccessException;
}