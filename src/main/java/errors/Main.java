package errors;

import errors.checked.PasswordNotUniqueException;
import errors.checked.RegistrationService;
import errors.unchecked.RocketLaunch;

public class Main {
    public static void main(String[] args) {


        RegistrationService service = new RegistrationService();
        try {
            service.validatePassword("521dsa@`1");
        } catch (PasswordNotUniqueException e) {
            // logging and handling the situation
        }


            RocketLaunch launch = new RocketLaunch();
            launch.checkCode("55");



    }
}
