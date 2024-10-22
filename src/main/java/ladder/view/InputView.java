package ladder.view;

import java.util.Scanner;

public class InputView {
    private final static String PARTICIPANT_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String LADDER_COUNT_QUESTION = "최대 사다리 높이는 몇 개인가요?";

    private final static Scanner scanner = new Scanner(System.in);

    public static String participantQuestion() {
        System.out.println(PARTICIPANT_QUESTION);
        return scanner.nextLine();
    }

    public static int ladderCountQuestion() {
        System.out.println();
        System.out.println(LADDER_COUNT_QUESTION);
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }
}
