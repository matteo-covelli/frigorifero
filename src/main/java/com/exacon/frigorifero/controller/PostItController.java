package com.exacon.frigorifero.controller;

import com.exacon.frigorifero.model.PostIt;
import com.exacon.frigorifero.service.PostitService;
import lombok.RequiredArgsConstructor;
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
    public String getAll(Model theModel) {
        List<PostIt> thePostits = service.findAll();
        PostIt p = new PostIt();

        theModel.addAttribute("postits", thePostits);
        theModel.addAttribute("postitSingolo", p);

        return "home";

    }


    @GetMapping("/showUpdate")
    public String showUpdateForm(@RequestParam("postitId") Long theId, Model theModel) {
        PostIt thePostit = service.findById(theId);
        theModel.addAttribute("postit", thePostit);

        return "postit-form";
    }


    @PostMapping("/add/single")
    public String addPostit(@ModelAttribute("postit") PostIt thePostit) {
        service.save(thePostit);

        return "redirect:/postit/all";
    }


    @GetMapping("/delete/single")
    public String deleteById(@RequestParam("postitId") Long theId) {
        service.deleteById(theId);

        return "redirect:/postit/all";
    }


}
