//package com.invoice.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.invoice.domain.Invoice;
//import com.invoice.domain.Item;
//import com.invoice.mapper.ItemMapper;
//import com.invoice.service.InvoiceService;
//import com.invoice.service.ItemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/test")
//public class TestController {
//    @Autowired
//    private InvoiceService invoiceService;
//
//    @Autowired
//    private ItemService itemService;
//
//    @Autowired
//    private ItemMapper itemMapper;
//
//    @PostMapping("/item")
//    public Boolean test(@RequestBody Invoice invoice){
//        //查询传入的数据中是否存在明细
//        List<Item> items = invoice.getItem();
//
//        if (items != null) {
//
//            //转map
////            Map<String, Item> map = items.stream().collect(Collectors.toMap(Item::getName, Function.identity()));
////            System.out.println(map);
////            ArrayList<Item> itemDbs = new ArrayList<>();
//            Map<String, Item> map = new HashMap<>();
//            for (Item item : items) {
//                //查询数据库中的所有明细
//                LambdaQueryWrapper<Item> itemLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                itemLambdaQueryWrapper.eq(Item::getName, item.getName());
////                List<Item> itemDbs = itemMapper.selectList(itemLambdaQueryWrapper);
//                Item itemDb = itemService.getOne(itemLambdaQueryWrapper);
////                itemDbs.add(one);
////                Map<String, Item> map = itemDbs.stream().collect(Collectors.toMap(Item::getName, Function.identity()));
//
//                map.put(itemDb.getName(), itemDb);
//
//                if (map.containsKey(item.getName())) {
//                    //如果存在则加入map,也就是用新值替换map中原来的值
//                    map.put(item.getName(), item);
//                }
//
//
//            }
//        }
//
//        return null;
//    }
//}
