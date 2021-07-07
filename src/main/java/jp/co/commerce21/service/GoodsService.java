package jp.co.commerce21.service;

import java.util.List;

import jp.co.commerce21.dto.GoodsDto;
import jp.co.commerce21.form.SearchGoodsForm;

public interface GoodsService {
	
	public List<GoodsDto> searchGoodsList(SearchGoodsForm sgForm);
	
//	public List<MemberDto> searchMemberList(SearchForm searchForm, Pager pager);
	
}
