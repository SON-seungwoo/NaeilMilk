package com.project.naeil.goods.service;

import java.util.List;
import java.util.Map;

import com.project.naeil.goods.vo.GoodsVO;

public interface GoodsService {
	
	//상품 조회
	public Map<String,List<GoodsVO>> listGoods() throws Exception;
	
	//상품 상세조회
	public Map goodsDetail(String _goods_id) throws Exception;
	
	//키워드 검색
	public List<String> keywordSearch(String keyword) throws Exception;
	
	//검색 단어
	public List<GoodsVO> searchGoods(String searchWord) throws Exception;
	
	//평균 별점
	public Map<String,List<GoodsVO>> selectGoodsAvgStar() throws Exception;
	
}