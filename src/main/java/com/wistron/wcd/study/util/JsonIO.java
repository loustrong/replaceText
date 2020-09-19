package com.wistron.wcd.study.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wistron.wcd.study.model.ClearTable;
import com.wistron.wcd.study.model.SingleTable;
import com.wistron.wcd.study.model.TableName;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIO {
    synchronized public static boolean existInMultiPathConfigFile(long volumeId) {
        try {
            ObjectMapper objMap = new ObjectMapper();
            JsonNode root = objMap.readTree(new File("test.json"));
            JsonNode node = root.path("test");
            for (int i = 0; i < node.size(); i++) {
                Long volume = node.path(i).path("volume").asLong();
                if (volume.equals(volumeId)) {
                    System.out.println("exist connection in multipaths.conf.");
                    return true;
                }
            }
        } catch (Exception ex) {
            System.out.println("error to read config file.");
            return false;
        }
        System.out.println("nonexist@@.");
        return false;
    }
    synchronized public static List getTableNames(String dept, Boolean single) throws Exception {
        List list = new ArrayList<String>();
        ObjectMapper objMap = new ObjectMapper();
        String jsonName = "";
        if(single){
            jsonName = "config/singleTable.json";
            JsonNode root = objMap.readTree(new File(jsonName));
            SingleTable tableName;
            tableName = objMap.readValue(new File(jsonName), SingleTable.class);
            list.add(tableName.getTables());
            return list;
        }
        if(dept == "all"){
            jsonName = "config/tables.json";
        } else if(dept == "smt"){
            jsonName = "config/tables-smt.json";
        } else if(dept == "dip"){
            jsonName = "config/tables-dip.json";
        } else {
            throw new Exception("Department Error!");
        }

        JsonNode root = objMap.readTree(new File(jsonName));
        TableName tableNames;
        tableNames = objMap.readValue(new File(jsonName), TableName.class);
        for(String tableName: tableNames.getTables()){
            list.add(tableName);
        }
        return list;
    }
    synchronized public static ClearTable getClearTable() throws IOException {
        ClearTable clearTable;
        ObjectMapper objMap = new ObjectMapper();
        clearTable = objMap.readValue(new File("config/clearTable.json"), ClearTable.class);
        return clearTable;
    }

}
