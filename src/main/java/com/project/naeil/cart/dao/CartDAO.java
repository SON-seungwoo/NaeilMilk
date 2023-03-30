package com.project.naeil.cart.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.project.naeil.cart.vo.CartVO;
import com.project.naeil.goods.vo.GoodsVO;

public interface CartDAO {
	
	//장바구니 목록
	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException;
	
	//상품 목록
	public List<GoodsVO> selectGoodsList(List<CartVO> cartList, String member_id) throws DataAccessException;
	
	//이미 장바구니에 추가된 상품인지 조회합니다.
	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException;
	
	//항목 추가
	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException;
	
	//수량 변경
	public void updateCartGoodsQty(CartVO cartVO) throws DataAccessException;
	
	//항목 삭제
	public void deleteCartGoods(int cart_id) throws DataAccessException;
	
}