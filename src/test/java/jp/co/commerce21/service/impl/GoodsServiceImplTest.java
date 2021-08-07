package jp.co.commerce21.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jp.co.commerce21.dto.GoodsDto;
import jp.co.commerce21.form.SearchGoodsForm;
import jp.co.commerce21.service.GoodsService;

@SpringBootTest
@Transactional
class GoodsServiceImplTest {

	@Autowired
	GoodsService goodsService;
	
	@Test
	void searchGoodsListTest() {		
		SearchGoodsForm form = new SearchGoodsForm();
		form.setNo(1L);
		form.setName("MacBook");
		
		List<GoodsDto> goodsList = goodsService.searchGoodsList(form);
		String actual = goodsList.get(0).getName();
		
		assertThat(actual).isEqualTo("MacBook Pro 13インチモデル");	
	}
}
