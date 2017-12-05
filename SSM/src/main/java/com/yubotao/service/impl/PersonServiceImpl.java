package com.yubotao.service.impl;

import com.yubotao.Dao.PersonMapper;
import com.yubotao.POJO.Person;
import com.yubotao.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yubotao on 2017/12/05.
 */
@Service
public class PersonServiceImpl implements PersonService{
    
    private static final Log log = LogFactory.getLog(PersonServiceImpl.class);
    
    @Autowired
    private PersonMapper personMapper;
    
    public Person getPersonById(Long id){
        return personMapper.selectByPrimaryKey(id);
    }
}
