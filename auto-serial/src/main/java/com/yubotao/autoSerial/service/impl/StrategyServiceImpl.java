package com.yubotao.autoSerial.service.impl;

import com.yubotao.autoSerial.model.StrategySerial;
import com.yubotao.autoSerial.service.StrategyService;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 12:02 2019/5/29
 * @Modified By:
 */
@Service
public class StrategyServiceImpl implements StrategyService{
    private static final String CONFIG_FILE = "/setting/strategy.xml";
    private static HashMap<String, StrategySerial> autoSerialMap = new HashMap<>();

    private static Logger logger = LoggerFactory.getLogger(StrategyServiceImpl.class);

    @PostConstruct // 在Servlet启动时执行该方法
    private static void init() throws Exception{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource configFile = resolver.getResource(CONFIG_FILE);
        try{
            InputStream inputStream = configFile.getInputStream(); // 会开启一个InputStream资源
            getAutoSerialByStrategy(new SAXReader().read(inputStream));// dom4j 解析xml
            inputStream.close();// 需要手动关闭
        }catch (Exception e){
            System.out.println("Can not analysis config file! Do you user the config file? if don't, ignore this message.");
        }
    }

    private static HashMap getAutoSerialByStrategy(Document document){
        if (document != null){
            List<Node> autoSerialNodeList = document.selectNodes("strategy/autoserials/autoserial");
            if (autoSerialNodeList != null){
                for (Node node : autoSerialNodeList){
                    String strategy = node.selectSingleNode("@strategy").getText();
                    String autoSerialModel = node.selectSingleNode("@autoSerialModel").getText();
                    String note = node.selectSingleNode("@note").getText();
                    String prefix = node.selectSingleNode("@prefix").getText();
                    String length = node.selectSingleNode("@length").getText();
                    String cacheSize = node.selectSingleNode("@cacheSize").getText();
                    String step = node.selectSingleNode("@step").getText();
                    StrategySerial strategySerial = new StrategySerial();
                    strategySerial.setStrategy(strategy);
                    strategySerial.setAutoSerialModel(autoSerialModel);
                    strategySerial.setNote(note);
                    strategySerial.setPrefix(prefix);
                    strategySerial.setLength(length);
                    strategySerial.setCacheSize(cacheSize);
                    strategySerial.setStep(step);
                    autoSerialMap.put(strategy, strategySerial);
                }
            }
        }
        return autoSerialMap;
    }

    public StrategySerial getAutoSerial(String strategy) throws Exception{
        StrategySerial strategySerial = autoSerialMap.get(strategy);
        if (strategySerial == null){
            throw new Exception("strategySerial is null");
        }
        return strategySerial;
    }
}
