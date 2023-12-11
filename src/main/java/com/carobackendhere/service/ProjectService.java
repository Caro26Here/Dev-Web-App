package com.carobackendhere.service;

import com.carobackendhere.PersonalException;
import com.carobackendhere.model.Project;
import com.carobackendhere.repo.ProjectRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepo repo;

    @Transactional
    public void createProject(String name, String url) throws PersonalException {

        if(name == null || name.isEmpty()){
            throw new PersonalException("The project name entered cannot be null or empty.");
        }

        if(url == null || url.isEmpty()){
            throw new PersonalException("The url entered cannot be null or empty.");
        }

        Project newProject = new Project();
        newProject.setName(name);
        newProject.setUrl(url);

        repo.save(newProject);
    }

    public Project getProjectById(Long id) throws PersonalException {

        if (id == null || id < 0) {
            throw new PersonalException("The id entered cannot be null or less than 0.");
        }
        Optional<Project> projectSearched = repo.findById(id);

        if (projectSearched.isEmpty()){
            throw new PersonalException("We couldn't find a project with the id entered.");
        }

        return projectSearched.get();
    }

    public List<Project> listActiveProjects() throws PersonalException {

        List<Project> projects = repo.findAllByActive(true);

        if (projects == null){
            throw new PersonalException("There are no active projects.");
        }

        return projects;
    }

    @Transactional
    public void updateProject(Long id, String name, String url) throws PersonalException {

        if (id == null || id < 0) {
            throw new PersonalException("The id entered cannot be null or less than 0.");
        }

        if (name == null || name.isEmpty()) {
            throw new PersonalException("The project name entered cannot be null or empty.");
        }

        if (url == null || url.isEmpty()) {
            throw new PersonalException("The url entered cannot be null or empty.");
        }

        Optional<Project> updatedProject = repo.findById(id);

        if (updatedProject.isEmpty()) {
            throw new PersonalException("We couldn't find a project with the id entered.");
        }

        Project project = updatedProject.get();
        project.setName(name);
        project.setUrl(url);

        repo.save(project);
    }
}
