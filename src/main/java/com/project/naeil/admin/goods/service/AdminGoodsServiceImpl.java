package com.project.naeil.admin.goods.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.naeil.admin.goods.dao.AdminGoodsDAO;
import com.project.naeil.goods.vo.GoodsVO;
import com.project.naeil.goods.vo.ImageFileVO;
import com.project.naeil.order.vo.OrderVO;

@Service("adminGoodsService")
@Transactional(propagation=Propagation.REQUIRED)
public class AdminGoodsServiceImpl implements AdminGoodsService {
	
	//의존성 추가
	@Autowired
	private AdminGoodsDAO adminGoodsDAO;
	
	
	//상품 추가
	@Override
	public int addNewGoods(Map newGoodsMap) throws Exception{
					   // 상품 정보를 테이블에 추가합니다.
		int goods_id = adminGoodsDAO.insertNewGoods(newGoodsMap);
		ArrayList<ImageFileVO> imageFileList = (ArrayList)newGoodsMap.get("imageFileList");
		
		// 각 이미지 정보에 상품 번호를 설정합니다.
		for(ImageFileVO imageFileVO : imageFileList) {
			imageFileVO.setGoods_id(goods_id);
		}
		
		// 이미지 정보를 이미지 테이블에 추가합니다.
		adminGoodsDAO.insertGoodsImageFile(imageFileList);
		
		return goods_id;
	}
	
	
	//새상품 목록
	@Override
	public List<GoodsVO> listNewGoods(Map condMap) throws Exception{
		return adminGoodsDAO.selectNewGoodsList(condMap);
	}
	
	//상품 상세
	@Override
	public Map goodsDetail(int goods_id) throws Exception {
		Map goodsMap = new HashMap();
		GoodsVO goodsVO=adminGoodsDAO.selectGoodsDetail(goods_id);
		List imageFileList =adminGoodsDAO.selectGoodsImageFileList(goods_id);
		goodsMap.put("goods", goodsVO);
		goodsMap.put("imageFileList", imageFileList);
		return goodsMap;
	}
	
	//상품 이지미
	@Override
	public List goodsImageFile(int goods_id) throws Exception{
		List imageList =adminGoodsDAO.selectGoodsImageFileList(goods_id);
		return imageList;
	}
	
	
	//상품 정보 수정
	@Override
	public void modifyGoodsInfo(Map goodsMap) throws Exception{
		adminGoodsDAO.updateGoodsInfo(goodsMap);
		
	}	
	
	//상품 이미지 수정
	@Override
	public void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception{
		adminGoodsDAO.updateGoodsImage(imageFileList); 
	}
	
	
	//주문 목록
	@Override
	public List<OrderVO> listOrderGoods(Map condMap) throws Exception{
		return adminGoodsDAO.selectOrderGoodsList(condMap);
	}
	
	//주문 수정
	@Override
	public void modifyOrderGoods(Map orderMap) throws Exception{
		adminGoodsDAO.updateOrderGoods(orderMap);
	}
	
	//상품 이미지 삭제
	@Override
	public void removeGoodsImage(int image_id) throws Exception{
		adminGoodsDAO.deleteGoodsImage(image_id);
	}
	
	//상품 이미지 추가
	@Override
	public void addNewGoodsImage(List imageFileList) throws Exception{
		adminGoodsDAO.insertGoodsImageFile(imageFileList);
	}
	
	//상품삭제
	@Override
	public void removeGoods(int goods_id) throws Exception{
		adminGoodsDAO.deleteGoodsImage(goods_id);
		adminGoodsDAO.deleteGoods(goods_id);
		//상품과 이미지 동시에 삭제
	}
}