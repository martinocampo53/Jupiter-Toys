package com.gettingstarted.tests;

//Author: Martin Louie Ocampo
//Date finished: 6/07/2023

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.GivenWhenThen.and;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.gettingstarted.tasks.AddToCartAnItem;
import com.gettingstarted.tasks.OpenTheJupiterToys;
import com.gettingstarted.ui.TheCartPage;
import com.gettingstarted.ui.TheContactPage;
import com.gettingstarted.ui.TheJupiterToysHomePage;
import com.gettingstarted.ui.TheShopPage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class NavigateJupiterToysTest {


	@Managed
	public WebDriver browser;
	
	Actor anna = Actor.named("Anna").can(BrowseTheWeb.with(browser));

	@Steps
	OpenTheJupiterToys openTheJupiterToys;

	@Test
	public void test_case_1() {

		givenThat(anna).wasAbleTo(openTheJupiterToys);
		
		when(anna).attemptsTo(Click.on(TheJupiterToysHomePage.CONTACT_TAB_BUTTON));

		then(anna).should(seeThat(TheContactPage.submit_button_is_visible()));
		
		when(anna).attemptsTo(Click.on(TheContactPage.SUBMIT_BUTTON));
		
		then(anna).should(seeThat(TheContactPage.mandatory_error_message_are_visible()));
		
		when(anna).attemptsTo(SendKeys.of("Martin").into(TheContactPage.FORENAME_TEXTFIELD));
		
		and(anna).attemptsTo(SendKeys.of("martin.ocampo@planit.net.au").into(TheContactPage.EMAIL_TEXTFIELD));
		
		and(anna).attemptsTo(SendKeys.of("I wanna be a part of planit.").into(TheContactPage.MESSAGE_BOX_TEXTFIELD));
		
		then(anna).should(seeThat(TheContactPage.mandatory_error_message_are_not_visible()));
		
		
	}
	
	@Test
	public void test_case_2() {

		givenThat(anna).wasAbleTo(openTheJupiterToys);
		
		when(anna).attemptsTo(Click.on(TheJupiterToysHomePage.CONTACT_TAB_BUTTON));

		then(anna).should(seeThat(TheContactPage.mandatory_fields_are_visible()));
		
		when(anna).attemptsTo(SendKeys.of("Martin").into(TheContactPage.FORENAME_TEXTFIELD));
		
		and(anna).attemptsTo(SendKeys.of("martin.ocampo@planit.net.au").into(TheContactPage.EMAIL_TEXTFIELD));
		
		and(anna).attemptsTo(SendKeys.of("I wanna be a part of planit.").into(TheContactPage.MESSAGE_BOX_TEXTFIELD));
		
		and(anna).attemptsTo(Click.on(TheContactPage.SUBMIT_BUTTON));
		
		then(anna).should(seeThat(TheContactPage.sending_feedback_modal_is_not_visible()));
		
		then(anna).should(seeThat(TheContactPage.successful_submission_message_text_is_visible()));
		
		
	}
	
	@Test
	public void test_case_3() {

		givenThat(anna).wasAbleTo(openTheJupiterToys);
		
		then(anna).should(seeThat(TheJupiterToysHomePage.start_shopping_button_is_visible()));
		
		when(anna).attemptsTo(Click.on(TheJupiterToysHomePage.START_SHOPPING_BUTTON));
		
		try {
	        Thread.sleep(5000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

		then(anna).should(seeThat(TheShopPage.forsale_products_are_visible()));
		
		when(anna).attemptsTo(AddToCartAnItem.buyStuffedFrogs(2));
		
		and(anna).attemptsTo(AddToCartAnItem.buyFluffyBunnies(5));
		
		and(anna).attemptsTo(AddToCartAnItem.buyValentineBears(3));
		
		and(anna).attemptsTo(Click.on(TheJupiterToysHomePage.CART_BUTTON));
		
		then(anna).should(seeThat(TheCartPage.added_to_cart_products_are_visible()));
		
		then(anna).should(seeThat(TheCartPage.verify_the_price_for_each_product()));
		
		then(anna).should(seeThat(TheCartPage.verify_the_subtotal_for_each_product_is_correct()));
		
		then(anna).should(seeThat(TheCartPage.verify_the_total_price_is_correct()));
		
		
	}

}