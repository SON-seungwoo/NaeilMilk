package com.project.naeil.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.project.naeil.goods.vo.GoodsVO;
import com.project.naeil.goods.vo.ImageFileVO;

@Repository("goodsDAO")
public class GoodsDAOImpl implements GoodsDAO{
	
	//의존성 주입
	@Autowired
	private SqlSession sqlSession;

	//상품 조회
	@Override
	public List<GoodsVO> selectGoodsList(String goodsStatus ) throws DataAccessException {
		List<GoodsVO> goodsList=(ArrayList)sqlSession.selectList("mapper.goods.selectGoodsList",goodsStatus);
		String goods_review_count;
		
	   return goodsList;	
	}
	
	//키워드 검색
	@Override
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException {
	   List<String> list=(ArrayList)sqlSession.selectList("mapper.goods.selectKeywordSearch",keyword);
	   return list;
	}
	
	//검색 단어
	@Override
	public ArrayList selectGoodsBySearchWord(String searchWord) throws DataAccessException{
		ArrayList list=(ArrayList)sqlSession.selectList("mapper.goods.selectGoodsBySearchWord",searchWord);
		 return list;
	}
	
	//상품 상세조회
	@Override
	public GoodsVO selectGoodsDetail(String goods_id) throws DataAccessException{
													  // 메서드 호출 시 전달된 조건으로 도서 정보를 조회합니다.
		GoodsVO goodsVO=(GoodsVO)sqlSession.selectOne("mapper.goods.selectGoodsDetail",goods_id);
		return goodsVO;
	}
	
	//상품 이미지 상세조회
	@Override
	public List<ImageFileVO> selectGoodsDetailImage(String goods_id) throws DataAccessException{
		List<ImageFileVO> imageList=(ArrayList)sqlSession.selectList("mapper.goods.selectGoodsDetailImage",goods_id);
		return imageList;
	}
	
	// 평균 별의 갯수를 가져오는 메서드
	@Override
	public List<GoodsVO> selectGoodsAvgStar(String goodsStatus) throws DataAccessException {
		List<GoodsVO> AvgStar = (ArrayList)sqlSession.selectList("mapper.goods.selectAvgStar",goodsStatus);
		return AvgStar;
	}
	
}