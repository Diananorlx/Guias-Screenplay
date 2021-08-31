package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.ChoucairAcademyData;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.Answer;
import tasks.Login;
import tasks.OpenUp;
import tasks.Search;

import java.util.List;


public class ChoucairAcademyStepDefintions {

        @Before
        public void setStage (){ OnStage.setTheStage(new OnlineCast());}

    @Given("^than diana wants to learn automation at the academy Choucair$")
    public void thanDianaWantsToLearnAutomationAtTheAcademyChoucair(List<ChoucairAcademyData> choucairAcademyData) {
        OnStage.theActorCalled("diana").wasAbleTo(OpenUp.thePage(), (Login.onThePage(choucairAcademyData.get(0))));
    }

    @When("^he search for the course (.*) on the Choucair academy platform$")
    public void heSearchForTheCourseRecursosAutomatizaciónBancolombiaOnTheChoucairAcademyPlatform(String course) {
        OnStage.theActorInTheSpotlight().attemptsTo(Search.the(course));

    }

    @Then("^he finds the course called resources (.*)$")
    public void heFindsTheCourseCalledResourcesRecursosAutomatizaciónBancolombia(String question) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(question)));
    }

}

