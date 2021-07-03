package jp.co.commerce21.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.co.commerce21.dao.GoodsDao;
import jp.co.commerce21.dto.GoodsDto;
import jp.co.commerce21.entity.Goods;
import jp.co.commerce21.form.SearchForm;
import jp.co.commerce21.service.GoodsService;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<GoodsDto> searchGoodsList(SearchForm searchForm) {
		
		// 検索条件を元に一覧情報の取得
		List<Goods> goodsList = goodsDao.searchGoods(searchForm);

		List<GoodsDto> goodsDto = new ArrayList<GoodsDto>();
		
		// EntityをDtoに変換
		for (Goods list : goodsList) {
			GoodsDto goods = new GoodsDto();			
			goods.setGoodsNo(list.getGoodsNo());
			goods.setName(list.getGoodsName());
			goods.setDisplay(list.getGoodsDisplay());
			goods.setAbility(list.getGoodsAbility());
			goods.setMemory(list.getGoodsMemory());
			goods.setStorage(list.getGoodsStorage());
			goods.setBattery(list.getGoodsBattery());
			goods.setAttributes(list.getAttributes());
			goods.setStock(list.getStockCnt());
			goodsDto.add(goods);
		}
		
		return goodsDto;
	}
}
