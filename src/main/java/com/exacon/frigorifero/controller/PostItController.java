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



    @GetMapping("/{postitId}")
    public PostIt getById(@PathVariable Long postitId){

        PostIt thePostit = service.findById(postitId);

        if(thePostit == null)
            throw new RuntimeException("Postit con id: " + postitId + " non trovato xd");

        return thePostit;
    }

    @GetMapping("/ottieni/{title}")
    public List<PostIt> getByTitle(@PathVariable String title){

        List<PostIt> postits = service.findByTitle(title);

        if(postits == null || postits.size() == 0)
            throw new RuntimeException("Postit con titolo: " + title + " non trovati");

        return postits;


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

    @PostMapping("/add/multiple")
    public List<PostIt> addPostits(@RequestBody List<PostIt> postIts)
    {
        for (PostIt thePostit : postIts)
        {
            service.save(thePostit);
        }

        return postIts;
    }



    @DeleteMapping("/d/{title}")
    public List<PostIt> deleteByTitle(@PathVariable String title){

        List<PostIt> postitsEliminati = service.deleteByTitle(title);

        if(postitsEliminati == null || postitsEliminati.size() == 0)
            throw new RuntimeException("Non è stato trovato nessun postit con titolo: " + title);

        return postitsEliminati;
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
