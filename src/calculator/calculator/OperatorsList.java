package calculator.calculator;

public enum OperatorsList {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLY("*"),
    DEVISION("/");
    String value;

    OperatorsList(String value) {
        this.value = value;
    }

    public static boolean isOperator(String operator) {
        for (OperatorsList element: OperatorsList.values()) {
            if (element.value.equals(operator)) {
                return true;
            }
        }
        return false;
    }
}