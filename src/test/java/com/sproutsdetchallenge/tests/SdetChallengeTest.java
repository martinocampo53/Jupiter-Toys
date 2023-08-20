package com.sproutsdetchallenge.tests;

import static net.serenitybdd.screenplay.GivenWhenThen.and;

//Author: Martin Louie Ocampo
//Date finished: 6/07/2023

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.gettingstarted.ui.TheContactPage;
import com.gettingstarted.ui.TheJupiterToysHomePage;
import com.sproutsdetchallenge.tasks.OpenTheSproutDemoSite;
import com.sproutsdetchallenge.ui.TheSproutDemoSiteHomePage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
public class SdetChallengeTest {


	@Managed
	public WebDriver browser;
	
	Actor anna = Actor.named("Anna").can(BrowseTheWeb.with(browser));

	@Steps
	OpenTheSproutDemoSite openTheSproutDemoSite;

	@Test
	@WithTag("sprout_sdet_challenge")
	public void sprout_sdet_challenge_test_case_1() {

		givenThat(anna).wasAbleTo(openTheSproutDemoSite);
		
		when(anna).attemptsTo(SendKeys.of("David").into(TheSproutDemoSiteHomePage.PERSON_GRID_SEARCH_TEXT_FIELD));
		
		and(anna).attemptsTo(Click.on(TheSproutDemoSiteHomePage.FOOD_GRID_SEARCH_DROPDOWN_FIELD));
		
		and(anna).attemptsTo(Click.on(TheSproutDemoSiteHomePage.CHEESECAKE_FOOD_DROPDOWN_VALUE));
		
		and(anna).attemptsTo(SendKeys.of("11/21/2019").into(TheSproutDemoSiteHomePage.DATE_GRID_SEARCH_TEXT_FIELD));
		
		and(anna).attemptsTo(Click.on(TheSproutDemoSiteHomePage.COUNTRY_GRID_SEARCH_TEXT_FIELD));
		
		and(anna).attemptsTo(Click.on(TheSproutDemoSiteHomePage.CHEF_GRID_SEARCH_DROPDOWN_FIELD));
		
		and(anna).attemptsTo(Click.on(TheSproutDemoSiteHomePage.PHEOBE_CHEF_DROPDOWN_VALUE));
		
		then(anna).should(seeThat("searched values are returned", TheSproutDemoSiteHomePage.searched_value_are_returned()));
		
		
	}

}