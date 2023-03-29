package com.project.naeil.admin.goods.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.project.naeil.goods.vo.GoodsVO;
import com.project.naeil.goods.vo.ImageFileVO;
import com.project.naeil.order.vo.OrderVO;

// @Repository 어노테이션을 사용하면 이를 사용하는 클래스를 스프링의 Bean(객체)으로 등록하며,
// 해당 Bean을 다른 클래스에서 참조할때 사용됩니다
@Repository("adminGoodsDAO")
public class AdminGoodsDAOImpl  implements AdminGoodsDAO{
	
	//의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	//새상품 추가
	@Override
	public int insertNewGoods(Map newGoodsMap) throws DataAccessException {
		// 상품 정보를 추가합니다.
		sqlSession.insert("mapper.admin.goods.insertNewGoods",newGoodsMap);
		
		return Integer.parseInt((String)newGoodsMap.get("goods_id"));
	}
	
	//상품 이미지 파일 추가
	@Override
	public void insertGoodsImageFile(List fileList)  throws DataAccessException {
		for(int i=0; i<fileList.size();i++){
			ImageFileVO imageFileVO=(ImageFileVO)fileList.get(i);
			
			// 상품 이미지 정보를 추가합니다.
			sqlSession.insert("mapper.admin.goods.insertGoodsImageFile",imageFileVO);
		}
	}
		
	//새상품 목록
	@Override
	public List<GoodsVO>selectNewGoodsList(Map condMap) throws DataAccessException {
		ArrayList<GoodsVO>  goodsList=(ArrayList)sqlSession.selectList("mapper.admin.goods.selectNewGoodsList",condMap);
		return goodsList;
	}
	
	//상품 상세조회
	@Override
	public GoodsVO selectGoodsDetail(int goods_id) throws DataAccessException{
		GoodsVO goodsBean = new GoodsVO();
		goodsBean=(GoodsVO)sqlSession.selectOne("mapper.admin.goods.selectGoodsDetail",goods_id);
		return goodsBean;
	}
	
	//상품 이미지파일 목록
	@Override
	public List selectGoodsImageFileList(int goods_id) throws DataAccessException {
		List imageList=new ArrayList();
		imageList=(List)sqlSession.selectList("mapper.admin.goods.selectGoodsImageFileList",goods_id);
		return imageList;
	}
	
	//상품 정보 수정
	@Override
	public void updateGoodsInfo(Map goodsMap) throws DataAccessException{
		sqlSession.update("mapper.admin.goods.updateGoodsInfo",goodsMap);
	}
	
	//상품 이미지 수정
	@Override
	public void deleteGoodsImage(int goods_id) throws DataAccessException{
		sqlSession.delete("mapper.admin.goods.deleteGoodsImage",goods_id);
	}
	
	/*
	 * @Override public void deleteGoodsImage(List fileList) throws
	 * DataAccessException{ int image_id; for(int i=0; i<fileList.size();i++){
	 * ImageFileVO bean=(ImageFileVO) fileList.get(i); image_id=bean.getImage_id();
	 * sqlSession.delete("mapper.admin.goods.deleteGoodsImage",image_id); } }
	 */

	//주문 상품목록
	@Override
	public List<OrderVO> selectOrderGoodsList(Map condMap) throws DataAccessException{
		List<OrderVO>  orderGoodsList=(ArrayList)sqlSession.selectList("mapper.admin.selectOrderGoodsList",condMap);
		return orderGoodsList;
	}	
	
	//주문 상품조회
	@Override
	public void updateOrderGoods(Map orderMap) throws DataAccessException{
		sqlSession.update("mapper.admin.goods.updateOrderGoods",orderMap);
		
	}
	
	//상품이미지 수정
	@Override
	public void updateGoodsImage(List<ImageFileVO> imageFileList) throws DataAccessException {
		
		//for문으로 모든 이미지를 선택해 수정함
		for(int i=0; i<imageFileList.size();i++){
			ImageFileVO imageFileVO = imageFileList.get(i);
			sqlSession.update("mapper.admin.goods.updateGoodsImage",imageFileVO);	
		}
		
	}

	//성퓸 삭제
	@Override
	public void deleteGoods(int goods_id) throws DataAccessException{
		sqlSession.delete("mapper.admin.goods.deleteGoods",goods_id);
	}

}