package jp.co.commerce21.service;

import java.util.List;

import jp.co.commerce21.common.page.Pager;
import jp.co.commerce21.dto.GoodsDto;
import jp.co.commerce21.dto.MemberDownloadDto;
import jp.co.commerce21.dto.MemberDto;
import jp.co.commerce21.entity.Member;
import jp.co.commerce21.form.MemberForm;
import jp.co.commerce21.form.SearchForm;

public interface GoodsService {
	
	public List<GoodsDto> searchGoodsList(SearchForm searchForm);
	
//	public List<MemberDto> searchMemberList(SearchForm searchForm, Pager pager);
	
}
