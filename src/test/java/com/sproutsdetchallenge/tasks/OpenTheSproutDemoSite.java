package com.sproutsdetchallenge.tasks;

import com.sproutsdetchallenge.ui.TheSproutDemoSiteHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheSproutDemoSite implements Task {

	TheSproutDemoSiteHomePage sproutDemoSiteHomePage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(sproutDemoSiteHomePage)
        );
    }
}