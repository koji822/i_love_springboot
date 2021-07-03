package jp.co.commerce21.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.commerce21.entity.Goods;
import jp.co.commerce21.form.SearchForm;

@Mapper
public interface GoodsDao {
	
	List<Goods> searchGoods(SearchForm searchForm);
}
