//package com.invoice.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.invoice.domain.Item;
//import com.invoice.mapper.ItemMapper;
//import com.invoice.service.ItemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/sony")
//public class SonyController {
//
//    @Autowired
//    private ItemService itemService;
//
//    @Autowired
//    ItemMapper itemMapper;
//
//    @PostMapping
//    public void sony(List<Item> listForFront){
//
//        //1.从数据库获取已有的记录列表
//        List<Item> listForDb = itemMapper.selectList(new LambdaQueryWrapper<>());
//
//        //2.将list转换为 Map，以便更方便地进行查找和判断
//        Map<Integer, Item> mapForDb = listForDb.stream().collect(Collectors.toMap(Item::getId, Function.identity()));
//
//        //3.获取前端传来的新记录列表
////        ArrayList<Item> listForFront = new ArrayList<>();
////        for (Item Item : Items) {
////            Item item = itemService.getOne(new LambdaQueryWrapper<Item>().eq(Item::getName, Item.getName()));
////            listForFront.add(item);
////        }
//        //3.1. 提取出前端新记录的id
//        List<Integer> recordIdsForFront = new ArrayList<>();
//        for (Item itemForFront : listForFront) {
//            Integer itemId = itemForFront.getId();
//            recordIdsForFront.add(itemId);
//        }
//
//        //4.删除前端传递的不存在记录
//        List<Integer> recordIdsToRemove = new ArrayList<>(); //需要删除的记录
//        for (Integer recordId : mapForDb.keySet()) {
//            if(!recordIdsForFront.contains(recordId)){
//                recordIdsToRemove.add(recordId);
//            }
//        }
//
//        for (Integer id : recordIdsToRemove) {
//            mapForDb.remove(id);
//        }
//
//        //修改已存在的记录和新增记录
//        for (Item itemNew : listForFront) {
//            Integer newId = itemNew.getId();
//            //存在则修改
//            if (mapForDb.containsKey(newId)){
//                mapForDb.put(newId, itemNew);
//            }else { //否则就新增
//                mapForDb.put(newId, itemNew);
//            }
//        }
//
//
//    }
//
//}
