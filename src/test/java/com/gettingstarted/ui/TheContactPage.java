package com.gettingstarted.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.locators.WaitForWebElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TheContactPage extends PageObject{
	public static Target SUBMIT_BUTTON = Target.the("Submit button")
			.located(By.xpath("//*[@class='btn-contact btn btn-primary']"));

	public static Target FORENAME_ERROR_MESSAGE_TEXT = Target.the("Forname error message text")
			.located(By.id("forename-err"));

	public static Target EMAIL_ERROR_MESSAGE_TEXT = Target.the("Email error message text").located(By.id("email-err"));

	public static Target MESSAGE_BOX_ERROR_MESSAGE_TEXT = Target.the("Message box error message text")
			.located(By.id("message-err"));

	public static Target FORENAME_TEXTFIELD = Target.the("Forename textfield").located(By.id("forename"));

	public static Target EMAIL_TEXTFIELD = Target.the("Email textfield").located(By.id("email"));

	public static Target MESSAGE_BOX_TEXTFIELD = Target.the("Message box textfield").located(By.id("message"));
	
	public static Target SUCCESSFUL_SUBMISSION_MESSAGE_TEXT = Target.the("Successful Submission Message text").located(By.xpath("//div[@class='alert alert-success']"));
	
	public static Target SENDING_FEEDBACK_MODAL = Target.the("Sending feedback modal").located(By.xpath("//*[text()= 'Sending Feedback']"));
	
	

	public static Question<Boolean> submit_button_is_visible() {
		return actor -> SUBMIT_BUTTON.resolveFor(actor).isVisible();
	}
	
	
	public static Question<Boolean> mandatory_fields_are_visible() {
		return actor -> {
			boolean foreNameTextField = FORENAME_TEXTFIELD.resolveFor(actor).isVisible();
			boolean emailTextField = EMAIL_TEXTFIELD.resolveFor(actor).isVisible();
			boolean messageBoxTextField = MESSAGE_BOX_TEXTFIELD.resolveFor(actor).isVisible();
			return foreNameTextField && emailTextField && messageBoxTextField;
		};
	}

	public static Question<Boolean> mandatory_error_message_are_visible() {
		return actor -> {
			boolean foreNameErrorMessageText = FORENAME_ERROR_MESSAGE_TEXT.resolveFor(actor).isVisible();
			boolean emailErrorMessageText = EMAIL_ERROR_MESSAGE_TEXT.resolveFor(actor).isVisible();
			boolean messageBoxErrorMessageText = MESSAGE_BOX_ERROR_MESSAGE_TEXT.resolveFor(actor).isVisible();
			return foreNameErrorMessageText && emailErrorMessageText && messageBoxErrorMessageText;
		};
	}
	
	public static Question<Boolean> mandatory_error_message_are_not_visible() {
		return actor -> {
			boolean foreNameErrorMessageText = !FORENAME_ERROR_MESSAGE_TEXT.resolveFor(actor).isVisible();
			boolean emailErrorMessageText = !EMAIL_ERROR_MESSAGE_TEXT.resolveFor(actor).isVisible();
			boolean messageBoxErrorMessageText = !MESSAGE_BOX_ERROR_MESSAGE_TEXT.resolveFor(actor).isVisible();
			return foreNameErrorMessageText && emailErrorMessageText && messageBoxErrorMessageText;
		};
	}
	
	public static Question<Boolean> successful_submission_message_text_is_visible() {
		return actor -> {
	        SUCCESSFUL_SUBMISSION_MESSAGE_TEXT.resolveFor(actor).waitUntilVisible();
	        return true; // Return true to indicate the element is visible
	    };	    
	}
	
	@SuppressWarnings("deprecation")
	public static Question<Boolean> sending_feedback_modal_is_not_visible() {
		return actor -> {
			SENDING_FEEDBACK_MODAL.resolveFor(actor).withTimeoutOf(10, TimeUnit.SECONDS);
			SENDING_FEEDBACK_MODAL.resolveFor(actor).waitUntilNotVisible();
	        return true; // Return true to indicate the element is not visible
	    };
	}
}
