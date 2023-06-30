package guru.qa.homework;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GitHubRepoIssueTest {

    String allureExampleRepository = "eroshenkoam/allure-example";
    int number = 80;

    SelenideElement
            searchInput = $(".header-search-input"),
            issuesTab = $("#issues-tab"),
            desiredIssueLink = $(withText("#" + number));


    @Test
    @Feature("Repository issue tab")
    @Story("Assure that specific issue exists")
    @Owner("EphimSh")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "github.com", url = "https://github.com")
    @DisplayName("Issue in repository issue-tab exists")
    void issueNameTestCleanSelenideWithListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        searchInput.setValue(allureExampleRepository).submit();
        $(linkText(allureExampleRepository)).click();
        issuesTab.click();
        desiredIssueLink.should(exist);
    }

    @Test
    @Feature("Repository issue tab")
    @Story("Assure that specific issue exists")
    @Owner("EphimSh")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "github.com", url = "https://github.com")
    @DisplayName("Issue in repository issue-tab exists")
    void issueNameTestLambdaSyntax() {
        step("open webpage", () -> {
            open("https://github.com");
        });
        step("search for repository: " + allureExampleRepository, () -> {
            searchInput
                    .setValue(allureExampleRepository)
                    .submit();
        });
        step("click on repository: " + allureExampleRepository, () -> {
            $(linkText(allureExampleRepository)).click();
            issuesTab.click();
        });
        step("Issue number:" + number + " exists", () -> {
            desiredIssueLink.should(exist);
        });
    }

    @Test
    @Feature("Repository issue tab")
    @Story("Assure that specific issue exists")
    @Owner("EphimSh")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "github.com", url = "https://github.com")
    @DisplayName("Issue in repository issue-tab exists")
    void annotatedStepTest() {
        WebSteps steps = new WebSteps();
        steps.openPage();
        steps.search(allureExampleRepository);
        steps.clickOn(allureExampleRepository);
        steps.checkThatIssueWithSpecificNumberExists(number);
    }
}
