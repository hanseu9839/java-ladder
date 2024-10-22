package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @Test
    void person_이름_저장_에러_테스트() {

        assertThatThrownBy(() -> new Person("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름은 5글자를 넘을 수 없습니다.");
    }
}
