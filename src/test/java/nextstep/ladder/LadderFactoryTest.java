package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.factory.LadderFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {

    @Test
    void ladder_생성() {
        LadderFactory ladderFactory = new LadderFactory();
        Ladder ladder = ladderFactory.createRandomLadder(5, 4);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }
}
