package web.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.Pages.HomePage;
import web.config.TestConfig;

import static org.testng.Assert.assertEquals;

public class HomePageTest extends BasePageTest {


@Test
public void checkHomePageOpens() {

    driver.get(TestConfig.BASE_URL);

    HomePage homePage = new HomePage(driver);
    String actualTitle = homePage.getTitleMessage();

    assertEquals(actualTitle, TestConfig.HOME_PAGE_TITLE);
    log.info(actualTitle);
}

@Test
public void checkAllElementsAreVisible() {

    driver.get(TestConfig.BASE_URL);

    HomePage homePage = new HomePage(driver);

    Assert.assertTrue(homePage.isNameDisplayed(), TestConfig.NAME_TEXT + " is not visible");
    Assert.assertTrue(homePage.isDescriptionDisplayed(), TestConfig.DESCRIPTION_TEXT + " is not visible");
    Assert.assertTrue(homePage.isGitHubLinkDisplayed(), "GitHub link is not visible");
    Assert.assertTrue(homePage.isLinkedInLinkDisplayed(), "LinkedIn link is not visible");
    Assert.assertTrue(homePage.isContactFormLinkDisplayed(), "Contact form is not visible");
}

@Test
public void checkLinkedInLinkOpens() {

    driver.get(TestConfig.BASE_URL);
    HomePage homePage = new HomePage(driver);

    String originalWindow = driver.getWindowHandle();
    homePage.clickLinkedInLink();

    for (String window : driver.getWindowHandles()) {
        if (!window.equals(originalWindow)) {
            driver.switchTo().window(window);
            break;
        }
    }

    Assert.assertTrue(driver.getCurrentUrl().contains(TestConfig.LINKEDIN_KEYWORD));
}

@Test
public void checkGitHubLinkOpens(){

    driver.get(TestConfig.BASE_URL);
    HomePage homePage = new HomePage(driver);

    String originalWindow = driver.getWindowHandle();
    homePage.clickGitHubLink();

    for (String window : driver.getWindowHandles()) {
        if(!window.equals(originalWindow)) {
            driver.switchTo().window(window);
            break;
        }
    }

    Assert.assertTrue(driver.getCurrentUrl().contains(TestConfig.GITHUB_KEYWORD));
}

@Test
public void checkContactFormOpens(){

    driver.get(TestConfig.BASE_URL);
    HomePage homePage = new HomePage(driver);

    String originalWindow = driver.getWindowHandle();
    homePage.clickContactForm();

    for (String window : driver.getWindowHandles()) {
        if(!window.equals(originalWindow)){
            driver.switchTo().window(window);
            break;
        }
    }

    Assert.assertTrue(driver.getCurrentUrl().contains(TestConfig.CONTACT_KEYWORD));
}

}