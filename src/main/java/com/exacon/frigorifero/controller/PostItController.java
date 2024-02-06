package com.exacon.frigorifero.controller;

import com.exacon.frigorifero.model.PostIt;
import com.exacon.frigorifero.service.CosaDaCreare;
import com.exacon.frigorifero.service.PostitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/postit")
@RequiredArgsConstructor
public class PostItController {

    private final PostitService service;
   // private final CosaDaCreare cosaDaCreare;



    @GetMapping("/all")
    public ResponseEntity<List<PostIt>> getAll(){
        return ResponseEntity.ok(service.findAll());
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


    @PostMapping("/add/single")
    public PostIt addPostit(@RequestBody PostIt thePostit){

        PostIt dbPostit = service.save(thePostit);
        return dbPostit;
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

    @PutMapping("/update")
    public PostIt updatePostit(@RequestBody PostIt thePostit){

        Long pId = thePostit.getId();
        PostIt dbPostit = null;

        if(service.findById(pId) != null)
            dbPostit = service.save(thePostit);
        else
            throw new RuntimeException("postit da modificare non presente");

        return dbPostit;

    }

    @PutMapping("/update/{postitId}")
    public PostIt updatePostitTitle(@RequestBody PostIt thePostit,@PathVariable Long postitId){

        String title = thePostit.getTitle();
        PostIt p = service.findById(postitId);
        if(p == null)
            throw new RuntimeException("Il postit a cui vuoi modificare il titolo non esiste. Id inserito: " + postitId);

        p.setTitle(title);
        PostIt dbPostit = service.save(p);

        return dbPostit;

    }


    @DeleteMapping("/{postitId}")
    public String deleteById(@PathVariable Long postitId){

        PostIt tempPostit = service.findById(postitId);

        if(tempPostit != null)
            service.deleteById(postitId);
        else
            throw new RuntimeException("Postit con id: " + postitId + " non presente");

        return "Postit con id: " + postitId + " eliminato con successo";

    }

    @DeleteMapping("/d/{title}")
    public List<PostIt> deleteByTitle(@PathVariable String title){

        List<PostIt> postitsEliminati = service.deleteByTitle(title);

        if(postitsEliminati == null || postitsEliminati.size() == 0)
            throw new RuntimeException("Non è stato trovato nessun postit con titolo: " + title);

        return postitsEliminati;
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
