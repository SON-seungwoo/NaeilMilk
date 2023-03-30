package com.project.naeil.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public interface CartController {
	
	//장바구니 메인
	public ModelAndView myCartMain(HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	//장바구니 상품 추가
	public @ResponseBody String addGoodsInCart(@RequestParam("goods_id") int goods_id, @RequestParam("order_goods_qty") int order_goods_qty, HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	//수량 변경
	public @ResponseBody String modifyCartQty(@RequestParam("goods_id") int goods_id,@RequestParam("cart_goods_qty") int cart_goods_qty,
			                  				  HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	//항목 삭제
	public ModelAndView removeCartGoods(@RequestParam("cart_id") int cart_id,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	//선택삭제
	public ModelAndView checkRemove(@RequestParam("checkedCartIds") String checkedCartIds,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
