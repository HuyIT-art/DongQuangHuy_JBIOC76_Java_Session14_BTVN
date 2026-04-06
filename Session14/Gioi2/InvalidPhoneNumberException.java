package Session14.Gioi2;


public class InvalidPhoneNumberException extends Exception {

    public InvalidPhoneNumberException(String message) {
        super(message);
    }


    public static void validate(String phone) throws InvalidPhoneNumberException {

        if (phone.length() != 10) {
            throw new InvalidPhoneNumberException("Sai độ dài (phải 10 chữ số)");
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                throw new InvalidPhoneNumberException("Chứa ký tự không hợp lệ");
            }
        }
    }
}
