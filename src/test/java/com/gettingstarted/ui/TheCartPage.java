package com.gettingstarted.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class TheCartPage extends PageObject {

	public static Target STUFFED_FROG_IMAGE = Target.the("Stuffed Frog image").located(By.xpath("//*[@class='cart-item ng-scope']/td/img[@ng-src='images/src-embed/frog.jpg']"));
	
	public static Target FLUFFY_BUNNY_IMAGE = Target.the("Fluffy Bunny image").located(By.xpath("//*[@class='cart-item ng-scope']/td/img[@ng-src='images/src-embed/bunny.jpg']"));
	
	public static Target VALENTINE_BEAR_IMAGE = Target.the("Valentine Bear image").located(By.xpath("//*[@class='cart-item ng-scope']/td/img[@ng-src='images/src-embed/valentine.jpg']"));
	
	public static Target STUFFED_FROG_PRICE_TEXT = Target.the("Stuffed Frog price text").located(By.xpath("//td[contains(@class, 'ng-binding') and text()='$10.99']"));
	
	public static Target FLUFFY_BUNNY_PRICE_TEXT = Target.the("Fluffy Bunny price text").located(By.xpath("//td[contains(@class, 'ng-binding') and text()='$9.99']"));
	
	public static Target VALENTINE_BEAR_PRICE_TEXT = Target.the("Valentine Bear price text").located(By.xpath("//td[contains(@class, 'ng-binding') and text()='$14.99']"));
	
	public static Target STUFFED_FROG_QUANTITY_TEXTFIELD = Target.the("Stuffed Frog quantity textfield").located(By.xpath("//td[contains(text(), 'Stuffed Frog')]/following-sibling::td[contains(text(), '$10.99')]/following-sibling::td/input[@class='input-mini ng-pristine ng-valid ng-valid-number ng-valid-min']"));
	
	public static Target FLUFFY_BUNNY_QUANTITY_TEXTFIELD = Target.the("Fluffy Bunny quantity textfield").located(By.xpath("//td[contains(text(), 'Fluffy Bunny')]/following-sibling::td[contains(text(), '$9.99')]/following-sibling::td/input[@class='input-mini ng-pristine ng-valid ng-valid-number ng-valid-min']"));
	
	public static Target VALENTINE_BEAR_QUANTITY_TEXTFIELD = Target.the("Valentine Bear quantity textfield").located(By.xpath("//td[contains(text(), 'Valentine Bear')]/following-sibling::td[contains(text(), '$14.99')]/following-sibling::td/input[@class='input-mini ng-pristine ng-valid ng-valid-number ng-valid-min']"));
	
	public static Target STUFFED_FROG_SUBTOTAL_PRICE_TEXT = Target.the("Stuffed Frog subtotal price text").located(By.xpath("//td[contains(text(), 'Stuffed Frog')]/following-sibling::td[contains(text(), '$10.99')]/following-sibling::td/input[@class='input-mini ng-pristine ng-valid ng-valid-number ng-valid-min']/following::*[contains(text(), '$21.98')]"));
	
	public static Target FLUFFY_BUNNY_SUBTOTAL_PRICE_TEXT = Target.the("Fluffy Bunny subtotal price text").located(By.xpath("//td[contains(text(), 'Fluffy Bunny')]/following-sibling::td[contains(text(), '$9.99')]/following-sibling::td/input[@class='input-mini ng-pristine ng-valid ng-valid-number ng-valid-min']/following::*[contains(text(), '$49.95')]"));
	
	public static Target VALENTINE_BEAR_SUBTOTAL_PRICE_TEXT = Target.the("Valentine Bear subtotal price text").located(By.xpath("//td[contains(text(), 'Valentine Bear')]/following-sibling::td[contains(text(), '$14.99')]/following-sibling::td/input[@class='input-mini ng-pristine ng-valid ng-valid-number ng-valid-min']/following::*[contains(text(), '$44.97')]"));
	
	public static Target TOTAL_PRICE_TEXT = Target.the("Total price text").located(By.xpath("//*[@class='total ng-binding']"));


	public static Question<Boolean> added_to_cart_products_are_visible() {
		return actor -> {
			boolean stuffedFrogImage = STUFFED_FROG_IMAGE.resolveFor(actor).isVisible();
			boolean fluffyBunnyImage = FLUFFY_BUNNY_IMAGE.resolveFor(actor).isVisible();
			boolean valentineBearImage = VALENTINE_BEAR_IMAGE.resolveFor(actor).isVisible();
			return stuffedFrogImage && fluffyBunnyImage && valentineBearImage;
		};
	}
	
	public static Question<Boolean> verify_the_price_for_each_product() {
		return actor -> {
			String stuffedFrogPriceActualText = STUFFED_FROG_PRICE_TEXT.resolveFor(actor).getText();
			String stuffedFrogPriceExpectedText = "$10.99";
			String fluffyBunnyPriceActualText = FLUFFY_BUNNY_PRICE_TEXT.resolveFor(actor).getText();
			String fluffyBunnyPriceExpectedText = "$9.99";
			String valentineBearPriceActualText = VALENTINE_BEAR_PRICE_TEXT.resolveFor(actor).getText();
			String valentineBearPriceExpectedText = "$14.99";
			return stuffedFrogPriceActualText.equals(stuffedFrogPriceExpectedText)  && fluffyBunnyPriceActualText.equals(fluffyBunnyPriceExpectedText) && valentineBearPriceActualText.equals(valentineBearPriceExpectedText);

		};
	}
	
	public static Question<Boolean> verify_the_subtotal_for_each_product_is_correct() {
		return actor -> {
			String stuffedFrogSubtotalPriceActualText = STUFFED_FROG_SUBTOTAL_PRICE_TEXT.resolveFor(actor).getText();
			String stuffedFrogSubtotalPriceExpectedText = "$21.98";
			String fluffyBunnySubtotalPriceActualText = FLUFFY_BUNNY_SUBTOTAL_PRICE_TEXT.resolveFor(actor).getText();
			String fluffyBunnySubtotalPriceExpectedText = "$49.95";
			String valentineBearSubtotalPriceActualText = VALENTINE_BEAR_SUBTOTAL_PRICE_TEXT.resolveFor(actor).getText();
			String valentineBearSubtotalPriceExpectedText = "$44.97";
			return stuffedFrogSubtotalPriceActualText.equals(stuffedFrogSubtotalPriceExpectedText)  && fluffyBunnySubtotalPriceActualText.equals(fluffyBunnySubtotalPriceExpectedText) && valentineBearSubtotalPriceActualText.equals(valentineBearSubtotalPriceExpectedText);
		};
	}
	
	public static Question<Boolean> verify_the_total_price_is_correct() {
		return actor -> {
			String stuffedFrogSubtotalPriceActualText = STUFFED_FROG_SUBTOTAL_PRICE_TEXT.resolveFor(actor).getText();
	        String fluffyBunnySubtotalPriceActualText = FLUFFY_BUNNY_SUBTOTAL_PRICE_TEXT.resolveFor(actor).getText();
	        String valentineBearSubtotalPriceActualText = VALENTINE_BEAR_SUBTOTAL_PRICE_TEXT.resolveFor(actor).getText();
	        String totalItemExpectedPriceText = TOTAL_PRICE_TEXT.resolveFor(actor).getText();

	        Double stuffedFrogSubtotalPrice = Double.parseDouble(stuffedFrogSubtotalPriceActualText.replace("$", ""));
	        Double fluffyBunnySubtotalPrice = Double.parseDouble(fluffyBunnySubtotalPriceActualText.replace("$", ""));
	        Double valentineBearSubtotalPrice = Double.parseDouble(valentineBearSubtotalPriceActualText.replace("$", ""));
	        Double totalItemExpectedPrice = Double.parseDouble(totalItemExpectedPriceText.replace("Total: ", ""));

	        Double totalItemActualPriceText = stuffedFrogSubtotalPrice + fluffyBunnySubtotalPrice + valentineBearSubtotalPrice;
	        String totalActualPrice = String.valueOf(totalItemActualPriceText);
	        String totalExpectedPrice = String.valueOf(totalItemExpectedPrice);
	        
	        return totalActualPrice.equals(totalExpectedPrice);
		};
	}

}
