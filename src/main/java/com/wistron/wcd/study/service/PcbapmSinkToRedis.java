package com.wistron.wcd.study.service;

import com.wistron.wcd.study.model.pcbapm.PcbaMachineParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PcbapmSinkToRedis {
   public void process( List<PcbaMachineParameter> pmpList, RedisService redisService){
//       RedisService redisService = new RedisService();
       for(PcbaMachineParameter pcbaMachineParameter: pmpList) {
           if(pcbaMachineParameter.getMachinename().equals("FLUX")){
               System.out.println("~~~~FLUX~~~");
               String key = pcbaMachineParameter.getSite().toUpperCase() + "."
                          + pcbaMachineParameter.getPlant().toUpperCase() + "."
                          + pcbaMachineParameter.getLine().toUpperCase() + "."
                          + pcbaMachineParameter.getMachinename().toUpperCase() + "."
                          + pcbaMachineParameter.getProgrammename().toUpperCase() + "."
                          + pcbaMachineParameter.getParametername().toUpperCase();
               redisService.hset(key, "parametervalue",  Float.toString(pcbaMachineParameter.getParametervalue()));
               redisService.hset(key, "rangeValue", "+/-" + pcbaMachineParameter.getParameterrange().toString());
               redisService.hset(key, "rangetopupper", Float.toString(pcbaMachineParameter.getRangetopupper()));
               redisService.hset(key, "rangetoplower",  Float.toString(pcbaMachineParameter.getRangetoplower()));
               redisService.hset(key, "rangebottomupper",  Float.toString(pcbaMachineParameter.getRangebottomupper()));
               redisService.hset(key, "rangebottomlower",  Float.toString(pcbaMachineParameter.getRangebottomlower()));
               redisService.hset(key, "modelNo", pcbaMachineParameter.getModelno());
           } else if (pcbaMachineParameter.getMachinename().equals("WAVE SOLDER")){
               System.out.println("~~~~WAVE SOLDER~~~");
               String key =  pcbaMachineParameter.getSite().toUpperCase() + "."
                       + pcbaMachineParameter.getPlant().toUpperCase() + "."
                       + pcbaMachineParameter.getLine().toUpperCase() + "."
                       + pcbaMachineParameter.getMachinename().toUpperCase() + "."
                       + pcbaMachineParameter.getProgrammename().toUpperCase() + "."
                       + pcbaMachineParameter.getParametername().toUpperCase();
               redisService.hset(key, "parametervalue",  Float.toString(pcbaMachineParameter.getParametervalue()));
               redisService.hset(key, "rangeValue", pcbaMachineParameter.getParameterrange().toString());
               redisService.hset(key, "rangetopupper", Float.toString(pcbaMachineParameter.getRangetopupper()));
               redisService.hset(key, "rangetoplower",  Float.toString(pcbaMachineParameter.getRangetoplower()));
               redisService.hset(key, "rangebottomupper",  Float.toString(pcbaMachineParameter.getRangebottomupper()));
               redisService.hset(key, "rangebottomlower",  Float.toString(pcbaMachineParameter.getRangebottomlower()));
               redisService.hset(key, "modelNo", pcbaMachineParameter.getModelno());
           } else if(pcbaMachineParameter.getMachinename().equals("PRINTER")){
               System.out.println("~~~~PRINTER~~~");
               String key =  pcbaMachineParameter.getSite().toUpperCase() + "."
                       + pcbaMachineParameter.getPlant().toUpperCase() + "."
                       + pcbaMachineParameter.getLine().toUpperCase() + "."
                       + pcbaMachineParameter.getSide().toUpperCase() + "."
                       + pcbaMachineParameter.getMachinename().toUpperCase() + "."
                       + pcbaMachineParameter.getProgrammename().toUpperCase() + "."
                       + pcbaMachineParameter.getParametername().toUpperCase();
               redisService.hset(key, "parametervalue",  Float.toString(pcbaMachineParameter.getParametervalue()));
               redisService.hset(key, "rangeValue", "+/-" + pcbaMachineParameter.getParameterrange().toString());
               redisService.hset(key, "rangetopupper", Float.toString(pcbaMachineParameter.getRangetopupper()));
               redisService.hset(key, "rangetoplower",  Float.toString(pcbaMachineParameter.getRangetoplower()));
               redisService.hset(key, "rangebottomupper",  Float.toString(pcbaMachineParameter.getRangebottomupper()));
               redisService.hset(key, "rangebottomlower",  Float.toString(pcbaMachineParameter.getRangebottomlower()));
               redisService.hset(key, "modelNo", pcbaMachineParameter.getModelno());
               redisService.hset(key, "pcbNo", pcbaMachineParameter.getPcbno());
               redisService.hset(key, "pcbPn", pcbaMachineParameter.getPcbno());
           } else if(pcbaMachineParameter.getMachinename().equals("REFLOW")){
               System.out.println("~~~~REFLOW~~~");
               String key = pcbaMachineParameter.getSite().toUpperCase() + "."
                       + pcbaMachineParameter.getPlant().toUpperCase() + "."
                       + pcbaMachineParameter.getLine().toUpperCase() + "."
                       + pcbaMachineParameter.getSide().toUpperCase() + "."
                       + pcbaMachineParameter.getMachinename().toUpperCase() + "."
                       + pcbaMachineParameter.getProgrammename().toUpperCase() + "."
                       + pcbaMachineParameter.getParametername().toUpperCase();
               redisService.hset(key, "parametervalue",  Float.toString(pcbaMachineParameter.getParametervalue()));
               redisService.hset(key, "rangeValue", "+/-" + pcbaMachineParameter.getParameterrange().toString());
               redisService.hset(key, "rangetopupper", Float.toString(pcbaMachineParameter.getRangetopupper()));
               redisService.hset(key, "rangetoplower",  Float.toString(pcbaMachineParameter.getRangetoplower()));
               redisService.hset(key, "rangebottomupper",  Float.toString(pcbaMachineParameter.getRangebottomupper()));
               redisService.hset(key, "rangebottomlower",  Float.toString(pcbaMachineParameter.getRangebottomlower()));
               redisService.hset(key, "modelNo", pcbaMachineParameter.getModelno());
               redisService.hset(key, "pcbNo", pcbaMachineParameter.getPcbno());
               redisService.hset(key, "pcbPn", pcbaMachineParameter.getPcbno());
           }
       }
       System.exit(0);
   }

}
