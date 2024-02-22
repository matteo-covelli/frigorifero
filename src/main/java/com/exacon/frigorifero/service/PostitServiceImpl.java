package com.exacon.frigorifero.service;

import com.exacon.frigorifero.model.PostIt;
import com.exacon.frigorifero.repository.PostitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostitServiceImpl implements PostitService {

    @Autowired
    private PostitRepository repo;

    @Override
    public List<PostIt> findByUser_id(String userId) {
        return repo.findByUserId(userId);
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
