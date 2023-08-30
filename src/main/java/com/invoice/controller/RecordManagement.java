//package com.invoice.controller;
//
////以下是基于您的要求的完整方案，包括从数据库中获取记录、进行更新操作和删除前端传递的不存在记录：
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class RecordManagement {
//
//    // 从记录列表中提取所有记录的id
//    private static List<Integer> getRecordIdsFromList(List<Map<String, Object>> records) {
//        List<Integer> recordIds = new ArrayList<>();
//        for (Map<String, Object> record : records) {
//            int recordId = (int) record.get("id");
//            recordIds.add(recordId);
//        }
//        return recordIds;
//    }
//
//    public static void main(String[] args) {
//        // 从数据库获取已有的记录列表
//        List<Map<String, Object>> recordsFromDB = getRecordsFromDatabase();
//
//        // 将列表转换为 Map，以便更方便地进行查找和判断
//        Map<Integer, Map<String, Object>> recordMap = convertListToMap(recordsFromDB);
//
//        // 前端传来的新记录列表
//        List<Map<String, Object>> newRecords = getNewRecordsFromFrontend();
//
//        // 删除前端传递的不存在记录
//        List<Integer> recordIdsFromFrontend = getRecordIdsFromList(newRecords);
//        List<Integer> recordIdsToRemove = new ArrayList<>();
//        for (int recordId : recordMap.keySet()) {
//            if (!recordIdsFromFrontend.contains(recordId)) {
//                recordIdsToRemove.add(recordId);
//            }
//        }
//        for (int recordId : recordIdsToRemove) {
//            recordMap.remove(recordId);
//        }
//
//        // 修改已存在的记录和新增记录
//        for (Map<String, Object> newRecord : newRecords) {
//            int recordId = (int) newRecord.get("id");
//            if (recordMap.containsKey(recordId)) {
//                // 已存在的记录，进行修改
//                recordMap.put(recordId, newRecord);
//            } else {
//                // 新增记录
//                recordMap.put(recordId, newRecord);
//            }
//        }
//
//    }
//}