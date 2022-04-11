package com.meli.turorials.application.usecase.tutorial.findbyid;

import com.meli.turorials.application.usecase.tutorial.comman.TutorialResponseModel;
import com.meli.turorials.application.usecase.tutorial.comman.exception.NotFoundTutorialException;
import com.meli.turorials.domain.entity.Tutorial;
import com.meli.turorials.domain.repository.ITutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindByIdTutorialUseCase implements IFindByIdTutorialUseCase {

    private ITutorialRepository repository;

    @Override
    public TutorialResponseModel execute(long id) {
        Optional<Tutorial> opTutorial = repository.findById(id);
        opTutorial.orElseThrow(() -> new NotFoundTutorialException("Not found tutorial."));

        return TutorialResponseModel.fromDomain(opTutorial.get());
    }
}
