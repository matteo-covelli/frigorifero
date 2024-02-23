package com.exacon.frigorifero.service;

import com.exacon.frigorifero.model.PostIt;
import com.exacon.frigorifero.repository.PostitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostitServiceImpl implements PostitService {

    @Autowired
    private PostitRepository repo;

    @Override
    public List<PostIt> findByUser_id(String userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public void save(PostIt thePostit) {
        repo.save(thePostit);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }


}
