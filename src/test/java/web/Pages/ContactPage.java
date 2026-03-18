package web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContactPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement h1;

    @FindBy(xpath = "//*[@class='subtitle']")
    private WebElement subtitle;

    @FindBy(xpath = "//*[@name='topic']")
    private WebElement chooseTopicDropdown;

    @FindBy(xpath = "//*[@id='preferred-date']")
    private WebElement selectDate;

    @FindBy(xpath = "//*[@name='message']")
    private WebElement noteField;

    public ContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String chooseTopic() {
        chooseTopicDropdown.click();
        Select select = new Select(chooseTopicDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public String chooseDate() {

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String formattedDate = today.format(formatter);

        selectDate.click();
        selectDate.sendKeys(formattedDate);

        return formattedDate;
    }

    public String writeNote(String note){

        noteField.sendKeys(note);
        return note;
    }
}
