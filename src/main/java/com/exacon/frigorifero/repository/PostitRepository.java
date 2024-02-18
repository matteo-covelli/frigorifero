package com.exacon.frigorifero.repository;

import com.exacon.frigorifero.model.PostIt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostitRepository extends JpaRepository<PostIt, Long> {
    List<PostIt> findByTitle(String title);

    List<PostIt> findByUserId(String nome);

}
