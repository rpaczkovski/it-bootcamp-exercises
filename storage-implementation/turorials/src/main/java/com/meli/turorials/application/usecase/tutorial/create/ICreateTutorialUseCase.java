package com.meli.turorials.application.usecase.tutorial.create;

import com.meli.turorials.application.usecase.tutorial.comman.TutorialResponseModel;

public interface ICreateTutorialUseCase {
    TutorialResponseModel execute(CreateTutorialRequestModel input);
}
