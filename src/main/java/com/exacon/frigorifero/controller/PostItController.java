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
   // private final CosaDaCreare cosaDaCreare;



    @GetMapping("/all")
    public String getAll(Model theModel){

        List<PostIt> thePostits = service.findAll();

        theModel.addAttribute("postits", thePostits);

        return "home";

    }


    @GetMapping("/showAdd")
    public String showAddForm(Model theModel){

        PostIt thePostit = new PostIt();
        theModel.addAttribute("postit", thePostit);

        return "postit-form";

    }

    @GetMapping("/showUpdate")
    public String showUpdateForm(@RequestParam("postitId") Long theId, Model theModel){

        PostIt thePostit = service.findById(theId);
        theModel.addAttribute("postit", thePostit);

        return "postit-form";

    }


    @PostMapping("/add/single")
    public String addPostit(@ModelAttribute("postit") PostIt thePostit){

        service.save(thePostit);

        return "redirect:/postit/all";
    }


    @GetMapping("/delete/single")
    public String deleteById(@RequestParam("postitId") Long theId){


       service.deleteById(theId);

        return "redirect:/postit/all";
    }






    /*
    @GetMapping("/paolo")
    public ResponseEntity<List<PostIt>> getPaolo(@RequestBody String body){
        System.out.println(body);
        cosaDaCreare.stampa();
        return ResponseEntity.ok(null);
    }
*/

}
