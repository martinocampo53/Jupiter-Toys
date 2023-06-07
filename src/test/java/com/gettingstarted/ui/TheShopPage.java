package com.gettingstarted.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class TheShopPage extends PageObject {

	public static Target TEDDY_BEAR_IMAGE = Target.the("Teddy bear image").located(By.xpath("//*[@id='product-1']"));

	public static Target STUFFED_FROG_IMAGE = Target.the("Stuffed frog image")
			.located(By.xpath("//*[@id='product-2']"));

	public static Target HANDMADE_DOLL_IMAGE = Target.the("Handmade doll image")
			.located(By.xpath("//*[@id='product-3']"));

	public static Target FLUFFY_BUNNY_IMAGE = Target.the("Fluffy bunny image")
			.located(By.xpath("//*[@id='product-4']"));

	public static Target SMILEY_BEAR_IMAGE = Target.the("Smiley bear image").located(By.xpath("//*[@id='product-5']"));

	public static Target FUNNY_COW_IMAGE = Target.the("Fluffy cow image").located(By.xpath("//*[@id='product-6']"));

	public static Target VALENTINE_BEAR_IMAGE = Target.the("Valentine bear image")
			.located(By.xpath("//*[@id='product-7']"));

	public static Target SMILEY_FACE_IMAGE = Target.the("Smiley face image").located(By.xpath("//*[@id='product-8']"));

	public static Target FLUFFY_BUNNY_BUY_BUTTON = Target.the("Fluffy bunny buy button")
			.located(By.xpath("//*[@id='product-4']/div/p/a[@class='btn btn-success']"));

	public static Target STUFFED_FROG_BUY_BUTTON = Target.the("Stuffed frog buy button")
			.located(By.xpath("//*[@id='product-2']/div/p/a[@class='btn btn-success']"));

	public static Target VALENTINE_BEAR_BUY_BUTTON = Target.the("Valentine bear buy button")
			.located(By.xpath("//*[@id='product-7']/div/p/a[@class='btn btn-success']"));

	public static Target FLUFFY_BUNNY_PRICE_TEXT = Target.the("Fluffy bunny price text")
			.located(By.xpath("//*[@id='product-4']/div/p/span[@class='product-price ng-binding']"));

	public static Target STUFFED_FROG_PRICE_TEXT = Target.the("Stuffed frog price text")
			.located(By.xpath("//*[@id='product-2']/div/p/span[@class='product-price ng-binding']"));

	public static Target VALENTINE_BEAR_PRICE_TEXT = Target.the("Valentine bear price text")
			.located(By.xpath("//*[@id='product-7']/div/p/span[@class='product-price ng-binding']"));

	@SuppressWarnings("deprecation")
	public static Question<Boolean> forsale_products_are_visible() {
		return actor -> {
			try {
		        Thread.sleep(5000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
			TEDDY_BEAR_IMAGE.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
			STUFFED_FROG_IMAGE.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
			HANDMADE_DOLL_IMAGE.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
			FLUFFY_BUNNY_IMAGE.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
			SMILEY_BEAR_IMAGE.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
			FUNNY_COW_IMAGE.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
			VALENTINE_BEAR_IMAGE.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
			SMILEY_FACE_IMAGE.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
			boolean teddyBearImage = TEDDY_BEAR_IMAGE.resolveFor(actor).waitUntilVisible().isVisible();
			boolean stuffedFrogImage = STUFFED_FROG_IMAGE.resolveFor(actor).waitUntilVisible().isVisible();
			boolean handmadeDollImage = HANDMADE_DOLL_IMAGE.resolveFor(actor).waitUntilVisible().isVisible();
			boolean fluffyBunnyImage = FLUFFY_BUNNY_IMAGE.resolveFor(actor).waitUntilVisible().isVisible();
			boolean smileyBearImage = SMILEY_BEAR_IMAGE.resolveFor(actor).waitUntilVisible().isVisible();
			boolean funnyCowImage = FUNNY_COW_IMAGE.resolveFor(actor).waitUntilVisible().isVisible();
			boolean valentineBearImage = VALENTINE_BEAR_IMAGE.resolveFor(actor).waitUntilVisible().isVisible();
			boolean smileyFaceImage = SMILEY_FACE_IMAGE.resolveFor(actor).waitUntilVisible().isVisible();
			return teddyBearImage && stuffedFrogImage && handmadeDollImage && fluffyBunnyImage && smileyBearImage
					&& funnyCowImage && valentineBearImage && smileyFaceImage;
		};
	}

}
