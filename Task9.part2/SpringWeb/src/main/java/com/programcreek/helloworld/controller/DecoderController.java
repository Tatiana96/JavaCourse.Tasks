package com.programcreek.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class DecoderController {

    @RequestMapping(value="/decoder", method= RequestMethod.GET)
    public ModelAndView decoderGet(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        //System.out.println("in controller");
        ModelAndView mv = new ModelAndView("mypage");
        //mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
    }
    @RequestMapping(value="/decoder", method=RequestMethod.POST)
    public ModelAndView decoderPost(
            @RequestParam(value = "s") String bon) throws IOException {
        String s = Decoder.decode(bon);
        ModelAndView mv = new ModelAndView("mypage");
        mv.addObject("s", s);
        return mv;
    }
}
