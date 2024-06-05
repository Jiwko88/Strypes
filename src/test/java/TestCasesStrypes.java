import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestCasesStrypes {

    static HomePage page = new HomePage();

    @Test
    public void testCases() {

        page.goToHomePageAndAcceptCookies();
        page.goAndSearch("Automation");
        page.verifyResultsForAutomation();
        page.goAndSearch("Vehicule");
        page.verifyResultsForVehicule();
        page.goToCareers();
        page.verifyResultsForAutomation();
        page.goBackToHomePage();
        page.getAllServicesFromMenu();
        page.goToCustomersPage();
        page.verifyCustomersSiteLoading("ARVOS");

    }

    @AfterTest
    public void tearDown() {
        page.getDriver().quit();


    }
}
