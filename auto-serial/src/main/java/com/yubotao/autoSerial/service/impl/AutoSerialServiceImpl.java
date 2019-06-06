package com.yubotao.autoSerial.service.impl;

import com.yubotao.autoSerial.jpa.AutoSerialJpa;
import com.yubotao.autoSerial.model.AutoSerial;
import com.yubotao.autoSerial.model.StrategySerial;
import com.yubotao.autoSerial.service.AutoSerialService;
import com.yubotao.autoSerial.service.StrategyService;
import com.yubotao.autoSerial.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Auther: yubotao
 * @Description: 局限性太强了，尽管可能解决超发导致的回溯问题，但是一直递增的方式也可能造成字符串长度扩展
 *                测试或者自己写个玩具还能勉强用用。但是生产还是尽量不要用，非常容易出危险。不如研究研究雪花算法。
 * @Date: Created in 12:02 2019/5/29
 * @Modified By:
 */
@Service
public class AutoSerialServiceImpl implements AutoSerialService{
    @Autowired
    AutoSerialJpa autoSerialJpa;

    @Autowired
    StrategyService strategyService;

    String prefix;

    protected static Map<String, Queue> map = new HashMap<>();

    public String nextSerial(String strategy) throws Exception {
        Queue<String> serials = map.get(strategy);
        if (serials == null){
            synchronized (this){
                if (map.get(strategy) == null){
                    map.put(strategy, new ConcurrentLinkedQueue());
                    serials = map.get(strategy);
                }
            }
        }
        synchronized (this){
            if (!serials.isEmpty()){
                return serials.poll();
            }else {
                serials = makeSerials(strategy);
                return serials.poll();
            }
        }
    }

    private Queue<String> makeSerials(String strategy) throws Exception {
        StrategySerial strategySerial = strategyService.getAutoSerial(strategy);
        AutoSerial autoSerial = autoSerialJpa.findAutoSerialByStrategy(strategy);

        // 默认一次生成10个序列号
        int size = 10;
        if (StringUtil.isNotBlank(strategySerial.getCacheSize())){
            size = Integer.parseInt(strategySerial.getCacheSize());
        }
        // 默认长度为8
        int length = 8;
        if (StringUtil.isNotBlank(strategySerial.getLength())){
            length = Integer.parseInt(strategySerial.getLength());
        }
        // 默认步长为1
        int step = 1;
        if (StringUtil.isNotBlank(strategySerial.getStep())){
            step = Integer.parseInt(strategySerial.getStep());
        }
        if (StringUtil.isNotBlank(strategySerial.getPrefix())){
            prefix = strategySerial.getPrefix();
        }

        Long begin = Long.parseLong(makeChar(length));
        Queue<String> updateSerials = map.get(strategy);
        if (autoSerial == null){ // 初始化
            for (int i = 1; i <= size; i++){
                Long serial = begin + i * step;
                if (i == size){
                    autoSerial = new AutoSerial();
                    autoSerial.setStrategy(strategy);
                    autoSerial.setSerial(serial.toString());
                    autoSerialJpa.save(autoSerial);
                }
                // 使用offer添加数据不会抛异常
                updateSerials.offer(serial.toString());
            }
        }
        /** 这里会成为bug的根源，因为编号超发导致回溯
        else if (StringUtil.isNotBlank(prefix) &&
                !autoSerial.getSerial().startsWith(begin.toString().substring(0, prefix.length()))){
            // 如果数据库中的autoSerial前缀和begin的前缀不同，直接使用begin开始计算
            for (int i = 1; i <= size; i++){
                Long serial = begin + i * step;
                if (i == size){
                    autoSerial.setSerial(serial.toString());
                    autoSerialJpa.save(autoSerial);
                }
                updateSerials.offer(serial.toString());
            }
        }
        */
        else { // 如果数据库中的autoSerial前缀和begin的前缀相同，需要在autoSerial的基础上继续增加
            for (int i = 1; i <= size; i++){
                Long serial = Long.parseLong(autoSerial.getSerial()) + i * step;
                if (i == size){
                    autoSerial.setSerial(serial.toString());
                    autoSerialJpa.save(autoSerial);
                }
                updateSerials.offer(serial.toString());
            }
        }

        return updateSerials;
    }

    private String makeChar(int num){
        StringBuilder chars = new StringBuilder();
        Date now = new Date();
        if (prefix != null && !"".equals(prefix)){
            // 已用字符串长度
            int usedLength;
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            if (prefix.equalsIgnoreCase("yyyymmdd")){
                dateFormat = new SimpleDateFormat("yyyyMMdd");
            }else if (prefix.equalsIgnoreCase("yymm")){
                dateFormat = new SimpleDateFormat("yyyyMM");
            }else if (prefix.equalsIgnoreCase("yyyymmddhhmmss")){
                dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            }

            usedLength = dateFormat.format(now).length();
            // 如果已用字符串长度超过设定长度，需要进行截断
            if (usedLength > num){
                // +1因为截断不包含右边位
                chars.append(dateFormat.format(now).substring(0, num + 1));
            }else {
                chars.append(dateFormat.format(now));
            }

            for (int i = 1; i <= num - usedLength; i++){
                chars.append("0");
            }
        }else {
            // 没有前缀字符则默认为100...，字符串长度为num
            chars.append("1");
            for (int i = 1; i <= num - 1; i++){
                chars.append("0");
            }
        }

        return chars.toString();
    }
}
