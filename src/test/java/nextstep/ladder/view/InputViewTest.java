package nextstep.ladder.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private static final String PARTICIPANT_NAMES = "pobi,honux,crong,jk";
    private static final String HEIGHT_OF_LADDER = "1";

    @Test
    void readParticipantNamesTest() {
        // given
        inputParticipantNames();
        // when
        String participantNames = InputView.readParticipantNames();
        // then
        assertThat(participantNames).isEqualTo(PARTICIPANT_NAMES);
    }

    @Test
    void readHeightOfLadderTest() {
        // given
        inputHeightOfLadder();
        // when
        int heightOfLadder = InputView.readHeightOfLadder();
        // then
        assertThat(heightOfLadder).isEqualTo(Integer.parseInt(HEIGHT_OF_LADDER));
    }

    private void inputParticipantNames() {
        inputSystemValue(PARTICIPANT_NAMES);
    }

    private void inputHeightOfLadder() {
        inputSystemValue(HEIGHT_OF_LADDER);
    }

    private void inputSystemValue(String input) {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
