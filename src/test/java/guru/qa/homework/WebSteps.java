package guru.qa.homework;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open main page")
    public void openPage(){
        open("https://github.com");
    }
    @Step("Search for repository with name: {repo}")
    public void search(String repo){
        $(".header-search-input")
                .setValue(repo)
                .submit();
    }
    @Step("Click on {repo}")
    public void clickOn(String repo){
        $(linkText(repo)).click();
        $("#issues-tab").click();
    }
    @Step("Issue with number: {number} exists" )
    public void checkThatIssueWithSpecificNumberExists(int number){
        $(withText("#" + number)).should(exist);
    }

}
