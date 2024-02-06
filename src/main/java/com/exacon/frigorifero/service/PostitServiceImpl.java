package com.exacon.frigorifero.service;

import com.exacon.frigorifero.model.PostIt;
import com.exacon.frigorifero.repository.PostitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostitServiceImpl implements PostitService{

    @Autowired
    private PostitRepository repo;

    @Override
    public List<PostIt> findAll() {
        return repo.findAll();
    }

    public PostIt findById(Long id){
        Optional<PostIt> result = repo.findById(id);

        PostIt thePostit = null;

        if(result.isPresent()){
            thePostit = result.get();
        }

        return thePostit;

    }

    @Override
    public List<PostIt> findByTitle(String title) {

        return repo.findByTitle(title);

    }


    @Override
    public PostIt save(PostIt thePostit) {
        return repo.save(thePostit);
    }

    @Override
    public void deleteById(Long id) {

        repo.deleteById(id);

    }

    @Override
    public List<PostIt> deleteByTitle(String title) {

        List<PostIt> postitsEliminati = new ArrayList<>();

        List<PostIt> postits = repo.findByTitle(title);

        if(postits == null || postits.size() == 0)
            throw new RuntimeException("Non è stato trovato nessun postit con titolo: " + title);

        for (int i = 0; i<postits.size(); i++)
        {
            Long idFirstPostit = postits.get(i).getId();
            postitsEliminati.add(postits.get(i));
            repo.deleteById(idFirstPostit);
        }

        return postitsEliminati;
    }


}
