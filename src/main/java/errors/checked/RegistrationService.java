package errors.checked;

import java.util.Arrays;
import java.util.List;

public class RegistrationService {
    List<String> registeredPaswords = Arrays.asList("dasf212#12", "521dsa@`1");

    public void validatePassword(String password) throws PasswordNotUniqueException {
        if (registeredPaswords.contains(password)) {
            throw new PasswordNotUniqueException("Such Password Already Registered");
        }
    }
}