package Session14.Gioi2;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InvalidPhoneNumberLengthException extends Exception {
    public InvalidPhoneNumberLengthException() {

    }
    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }

    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        Pattern p1 = Pattern.compile("[a-zA-Z]+");
        Pattern p2 = Pattern.compile("[^a-zA-Z0-9\\s]+");
        Pattern p3 = Pattern.compile("\\s+");

        if (p1.matcher(phone).find()) {
            throw new InvalidPhoneNumberLengthException("Chứa kí tự không hợp lệ");
        } else if (p2.matcher(phone).find()) {
            throw new InvalidPhoneNumberLengthException("Không được chứa kí tự đặc biệt");
        } else if (p3.matcher(phone).find()) {
            throw new InvalidPhoneNumberLengthException("Không được chứa khoảng trắng");
        }else if (phone.length() > 10 || phone.length() < 10){
            throw new InvalidPhoneNumberLengthException("Độ dài số điện thoại không hợp lệ");

        }
    }
}
