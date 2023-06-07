package com.gettingstarted.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.targets.Target;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.gettingstarted.ui.TheShopPage;

public class AddToCartAnItem implements Task {

	@Step("Buy {0} stuffed frogs")
    public static AddToCartAnItem buyStuffedFrogs(int numberOfClicks) {
        return instrumented(AddToCartAnItem.class, numberOfClicks, TheShopPage.STUFFED_FROG_BUY_BUTTON);
    }

    @Step("Buy {0} fluffy bunnies")
    public static AddToCartAnItem buyFluffyBunnies(int numberOfClicks) {
        return instrumented(AddToCartAnItem.class, numberOfClicks, TheShopPage.FLUFFY_BUNNY_BUY_BUTTON);
    }
    
    @Step("Buy {0} fluffy bunnies")
    public static AddToCartAnItem buyValentineBears(int numberOfClicks) {
        return instrumented(AddToCartAnItem.class, numberOfClicks, TheShopPage.VALENTINE_BEAR_BUY_BUTTON);
    }

    private int numberOfClicks;
    private Target button;

    public AddToCartAnItem(int numberOfClicks, Target button) {
        this.numberOfClicks = numberOfClicks;
        this.button = button;
    }

    @Override
    @Step("{0} performs clicks")
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < numberOfClicks; i++) {
            actor.attemptsTo(Click.on(button));
        }
    }
}