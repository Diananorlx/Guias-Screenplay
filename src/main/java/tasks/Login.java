package tasks;

import model.ChoucairAcademyData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.ChoucairLoginPage;

import java.util.List;

import static userinterface.ChoucairLoginPage.*;

public class Login implements Task {

    ChoucairAcademyData choucairAcademyData;

    public Login(ChoucairAcademyData choucairAcademyData) {
        this.choucairAcademyData = choucairAcademyData;
    }

    public static Login onThePage(ChoucairAcademyData choucairAcademyData) {
        return Tasks.instrumented(Login.class, choucairAcademyData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOGIN_BUTTON),
                Enter.theValue(choucairAcademyData.getUsuario()).into(INPUT_USER),
                Enter.theValue(choucairAcademyData.getContraseña()).into(INPUT_PASSWORD),
                Click.on(ENTER_BUTTON)
        );
    }
}
