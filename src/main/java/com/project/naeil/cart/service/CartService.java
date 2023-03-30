package com.project.naeil.cart.service;

import java.util.List;
import java.util.Map;

import com.project.naeil.cart.vo.CartVO;

public interface CartService {
	
	//장바구니 목록
	public Map<String ,List> myCartList(CartVO cartVO) throws Exception;
	
	//테이블에 추가하기 전에 동일한 상품 번호의 개수를 조회합니다.
	public boolean findCartGoods(CartVO cartVO) throws Exception;
	
	//상품을 장바구니 추가
	public void addGoodsInCart(CartVO cartVO) throws Exception;
	
	//상품 수량 변경
	public boolean modifyCartQty(CartVO cartVO) throws Exception;
	
	//항목 삭제
	public void removeCartGoods(int cart_id) throws Exception;
}