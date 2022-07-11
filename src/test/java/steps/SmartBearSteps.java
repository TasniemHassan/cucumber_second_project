package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.OrdersPage;
import pages.SmartBearHomePage;
import pages.WebOrdersPage;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

public class SmartBearSteps {
    WebDriver driver;
    SmartBearHomePage smartBearHomePage;
    WebOrdersPage webOrdersPage;
    OrdersPage ordersPage;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        smartBearHomePage = new SmartBearHomePage();
        webOrdersPage = new WebOrdersPage();
        ordersPage = new OrdersPage();
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String username) {
        smartBearHomePage.userNameInputBox.sendKeys(username);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        smartBearHomePage.passwordInputBox.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        smartBearHomePage.loginButton.click();
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String message) {
        Assert.assertTrue(smartBearHomePage.invalidLoginMessage.isDisplayed());
        Assert.assertEquals(message, smartBearHomePage.invalidLoginMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable menuItemsList) {
        for (int i = 0; i < menuItemsList.asList().size(); i++) {
            Assert.assertEquals(menuItemsList.asList().get(i), webOrdersPage.menuItems.get(i).getText());

        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonText) {
        switch (buttonText) {
            case "Check All":
                webOrdersPage.checkAllButton.click();
                break;
            case "Uncheck All":
                webOrdersPage.unCheckAllButton.click();
                break;
            case "Process":
                ordersPage.processButton.click();
                break;
            case "Delete Selected":
                webOrdersPage.deleteSelectedButton.click();
                break;
            default:
                throw new NotFoundException("The buttonText is not displayed");
        }
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i = 0; i < webOrdersPage.checkBoxLocator.size(); i++) {
            Assert.assertTrue(webOrdersPage.checkBoxLocator.get(i).isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i = 0; i < webOrdersPage.checkBoxLocator.size(); i++) {
            Assert.assertFalse(webOrdersPage.checkBoxLocator.get(i).isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItem) {
        switch (menuItem) {
            case "Order":
               webOrdersPage.menuItems.get(2).click();
                Waiter.pause(3);
                break;
            case "View all orders":
                webOrdersPage.menuItems.get(0).click();
                Waiter.pause(3);
                break;
            default:
                throw new NotFoundException("Menu item not found!");
        }
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String productType) {
        DropdownHandler.selectOptionByVisibleText(ordersPage.familyAlbumSelection, productType);
        Waiter.pause(3);
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
        ordersPage.quantityInputBox.sendKeys(String.valueOf(quantity));
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        ordersPage.customerNameInputBox.sendKeys("Tas Hassan");
        ordersPage.streetInputBox.sendKeys("101 Main St");
        ordersPage.cityInputBox.sendKeys("Chicago");
        ordersPage.stateInputBox.sendKeys("IL");
        ordersPage.zipInputBox.sendKeys("60465");
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        ordersPage.cardTypeRadioButton.get(2).click();
        ordersPage.cardNumberInputBox.sendKeys("3214567891234567");
        ordersPage.expireDateInputBox.sendKeys("07/23");
        ordersPage.processButton.click();
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String tableName) {
        for(int i = 1; i < webOrdersPage.customerOrderList.size() -1; i++){
            Assert.assertTrue(webOrdersPage.customerOrderList.get(i).isDisplayed());
        }
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable orderInfo) {
        for (int i = 1; i <12; i++) {
            Assert.assertEquals(orderInfo.asList().get(i), webOrdersPage.customerOrderList.get(i).getText());
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String tableName) {
        Assert.assertNotNull(tableName);
    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals(message, webOrdersPage.orderMessage.getText());

    }
}
