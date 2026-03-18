package web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.config.TestConfig;


public class HomePage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement name;

    @FindBy(xpath = "//p")
    private WebElement description;

    @FindBy(xpath = "//a[@aria-label='GitHub']")
    private WebElement gitHubLink;

    @FindBy (xpath = "//a[@aria-label='LinkedIn']")
    private WebElement linkedInLink;

    @FindBy(xpath = "//a[@aria-label='Contact form']")
    private WebElement contactFormLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private void openHomePage() {
        driver.get(TestConfig.BASE_URL);
    }

    public boolean isNameDisplayed(){
        return name.isDisplayed();
    }

    public boolean isDescriptionDisplayed(){
        return description.isDisplayed();
    }

    public String getTitleMessage() {
        return driver.getTitle();
    }

    public boolean isGitHubLinkDisplayed (){
        return gitHubLink.isDisplayed();
    }

    public void clickGitHubLink(){
        gitHubLink.click();
    }

    public boolean isLinkedInLinkDisplayed(){
        return linkedInLink.isDisplayed();
    }

    public void clickLinkedInLink(){
        linkedInLink.click();
    }

    public boolean isContactFormLinkDisplayed(){
        return contactFormLink.isDisplayed();
    }

    public void clickContactForm(){
        contactFormLink.click();
    }

}
