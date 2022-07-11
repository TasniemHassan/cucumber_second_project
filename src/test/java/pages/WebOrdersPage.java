package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class WebOrdersPage {
    public WebOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css="#ctl00_menu a")
    public List<WebElement> menuItems;

    @FindBy(id="ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(id="ctl00_MainContent_btnUncheckAll")
    public WebElement unCheckAllButton;

    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkBoxLocator;

    @FindBy(css = "table[class='SampleTable']>tbody>tr:nth-child(2) td")
    public List<WebElement> customerOrderList;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelectedButton;

    @FindBy(id = "ctl00_MainContent_orderGrid")
    public WebElement orderTable;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement orderMessage;
}
