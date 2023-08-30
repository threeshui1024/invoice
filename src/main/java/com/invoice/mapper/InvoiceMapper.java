package com.invoice.mapper;

import com.invoice.domain.Invoice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author DELL
* @description 针对表【invoice】的数据库操作Mapper
* @createDate 2023-08-28 17:20:53
* @Entity generator.domain.Invoice
*/
@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {

}




