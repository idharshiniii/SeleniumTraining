package org.stepdefinition;

import org.base.Baseclassss;
import org.pojo.mynthrapojoo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class mythrasearchpojo extends Baseclassss {

@Given("To launch the browser and maximise the window")
public void to_launch_the_browser_and_maximise_the_window() {
     launchbrowser();
     windowMaximize();
}

@When("To launch the url of mynthra page")
public void to_launch_the_url_of_mynthra_page() {
     launchUrl("https://www.myntra.com/");
}

@When("To pass the product name in search textbox")
public void to_pass_the_product_name_in_search_textbox() {
	mynthrapojoo m= new mynthrapojoo();
	passText("bag", m.getSearchbox());
    
}

@When("To click the search button")
public void to_click_the_search_button() {
   mynthrapojoo m = new mynthrapojoo();
   clickBtn(m.getSearchbtn());
}

@Then("To close the chrome browser")
public void to_close_the_chrome_browser() {
    closeEntirebrowser();
}
}

