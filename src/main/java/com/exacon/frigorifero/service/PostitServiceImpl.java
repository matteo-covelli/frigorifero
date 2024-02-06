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
    public PostIt save(PostIt thePostit) {
        return repo.save(thePostit);
    }

    @Override
    public void deleteById(Long id) {

        repo.deleteById(id);

    }



}
