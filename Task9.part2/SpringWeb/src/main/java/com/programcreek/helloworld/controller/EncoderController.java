package com.programcreek.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class EncoderController {

    @RequestMapping(value="/encoder", method= RequestMethod.GET)
    public ModelAndView encoderGet(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        ModelAndView mv = new ModelAndView("mypage");
        mv.addObject("name", name);
        return mv;
    }
    @RequestMapping(value="/encoder", method=RequestMethod.POST)
    public ModelAndView encoderPost(
            @RequestParam(value = "s") String bon) throws IOException {

        String s = Encoder.encode(bon);
        ModelAndView mv = new ModelAndView("mypage");
        mv.addObject("s", s);
        return mv;
    }
}
