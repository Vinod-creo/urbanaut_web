package CityPageTest;

import POMRepository.Instagram;
import Utility.UtilityClasss.BaseClass;
import org.testng.annotations.Test;

public class TestFooter extends BaseClass {
    Instagram instagram;

    @Test(priority = 1)
    /*
   This test case is designed to verify the functionality of clicking on the Instagram logo
   on a citypage and checking whether it properly navigates to the Instagram page or not.
   */ public void testInstaLogoNavigation() throws InterruptedException {
        instagram = citypage.clickInstaLogo();
        instagram.verifuInstagramUrl();
        System.out.println("instagram logo navigation to the instagram page verified");
    }

    @Test(priority = 2)
    /*
   This test case is designed to verify the functionality of clicking on the "Join our gram" link
   on a citypage and checking whether it properly navigates to the Instagram page or not.
   */ public void testJoinourgramLinkNavigation() throws InterruptedException {
        instagram = citypage.clickInstaLink();
        instagram.verifuInstagramUrl();
    }

    @Test(priority = 3)
   /*
   This test case is designed to verify the functionality of clicking on the "Home" link
   on a citypage and checking whether it properly navigates to the city page or not.
  */ public void testHomeLinkNavigation() throws InterruptedException {
        citypage.clickHomeLink();
        webactionutil.switchToNewTab(driver, "https://dev.urbanaut.app/");
    }

    @Test(priority = 4)
    /*
   This test case is designed to verify the functionality of clicking on the "Terms and Condition" link
   on a citypage and checking whether it properly navigates to the terms and conditions page or not.
   */ public void testTermsAndConditionLinkNavigation() throws InterruptedException {
        citypage.clickTermsAndCondtionLink();
        webactionutil.switchToNewTab(driver, "https://dev.urbanaut.app/terms-and-conditions/");
    }

    @Test(priority = 5)
    /*
   This test case is designed to verify the functionality of clicking on the "Privacy Policy" link
   on a citypage and checking whether it properly navigates to the privacy policy page or not.
  */ public void testPrivacyPolicyLinkNavigation() throws InterruptedException {
        citypage.clickPrivacyPolicyLink();
        webactionutil.switchToNewTab(driver, "https://dev.urbanaut.app/terms-and-conditions/");
    }

    @Test(priority = 6)
    /*
   This test case verifies the functionality of clicking on the "EULA" (End User License Agreement) link
   on a citypage and checks whether it properly navigates to the END USER LICENSE AGREEMENT page or not.
   */ public void testEULALinkNavigation() throws InterruptedException {
        citypage.clickEULALink();
        webactionutil.switchToNewTab(driver, "https://dev.urbanaut.app/end-user-license-agreement/");
    }

    @Test(priority = 7)
    /*
   This test case verifies the functionality of clicking on the "About Us" link
   on a citypage and checks whether it properly navigates to the About Us page or not.
   */ public void testAboutUsLinkNavigation() throws InterruptedException {
        citypage.clickAboutUsLink();
        webactionutil.switchToNewTab(driver, "https://dev.urbanaut.app/about-us/");
    }

    @Test(priority = 8)
    /*
   This test case verifies the functionality of clicking on the "Download the app" link
   on a citypage and checks whether it opens a production build of the application.
   */ public void testDownloadTheAppLinkNavigation() throws InterruptedException {
        citypage.clickDownloadTheAppLink();
        webactionutil.verifyUrlAfterElementClick("https://urbanaut.app/");
    }

    @Test(priority = 9)
    /*
   This test case verifies the functionality of clicking on the "Subscribe To Newsletter" link
   on a citypage and checks whether it properly navigates to the corresponding page.
   */ public void testSubscribeToNewSletterLinkNavigation() throws InterruptedException {
        citypage.clickSubscribetoNewsletter();
        webactionutil.verifyUrlAfterElementClick("https://cdn.forms-content.sg-form.com/039bc1c4-8cbe-11eb-a494-862f57ab974b");
    }

    @Test(priority = 10)
    /*
   This test case verifies whether the certificate image is present or not on the citypage.
   */ public void testCertificateImage() {
        // Verify the presence of the certificate image on the citypage
        citypage.verifyCertificateImage();
    }
}
