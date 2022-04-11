package com.meli.turorials.infrastructure.gateway.tutorial;

import com.meli.turorials.domain.entity.Tutorial;
import com.meli.turorials.domain.repository.ITutorialRepository;
import com.meli.turorials.infrastructure.data.TutorialTable;
import com.meli.turorials.infrastructure.repository.JPATutorialRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JPATutorial implements ITutorialRepository {
    private final JPATutorialRepository repository;

    public JPATutorial(JPATutorialRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tutorial> findAll() {
        return repository.findAll()
                .stream()
                .map(tutorialTable -> TutorialTable.fromEntity(tutorialTable))
                .collect(Collectors.toList());
    }

    @Override
    public Tutorial create(Tutorial tutorial) {
        return TutorialTable.fromEntity(repository.save(
                TutorialTable.builder()
                        .title(tutorial.getTitle())
                        .description(tutorial.getDescription())
                        .isPublic(tutorial.isPublic())
                        .createdAt(LocalDate.now())
                        .build()
        ));
    }

    @Override
    public Optional<Tutorial> findById(Long id) {
        return Optional.of(
                TutorialTable.fromEntity(repository.findById(id).get())
        );
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Tutorial tutorial) {
        TutorialTable tutorialTable = repository.getById(tutorial.getId());
        tutorialTable.setTitle(tutorial.getTitle());
        tutorialTable.setDescription(tutorial.getDescription());
        tutorialTable.setIsPublic(tutorial.isPublic());
        repository.save(tutorialTable);
    }
}
