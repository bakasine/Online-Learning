package com.uerax.learning.controller;

import com.uerax.learning.domain.Cource;
import com.uerax.learning.domain.CourseSection;
import com.uerax.learning.domain.Message;
import com.uerax.learning.domain.UserCource;
import com.uerax.learning.service.CourceSectionService;
import com.uerax.learning.service.CourceService;
import com.uerax.learning.service.UserCourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author uerax
 * @date 2019/3/13 20:12
 */
@Controller
@RequestMapping("/cource")
public class CourceController {

    @Autowired
    private CourceService courceService;

    @Autowired
    private UserCourceService userCourceService;

    @Autowired
    private CourceSectionService courceSectionService;

    @RequestMapping("getHomeCource")
    @ResponseBody
    public Message getHomeCource() {

        Message msg = new Message();
        List<Cource> list = courceService.getAllCource();
        List<Cource> msgList = new ArrayList<>();
        int courceCnt = list.size();
        Random random = new Random();
        if (courceCnt > 4) {
            for (int i = 0; i < 4; i++) {
                msgList.add(list.get(random.nextInt(courceCnt)));
            }
            msg.setList(msgList);
            return msg;
        }
        msg.setList(list);
        return msg;
    }

    @RequestMapping(value = "courceInfo", method = RequestMethod.GET)
    public ModelAndView courceInfo(ModelAndView model, Integer id) {
        System.out.println(id);
        Cource cource = new Cource();
        cource.setId(id);
        model.addObject("cource", courceService.getCourceById(cource));
        model.setViewName("cource/courceInfo");
        return model;
    }

    @RequestMapping(value = "addStudyingCource")
    @ResponseBody
    public Message addStudyingCource(UserCource uc) {
        System.out.println(uc);
        Message msg = new Message();
        userCourceService.addCource(uc);
        return msg;
    }

    @RequestMapping(value = "deleteMyStudyingCource/{id}")
    @ResponseBody
    public Message deleteMyStudyingCource(@PathVariable("id") Integer id) {
        userCourceService.deleteCource(id);
        return new Message();
    }

    @RequestMapping(value = "studyCource", method = RequestMethod.GET)
    public ModelAndView studyCource(ModelAndView mav, Integer courseId) {
        System.out.println(courseId);
        mav.addObject("courceId", courseId);
        mav.setViewName("cource/studyCource");
        return mav;
    }

    @RequestMapping("getMainSection")
    @ResponseBody
    public Message getMainSection(CourseSection cs) {
        Message msg = new Message();
        msg.setList(courceSectionService.getCourceSectionByCourceIdWithoutSub(cs));
        return msg;
    }

    @RequestMapping("getSubSection")
    @ResponseBody
    public Message getSubSection(CourseSection cs) {
        Message msg = new Message();
        msg.setList(courceSectionService.getWithoutMain(cs));
        System.out.println(msg.getList());
        return msg;
    }

    @RequestMapping("allCource")
    public String allCource() {
        return "cource/allCource";
    }

    @RequestMapping("getAllCource")
    @ResponseBody
    public Message getAllCource() {
        Message msg = new Message();
        msg.setList(courceService.getAllCource());
        return msg;
    }

    @RequestMapping("getCourceByType")
    @ResponseBody
    public Message getCourceByType(Cource cource) {
        Message msg = new Message();
        msg.setList(courceService.getCourceByClassify(cource));
        return msg;
    }
}
