package com.gettingstarted.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import com.gettingstarted.ui.TheJupiterToysHomePage;

public class OpenTheJupiterToys implements Task {

	TheJupiterToysHomePage jupiterToysHomePage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(jupiterToysHomePage)
        );
    }
}