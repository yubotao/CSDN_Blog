package com.yubotao.thymeleaf.controller;

import com.yubotao.thymeleaf.model.AnimalForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 9:59 2018/9/12
 * @Modified By:
 */
@Controller
@RequestMapping(path = "/zoo")
public class ZooController {

    @RequestMapping(path = "list", method = RequestMethod.GET)
    public ModelAndView showZooList(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("zoolist");
        mav.addObject("animalForm", new AnimalForm());
        return mav;
    }

    @RequestMapping(path = "/list", params = {"save"}, method = RequestMethod.POST)
    public String doAdd(Model model, @Valid AnimalForm animalForm, BindingResult result){
        System.out.println("动物名： " + animalForm.getOname());
        System.out.println("数量： " + animalForm.getOcount());
        System.out.println("备注： " + animalForm.getMemo());
        if (result.hasErrors()){
            model.addAttribute("MSG", "出错啦！");
        }else {
            model.addAttribute("MSG", "提交成功！");
        }
        return "zoolist";
    }

}
