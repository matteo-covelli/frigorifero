package com.exacon.frigorifero.service;

import com.exacon.frigorifero.model.PostIt;
import lombok.extern.java.Log;

import java.util.List;

public interface PostitService {

    public List<PostIt> findAll();

    public PostIt findById(Long id);

    public List<PostIt> findByTitle(String title);

    public PostIt save(PostIt thePostit);

    public void deleteById(Long id);

    public List<PostIt> deleteByTitle(String title);
}
