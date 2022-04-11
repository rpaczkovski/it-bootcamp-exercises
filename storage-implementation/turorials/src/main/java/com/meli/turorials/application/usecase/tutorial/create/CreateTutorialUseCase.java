package com.meli.turorials.application.usecase.tutorial.create;

import com.meli.turorials.application.usecase.tutorial.comman.TutorialResponseModel;
import com.meli.turorials.domain.entity.Tutorial;
import com.meli.turorials.domain.repository.ITutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateTutorialUseCase implements ICreateTutorialUseCase {

    private ITutorialRepository repository;

    @Override
    public TutorialResponseModel execute(CreateTutorialRequestModel input) {
        Tutorial tutorialCreated = repository.create(toDomain(input));
        return TutorialResponseModel.fromDomain(tutorialCreated);
    }

    private Tutorial toDomain(CreateTutorialRequestModel input) {
        return new Tutorial(
                input.getTitle(),
                input.getDescription(),
                input.isPublic()
        );
    }
}
