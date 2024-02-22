package com.exacon.frigorifero.service;

import com.exacon.frigorifero.model.PostIt;

import java.util.List;

public interface PostitService {

    public List<PostIt> findByUser_id(String userId);

    public PostIt save(PostIt thePostit);

    public void deleteById(Long id);


}
