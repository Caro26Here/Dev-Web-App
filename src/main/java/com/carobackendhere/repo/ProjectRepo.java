package com.carobackendhere.repo;

import com.carobackendhere.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

    Optional<Project> findByName(String name);
    Optional<Project> findByActiveAndName(Boolean active, String name);

    List<Project> findAllByActive(Boolean active);
}
