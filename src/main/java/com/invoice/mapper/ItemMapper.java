package com.invoice.mapper;

import com.invoice.domain.Item;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author DELL
* @description 针对表【item】的数据库操作Mapper
* @createDate 2023-08-30 18:36:26
* @Entity com.invoice.domain.Item
*/
@Mapper
public interface ItemMapper extends BaseMapper<Item> {

}




