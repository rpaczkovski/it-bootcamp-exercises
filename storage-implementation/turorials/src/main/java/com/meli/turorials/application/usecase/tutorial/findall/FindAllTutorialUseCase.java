package com.meli.turorials.application.usecase.tutorial.findall;

import com.meli.turorials.application.usecase.tutorial.comman.TutorialResponseModel;
import com.meli.turorials.domain.repository.ITutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindAllTutorialUseCase implements IFindAllTutorialUseCase {

    private ITutorialRepository repository;

    @Override
    public List<TutorialResponseModel> execute() {
        return repository.findAll().stream().map(
                tutorial -> TutorialResponseModel.fromDomain(tutorial)
        ).collect(Collectors.toList());
    }
}
