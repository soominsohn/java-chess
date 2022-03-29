package chess.view;

import chess.dto.CommandDto;
import java.util.Scanner;

public class InputView {

    private static final String START = "start";
    private static final String MOVE = "move";
    private static final String STATUS = "status";
    private static final String END = "end";

    private static final String COMMAND_INPUT_DELIMITER = " ";
    private static final int COMMAND_POSITION = 0;

    private static final String INVALID_START_OR_END_INPUT_EXCEPTION_MESSAGE = "start 혹은 end만 입력하셔야 합니다.";
    private static final String INVALID_START_OR_MOVE_OR_END_INPUT_EXCEPTION_MESSAGE = "start 혹은 move 혹은 end만 입력하셔야 합니다.";
    private static final String INVALID_STATUS_OR_END_INPUT_EXCEPTION_MESSAGE = "status 혹은 end만 입력하셔야 합니다.";

    private static final Scanner scanner = new Scanner(System.in);

    public static boolean requestStartOrEndInput() {
        String input = scanner.nextLine();
        validateStartOrEnd(input);
        return input.equals(START);
    }

    private static void validateStartOrEnd(String input) {
        if (!input.equals(START) && !input.equals(END)) {
            throw new IllegalArgumentException(INVALID_START_OR_END_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static CommandDto requestStartOrMoveOrEndInput() {
        String input = scanner.nextLine();
        validateStartOrMoveOrEnd(input);
        return new CommandDto(input);
    }

    private static void validateStartOrMoveOrEnd(String input) {
        String firstInput = input.split(COMMAND_INPUT_DELIMITER)[COMMAND_POSITION];
        if (!firstInput.equals(START) && !firstInput.equals(END) && !firstInput.equals(MOVE)) {
            throw new IllegalArgumentException(INVALID_START_OR_MOVE_OR_END_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static boolean requestStatusOrEndInput() {
        String input = scanner.nextLine();
        validateStatusOrEnd(input);
        return input.equals(STATUS);
    }

    private static void validateStatusOrEnd(String input) {
        if (!input.equals(STATUS) && !input.equals(END)) {
            throw new IllegalArgumentException(INVALID_STATUS_OR_END_INPUT_EXCEPTION_MESSAGE);
        }
    }

}


