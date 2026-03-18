package web.Tests;

import org.testng.annotations.Test;
import web.Pages.ContactPage;
import web.Pages.HomePage;
import web.config.TestConfig;

public class ContactPageTest extends BasePageTest {

    @Test
    public void fillContactForm() {

        driver.get(TestConfig.BASE_URL);

        HomePage homePage = new HomePage(driver);
        homePage.clickContactForm();

        ContactPage contactPage = new ContactPage(driver);
        contactPage.chooseTopic();
        contactPage.chooseDate();
        contactPage.writeNote(TestConfig.CONTACT_NOTE);
    }

}
