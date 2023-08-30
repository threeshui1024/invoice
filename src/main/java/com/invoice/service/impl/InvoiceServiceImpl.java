package com.invoice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.invoice.domain.Invoice;
import com.invoice.mapper.InvoiceMapper;
import com.invoice.service.InvoiceService;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【invoice】的数据库操作Service实现
* @createDate 2023-08-28 17:20:53
*/
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice>
    implements InvoiceService {

}




