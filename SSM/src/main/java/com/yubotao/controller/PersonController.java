package com.yubotao.controller;

import com.yubotao.POJO.Person;
import com.yubotao.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yubotao on 2017/12/05.
 */
@Controller
public class PersonController {
    
    private static final Log log = LogFactory.getLog(PersonController.class);
    
    @Autowired
    private PersonService personService;
    
    @RequestMapping(value = "/person/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(@PathVariable Long id){
        Person person = personService.getPersonById(id);
        log.info("person : " + person);
        return person;
    }
    
}
