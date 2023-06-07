package com.gettingstarted.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://jupiter.cloud.planittesting.com/#/")
public class TheJupiterToysHomePage extends PageObject {
	
	public static Target CONTACT_TAB_BUTTON = Target.the("Contact tab button").located(By.id("nav-contact"));
	
	public static Target SHOP_TAB_BUTTON = Target.the("Contact tab button").located(By.id("nav-shop"));
	
	public static Target CART_BUTTON = Target.the("Cart button").located(By.xpath("//*[@id='nav-cart']/a[@href='#/cart']"));
	
	public static Target START_SHOPPING_BUTTON = Target.the("Start Shopping button").located(By.xpath("//*[@class='btn btn-success btn-large']"));
	
	
	public void buy_2_stuffed_frog() {
		
	}
	
	@SuppressWarnings("deprecation")
	public static Question<Boolean> start_shopping_button_is_visible() {
		return actor -> {
		START_SHOPPING_BUTTON.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
		boolean startShoppingButton = START_SHOPPING_BUTTON.resolveFor(actor).waitUntilVisible().isVisible();
		return startShoppingButton;
		};
	}
	
	
}


