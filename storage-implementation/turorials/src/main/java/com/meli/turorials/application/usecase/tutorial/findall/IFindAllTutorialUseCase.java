package com.meli.turorials.application.usecase.tutorial.findall;

import com.meli.turorials.application.usecase.tutorial.comman.TutorialResponseModel;

import java.util.List;

public interface IFindAllTutorialUseCase {
    List<TutorialResponseModel> execute();
}
