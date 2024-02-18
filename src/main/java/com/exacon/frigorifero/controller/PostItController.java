package com.exacon.frigorifero.controller;

import com.exacon.frigorifero.model.PostIt;
import com.exacon.frigorifero.service.PostitService;
import lombok.RequiredArgsConstructor;
import org.hibernate.usertype.UserVersionType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/postit")
@RequiredArgsConstructor
public class PostItController {

    private final PostitService service;

    @GetMapping("/t")
    public String getAll(Model theModel) {
        List<PostIt> thePostits = service.findAll();
        PostIt p = new PostIt();

        theModel.addAttribute("postits", thePostits);
        theModel.addAttribute("postitSingolo", p);
        return "postit-home";

    }

    @GetMapping("/all")
    public String prendi(Authentication authentication, Model theModel) {


        List<PostIt> personalPostits = service.findByUser_id(authentication.getName());
        theModel.addAttribute("postits", personalPostits);


        PostIt p = new PostIt();
        theModel.addAttribute("postitSingolo", p);

        return "postit-home";
    }

    @PostMapping("/add/single")
    public String addPostit(@ModelAttribute("postit") PostIt thePostit, Authentication authentication) {
        thePostit.setUserId(authentication.getName());
        service.save(thePostit);

        return "redirect:/postit/all";
    }

    @GetMapping("/delete/single")
    public String deleteById(@RequestParam("postitId") Long theId) {
        service.deleteById(theId);

        return "redirect:/postit/all";
    }


}
