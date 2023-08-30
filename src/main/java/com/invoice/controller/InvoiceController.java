package com.invoice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.invoice.domain.Invoice;
import com.invoice.domain.Item;
import com.invoice.service.InvoiceService;
import com.invoice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ItemService itemService;

    @PostMapping("/execute")
    public void execute(@RequestBody Invoice invoice){
        LambdaQueryWrapper<Invoice> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Invoice::getName, invoice.getName());
        //查询数据库是否存在发票记录
        Invoice invoiceDb = invoiceService.getOne(queryWrapper);

        //如果不存在发票记录，就新增(如果数据库发票记录不存在，肯定也不会有明细)
        if (invoiceDb == null) {
            invoiceService.save(invoice);
            Integer id = invoice.getId();//获取新增数据的id(mp在新增数据之后可以直接获取id)
            List<Item> items = invoice.getItem();
            //遍历明细记录并设置应该属于哪条发票记录，将id设置进去，最后新增
            for (Item item : items) {
                item.setInvoiceId(id);
                itemService.save(item);
            }
            return;
        }

        //如果存在发票记录，就修改
        invoiceService.update(invoice, queryWrapper);
        //获取这条发票记录的id
        Integer invoiceId = invoiceService.getOne(queryWrapper).getId();

        //查询传入的数据中是否存在明细
        List<Item> itemListForFront = invoice.getItem();
        //如果传入的数据有明细
        if (itemListForFront != null) {
            //1.从数据库获取已有的明细列表
            //(1)根据 发票记录的id 查询该发票记录包含的明细
            List<Item> itemListForDb = itemService.list(new LambdaQueryWrapper<Item>().eq(Item::getInvoiceId, invoiceId));

            //2.将list转换为 Map，以便更方便地进行查找和判断(因为此时 list 中存放的是item，后续比较时需要使用item的name，
            //转换后更方便，当然不转换其实也可以，只是后续需要多次遍历 list，比较麻烦)
            Map<String, Item> itemMapForDb = itemListForDb.stream().collect(Collectors.toMap(Item::getName, Function.identity()));

            //3.提取出前端新记录的name
            List<String> nameListForFront = new ArrayList<>();
            for (Item itemForFront : itemListForFront) {
                nameListForFront.add(itemForFront.getName());
            }

            //4.删除前端传递的不存在记录
            for (String name : itemMapForDb.keySet()) {
                if (!nameListForFront.contains(name)){
                    itemService.remove(new LambdaQueryWrapper<Item>().eq(Item::getName, name));
                }
            }

            //5.修改已存在的记录和新增记录
            for (Item itemForFront : itemListForFront) {
                String name = itemForFront.getName();
                //存在就修改
                if (itemMapForDb.containsKey(name)){
                    itemService.update(itemForFront, new LambdaQueryWrapper<Item>().eq(Item::getName, name));
                }else { //不存在就新增
                    itemForFront.setInvoiceId(invoiceId);
                    itemService.save(itemForFront);
                }
            }
        }
    }
}
