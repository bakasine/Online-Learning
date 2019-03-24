package com.uerax.learning.controller;

import com.uerax.learning.domain.*;
import com.uerax.learning.service.*;
import com.uerax.learning.domain.CourseSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;


/**
 * @author uerax
 * @date 2018/12/20 20:18
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourceService courceService;

    @Autowired
    private CourceClassifySerivce courceClassifySerivce;

    @Autowired
    private UserCourceService userCourceService;

    @Autowired
    private CourceSectionService courceSectionService;

    /*登陆页面*/
    @RequestMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("user/login");
        return mav;
    }

    /*注册页面*/
    @RequestMapping("register")
    public String register() {
        return "user/register";
    }

    /*注册*/
    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    public @ResponseBody
    Message doRegister(User user) {
        Message message = new Message();
        if (false) {
            message.falseStatus();
            message.setMsg("注册失败");
        }
        message.setMsg("注册成功");
        user.setCreate(new Date());
        message.setList(userService.getUserByUsername(user));
        userService.addUser(user);
        return message;
    }

    /*登陆*/
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Message doLogin(User user, String remember, HttpSession session) {
        Message msg = new Message();
        if (!userService.checkUser(user)) {
            msg.setMsg("用户不存在或者用户密码不正确");
            msg.falseStatus();
            return msg;
        }
        if (user.getUsername().equals("admin")) {
            msg.setAdmin(0);
        }
        msg.setMsg("登陆成功");
        session.setAttribute("user", userService.getUserByUsername(user).get(0));
        return msg;
    }

    @RequestMapping("userInfo")
    public String userInfo(HttpSession session) {

        return "user/userinfo";
    }

    /*退出登陆*/
    @RequestMapping("loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("user");
        return "commons/home";
    }

    /*修改个人资料*/
    @RequestMapping(value = "changeInfo", method = RequestMethod.POST)
    @ResponseBody
    public Message changeInfo(User user, HttpSession session) {
        Message msg = new Message();
        userService.updateUser(user);
        session.setAttribute("user", userService.getUser(user));
        return msg;
    }

    @RequestMapping("toUpload")
    public String toUpload() {
        return "user/upload";
    }

    @RequestMapping(value = "doUpload", method = RequestMethod.POST)
    public @ResponseBody
    Message doUpload(Cource cource) {
        Message msg = new Message();
        msg.setMsg("创建成功");
        courceService.addCource(cource);
        return msg;
    }

    @RequestMapping("getCourceClassify")
    @ResponseBody
    public Message getCourceClassify(Cource cource) {
        Message msg = new Message();
        msg.setList(courceClassifySerivce.getSubClassify(cource.getClassify()));
        return msg;
    }

    @RequestMapping("toMyCource")
    public String toMyCource() {
        return "user/myCource";
    }

    @RequestMapping(value = "myCource", method = RequestMethod.POST)
    @ResponseBody
    public Message myCource(Cource creater) {
        System.out.println(creater);
        Message msg = new Message();
        msg.setList(courceService.getCource(creater));
        return msg;
    }

    @RequestMapping("deleteCource")
    @ResponseBody
    public Message deleteCource(Cource cource) {
        Message msg = new Message();
        courceService.deleteCource(cource);
        msg.setMsg("删除成功");
        return msg;
    }

    @RequestMapping("studyingCource")
    public String studyingCource() {
        return "user/studyingCource";
    }

    @RequestMapping("getStudyingCource")
    @ResponseBody
    public Message getStudyingCource(UserCource uc) {
        Message msg = new Message();
        msg.setList(userCourceService.getCourceByUser(uc));
        return msg;
    }



    @RequestMapping("setCourceId")
    @ResponseBody
    public void setCourceId(UserCource userCource, HttpSession session) {
        session.setAttribute("courceId", userCource.getCourceId());
    }

    @RequestMapping("toAddSection")
    public String toAddSection() {
        return "user/addSection";
    }

    @RequestMapping("saveSection")
    @ResponseBody
    public Message saveSection(CourseSection courseSection) {
        Message msg = new Message();
        courceSectionService.addCourceSection(courseSection);
        System.out.println(courseSection.getName());
        msg.setMsg("success");
        return msg;
    }

    @RequestMapping("getCourceInfo")
    @ResponseBody
    public Message getCourceInfo(CourseSection courseSection) {
        Message msg = new Message();
        msg.setList(courceSectionService.getCourceSectionByCourceIdWithoutSub(courseSection));
        return msg;
    }

    @RequestMapping("saveSubSection")
    @ResponseBody
    public Message saveSubSection(CourseSection courseSection, @RequestParam("video") MultipartFile video, HttpServletRequest req, HttpSession httpSession) throws IOException {
        Message msg = new Message();
        String path = req.getSession().getServletContext().getRealPath("video");
//        String realPath = req.getSession().getServletContext().getRealPath("/").substring(0, (path.indexOf("target")));
//        System.out.println(realPath);

        String videoName = video.getOriginalFilename();
        String videoExt = videoName.substring(videoName.lastIndexOf(".") + 1);
        String videoNewName = courseSection.getCourseId() + "-" + courseSection.getParentId() + "-" + courseSection.getSort() + "." + videoExt;
        File targetFile = new File(path, videoNewName);
//        File realTargetFile = new File(realPath, videoNewName);
        if(!targetFile.exists()) {
            new File(path).mkdirs();
        }
        video.transferTo(targetFile);
        String url = videoNewName;
        courseSection.setUrl(url);
        courceSectionService.addCourceSection(courseSection);
        return msg;
    }

    @RequestMapping("adminAllCource")
    public String adminAllCource() {
        return "admin/adminAllCource";
    }

    @RequestMapping("adminCarousel")
    public String adminCarousel() {
        return "admin/adminCarousel";
    }


}
