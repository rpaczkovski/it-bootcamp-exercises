package com.meli.turorials.application.usecase.tutorial.update;

import com.meli.turorials.application.usecase.tutorial.comman.TutorialResponseModel;
import com.meli.turorials.application.usecase.tutorial.comman.exception.NotFoundTutorialException;
import com.meli.turorials.domain.entity.Tutorial;
import com.meli.turorials.domain.repository.ITutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UpdateTutorialUseCase implements IUpdateTutorialUseCase {

    private ITutorialRepository repository;

    @Override
    public TutorialResponseModel execute(long id, UpdateTutorialRequestModel input) {
        Optional<Tutorial> opTutorial = repository.findById(id);
        opTutorial.orElseThrow(() -> new NotFoundTutorialException("Not found tutorial."));
        Tutorial tutorial = opTutorial.get();
        tutorial.update(
                input.getTitle(),
                input.getDescription(),
                input.isPublic()
        );
        repository.update(tutorial);

        return TutorialResponseModel.fromDomain(tutorial);
    }
}
