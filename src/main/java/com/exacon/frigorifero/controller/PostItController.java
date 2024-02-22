package com.exacon.frigorifero.controller;

import com.exacon.frigorifero.model.PostIt;
import com.exacon.frigorifero.service.PostitService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/all")
    public String getPersonaPostits(Authentication authentication, Model theModel) {
        List<PostIt> personalPostits = service.findByUser_id(authentication.getName());
        PostIt p = new PostIt();
        theModel.addAttribute("postits", personalPostits);
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
