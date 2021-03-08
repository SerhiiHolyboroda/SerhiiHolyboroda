package errors.unchecked;

import java.util.Arrays;
import java.util.List;

public class RocketLaunch {

    public void checkCode(String code) {
        if (!isCodeValid(code)) {
            throw new NuclearCodeNotValidException("Invalid code! No world desctruction today");
        }
    }

    private boolean isCodeValid(String code) {
        List<String> validCodes= Arrays.asList("880-800", "555-35-35");
        if (validCodes.contains(code.substring(code.indexOf("-") + 1))) {
            return true;
        }
        return false;
    }
}
