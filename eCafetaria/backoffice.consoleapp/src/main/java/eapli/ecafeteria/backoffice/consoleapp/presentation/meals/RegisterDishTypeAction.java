package eapli.ecafeteria.backoffice.consoleapp.presentation.meals;

import eapli.framework.actions.Action;

/**
 *
 * @author mcn
 */
public class RegisterDishTypeAction implements Action {

    @Override
    public boolean execute() {
        return new RegisterDishTypeUI().show();
    }
}
