package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertsTests extends SharedData {

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);
        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);

        indexPage.interactWithAlertsFrameWindowMenu();
        alertFrameWindowPage.interactWithAlertsSubmenu();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.dealAlertOk();
        alertPage.dealAlertTimer();
        alertPage.dealAlertCancel();
        alertPage.dealAlertPrompt("Dumniezai");
    }
}