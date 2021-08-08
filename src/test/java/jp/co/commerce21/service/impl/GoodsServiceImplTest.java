package jp.co.commerce21.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jp.co.commerce21.dao.GoodsDao;
import jp.co.commerce21.dto.GoodsDto;
import jp.co.commerce21.entity.Goods;
import jp.co.commerce21.form.SearchGoodsForm;
import jp.co.commerce21.service.GoodsService;

@SpringBootTest
@Transactional
class GoodsServiceImplTest {

	@Mock
	private GoodsDao goodsDao;
	
	@InjectMocks
	private GoodsService goodsService = new GoodsServiceImpl();
	
	private SearchGoodsForm mockForm;
	private List<Goods> mockGoodsList;
	
	@BeforeEach
	void setUp() {
		// Create Mock
		mockForm = new SearchGoodsForm();
		mockForm.setNo(1L);
		mockForm.setName("MacBook");
		mockGoodsList = new ArrayList<Goods>();	
		Goods mockGoods = new Goods();
		mockGoods.setNo(1L);
		mockGoods.setName("test");
		mockGoods.setDisplay("display");
		mockGoods.setAbility("ability");
		mockGoods.setMemory("memory");
		mockGoods.setStorage("storage");
		mockGoods.setBattery("battery");
		mockGoods.setAttributes("attributes");
		mockGoods.setStock("1");
		mockGoodsList.add(mockGoods);
		
		when(goodsDao.searchGoods(mockForm)).thenReturn(mockGoodsList);
	}
	
	@Test
	void searchGoodsListTest() {		
		// serviceを実行
		List<GoodsDto> goodsList = goodsService.searchGoodsList(mockForm);
		String actual = goodsList.get(0).getName();
		
		// 判定
		assertThat(actual).isEqualTo("test");	
	}
}
