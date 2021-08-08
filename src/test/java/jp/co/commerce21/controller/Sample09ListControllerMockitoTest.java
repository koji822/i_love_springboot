package jp.co.commerce21.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;

import jp.co.commerce21.dto.GoodsDto;
import jp.co.commerce21.form.SearchGoodsForm;
import jp.co.commerce21.service.GoodsService;

@SpringBootTest
class Sample09ListControllerMockitoTest {

	@Mock
	private GoodsService goodsService;
	
	@InjectMocks
	private Sample09ListController sample09ListController;
	
	private SearchGoodsForm mockForm;
	private List<GoodsDto> mockGoodsList;
	
	@BeforeEach
	void setUp() {
		mockForm = new SearchGoodsForm();
		mockForm.setNo(1L);
		mockForm.setName("MacBook");
		
		mockGoodsList = new ArrayList<GoodsDto>();	
		GoodsDto mockGoods = new GoodsDto();
		mockGoods.setGoodsNo(1L);
		mockGoods.setName("test");
		mockGoods.setDisplay("display");
		mockGoods.setAbility("ability");
		mockGoods.setMemory("memory");
		mockGoods.setStorage("storage");
		mockGoods.setBattery("battery");
		mockGoods.setAttributes("attributes");
		mockGoods.setStock("1");
		mockGoodsList.add(mockGoods);
		
		when(goodsService.searchGoodsList(mockForm)).thenReturn(mockGoodsList);
	}
	
	@Test
	void sample09ListControllerMockitoTest () {
		String response = sample09ListController.list(new ModelMap(), mockForm);
        assertThat(response).isEqualTo("sample09/list");
	}
}
