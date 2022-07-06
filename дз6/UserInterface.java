import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Controller controller = new Controller();

    public void runApplicaction (){
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название города на английском языке : ");
            String city = input.nextLine();

            setGlobalCity(city);

            System.out.println("Введите ответ : 1 - Получить текущую погоду, " +
                    "2 - Получить погоду на 5 дней, " +
                    "выход (exit) - завергить работу ");
            String result = input.nextLine();

            checkIsExit(result);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            try {
                notifyController(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getINSTANCE().setSelectedCity(city);
    }
    private void checkIsExit(String result) {
        if(result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")) {
            System.out.println("Завершаем работу");
            System.exit(0);
        }
    }
    private void validateUserInput (String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, actually get " + userInput);
        }
        int answer = 0;
        try{
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric");
        }
    }
    private void notifyController (String input) throws IOException {
        controller.onUserInput(input);
    }
}
