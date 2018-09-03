package com.wujiang.controller;

import com.wujiang.model.Question;
import com.wujiang.model.ViewObject;
import com.wujiang.service.QuestionService;
import com.wujiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/","/index"},method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model, @RequestParam(value = "pop",defaultValue = "0") int pop,
                        @RequestParam(value = "p",defaultValue ="10") int p){
        model.addAttribute("vos",getQuestions(0,(p-1)*10,10));
        return "index";
    }

    public List<ViewObject> getQuestions(int userId,int offset,int limit){
        List<Question> Questions=questionService.getLatestQuestions(userId,offset,limit);
        List<ViewObject> vos=new ArrayList<>();

        for(Question question:Questions){
            ViewObject vo=new ViewObject();
            vo.set("question",question);
            vo.set("user",userService.selectById(question.getUserId()));
            vos.add(vo);
        }
        return vos;
    }
}
