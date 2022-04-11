package com.meli.turorials.application.usecase.tutorial.findbyid;

import com.meli.turorials.application.usecase.tutorial.comman.TutorialResponseModel;

public interface IFindByIdTutorialUseCase {
    TutorialResponseModel execute(long id);
}
