package com.invoice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.invoice.domain.Item;
import com.invoice.service.ItemService;
import com.invoice.mapper.ItemMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【item】的数据库操作Service实现
* @createDate 2023-08-30 18:36:26
*/
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item>
    implements ItemService{

}




