package com.sproutsdetchallenge.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.aspnetawesome.com/")
public class TheSproutDemoSiteHomePage extends PageObject {
	
	public static Target PERSON_GRID_SEARCH_TEXT_FIELD = Target.the("Person Grid Search text field").located(By.id("GridFrow2fltPerson-awed"));
	
	public static Target FOOD_GRID_SEARCH_DROPDOWN_FIELD = Target.the("Food Grid Search dropdown field").located(By.id("GridFrow2fltFood-awed"));
	
	public static Target CHEESECAKE_FOOD_DROPDOWN_VALUE = Target.the("Cheesecake food dropdown value").located(By.xpath("//li[@class='o-itm o-v o-ditm']/div[contains(text(), 'Cheesecake')]"));
	
	public static Target DATE_GRID_SEARCH_TEXT_FIELD = Target.the("Date Grid Search text field").located(By.id("GridFrow2fltDate"));
	
	public static Target COUNTRY_GRID_SEARCH_TEXT_FIELD = Target.the("Country Grid Search dropdown field").located(By.id("GridFrow2fltCountry-awed"));
	
	public static Target PICCADILLY_COUNTRY_DROPDOWN_VALUE = Target.the("Piccadilly country dropdown value").located(By.xpath("//li[@class='o-itm o-v o-ditm' and contains(text(), 'Piccadilly')]"));
	
	public static Target CHEF_GRID_SEARCH_DROPDOWN_FIELD = Target.the("Chef Grid Search dropdown field").located(By.id("GridFrow2fltChef-awed"));
	
	public static Target PHEOBE_CHEF_DROPDOWN_VALUE = Target.the("Pheobe Chef dropdown value").located(By.xpath("//li[@class='o-itm o-v o-ditm focus' and contains(text(), 'Phoebe Phoebes')]"));
	
	public static Target RETURNED_GRID_VALUE = Target.the("Returned Grid value").located(By.xpath("(//tr[@class='awe-row'])[1]"));
	
	
	
	public static Question<Boolean> searched_value_are_returned() {
		return actor -> {
			String returnedGridValue = RETURNED_GRID_VALUE.resolveFor(actor).getText();
			String expectedGridValue = "553 David Cheesecake 39 11/21/2019 Piccadilly Mango Phoebe Phoebes";
			return returnedGridValue.equals(expectedGridValue);
		};
	}
	
}


