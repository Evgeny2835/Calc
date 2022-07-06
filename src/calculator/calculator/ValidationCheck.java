package calculator.calculator;

public class ValidationCheck {

    static public boolean isValidity(String[] array) {
        try {
            if (OperatorsList.isOperator(array[1])) {
                try {
                    if ((RomanList.isCorrectRomanList(array[0])) && (RomanList.isCorrectRomanList(array[2]))) {
                        return true;
                    } else if ((Integer.parseInt(array[0]) >= 1 && Integer.parseInt(array[0]) <= 10) &&
                            (Integer.parseInt(array[2]) >= 1 && Integer.parseInt(array[2]) <= 10)) {
                        return true;
                    } else {
                        throw new Exception("Неподходящий формат операндов");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }
            } else {
                throw new Exception("Введен некорректный оператор");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}