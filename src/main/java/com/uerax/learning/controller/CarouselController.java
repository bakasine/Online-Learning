package com.uerax.learning.controller;

import com.uerax.learning.domain.Carousel;
import com.uerax.learning.domain.Message;
import com.uerax.learning.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author uerax
 * @date 2019/3/24 21:46
 */
@Controller
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @RequestMapping("getCarousel")
    @ResponseBody
    public Message getCarousel() {
        Message msg = new Message();
        msg.setList(carouselService.getCarousel());
        System.out.println(msg.getList());
        return msg;
    }

    @RequestMapping("addCarousel")
    @ResponseBody
    public Message addCarousel(Carousel carousel, @RequestParam("image") MultipartFile image, HttpServletRequest req) throws IOException {
        Message msg = new Message();
        System.out.println(carousel + ":" + image);
        String path = req.getSession().getServletContext().getRealPath("image");
        String imageName = image.getOriginalFilename();
        String imageExt = imageName.substring(imageName.lastIndexOf(".") + 1);

        String imageNewName = new Date().getTime() + "." + imageExt;
        File targetFile = new File(path, imageNewName);
        if(!targetFile.exists()) {
            new File(path).mkdirs();
        }
        image.transferTo(targetFile);
        String picture = imageNewName;
        carousel.setPicture(picture);
        System.out.println(carousel);
        carouselService.addCarousel(carousel);

        return msg;
    }

    @RequestMapping("changeEnable")
    @ResponseBody
    public Message changeEnable(Carousel carousel) {
        carousel.setEnable(!carousel.getEnable());
        Message msg = new Message();
        carouselService.updateCarousel(carousel);
        return msg;
    }

    @RequestMapping("deleteCarousel")
    @ResponseBody
    public Message deleteCarousel(Carousel carousel) {
        carouselService.deleteCarousel(carousel);
        Message msg = new Message();
        msg.setMsg("删除成功");
        return msg;
    }

    @RequestMapping("getEnableCarousel")
    @ResponseBody
    public Message getEnableCarousel() {
        Message msg = new Message();
        msg.setList(carouselService.getEnableCarousel());
        System.out.println(msg.getList());

        return msg;
    }

}
