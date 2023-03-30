package com.project.naeil.cart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.project.naeil.cart.vo.CartVO;
import com.project.naeil.goods.vo.GoodsVO;

@Repository("cartDAO")
public class CartDAOImpl  implements  CartDAO{
	
	//의존성 추가
	@Autowired
	private SqlSession sqlSession;
	
	//장바구니 목록
	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException {
		List<CartVO> cartList =(List)sqlSession.selectList("mapper.cart.selectCartList",cartVO);
		return cartList;
	}
	
	//상품 목록
	public List<GoodsVO> selectGoodsList(List<CartVO> cartList, String member_id) throws DataAccessException {
		
		List<GoodsVO> myGoodsList;
		Map<String, Object> myGoodsMap = new HashMap();
		
		myGoodsMap.put("cartList", cartList);
		myGoodsMap.put("member_id", member_id);
		
		myGoodsList = sqlSession.selectList("mapper.cart.selectGoodsList", myGoodsMap);
		
		return myGoodsList;
	}
	
	// 이미 장바구니에 추가된 상품인지 조회합니다.
	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException {
		String  result = sqlSession.selectOne("mapper.cart.selectCountInCart",cartVO);
		return Boolean.parseBoolean(result);
	}

	// 장바구니에 추가합니다.
	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException{
		int cart_id=selectMaxCartId();
		cartVO.setCart_id(cart_id);
		sqlSession.insert("mapper.cart.insertGoodsInCart",cartVO);
	}
	
	//상품 수량을 변경합니다
	public void updateCartGoodsQty(CartVO cartVO) throws DataAccessException{
		sqlSession.insert("mapper.cart.updateCartGoodsQty",cartVO);
	}
	
	//항목을 삭제합니다
	public void deleteCartGoods(int cart_id) throws DataAccessException{
		sqlSession.delete("mapper.cart.deleteCartGoods",cart_id);
	}
	
	//중복방지
	private int selectMaxCartId() throws DataAccessException{
		int cart_id = sqlSession.selectOne("mapper.cart.selectMaxCartId");
		return cart_id;
	}

}
