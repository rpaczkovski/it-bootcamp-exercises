package com.meli.turorials.application.usecase.tutorial.update;

import com.meli.turorials.application.usecase.tutorial.comman.TutorialResponseModel;

public interface IUpdateTutorialUseCase {
    TutorialResponseModel execute(long id, UpdateTutorialRequestModel input);
}
