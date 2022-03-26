package chess.domain.piece.direction;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.domain.piece.position.Position;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    @DisplayName("source: a1, target: b2 일 때 direction은 RIGHT_UP_DIAGONAL을 반환한다.")
    @Test
    void right_up_diagonal() {
        Direction actual = Direction.findDiagonalDirection(Position.of("a1"), Position.of("b2"));
        Direction expected = Direction.RIGHT_UP_DIAGONAL;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: b1, target: a2 일 때 direction은 LEFT_UP_DIAGONAL을 반환한다.")
    @Test
    void left_up_diagonal() {
        Direction actual = Direction.findDiagonalDirection(Position.of("b1"), Position.of("a2"));
        Direction expected = Direction.LEFT_UP_DIAGONAL;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a2, target: b1 일 때 direction은 RIGHT_DOWN_DIAGONAL을 반환한다.")
    @Test
    void right_down_diagonal() {
        Direction actual = Direction.findDiagonalDirection(Position.of("a2"), Position.of("b1"));
        Direction expected = Direction.RIGHT_DOWN_DIAGONAL;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: b2, target: a1 일 때 direction은 LEFT_DOWN_DIAGONAL을 반환한다.")
    @Test
    void left_down_diagonal() {
        Direction actual = Direction.findDiagonalDirection(Position.of("b2"), Position.of("a1"));
        Direction expected = Direction.LEFT_DOWN_DIAGONAL;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: b3, target: a1 일 때 direction은 NONE을 반환한다.")
    @Test
    void NONE_1() {
        Direction actual = Direction.findDiagonalDirection(Position.of("b3"), Position.of("a1"));
        Direction expected = Direction.NONE;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a1, target: d4 일 때 path는 b2, c3의 position이 들어가야한다.")
    @Test
    void right_up_path() {
        Direction direction = Direction.RIGHT_UP_DIAGONAL;

        List<Position> actual = direction.findPositionsInPath(Position.of("a1"), Position.of("d4"));
        List<Position> expected = List.of(Position.of("b2"), Position.of("c3"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: d1, target: a4 일 때 path는 c2, b3의 position이 들어가야한다.")
    @Test
    void left_up_path() {
        Direction direction = Direction.LEFT_UP_DIAGONAL;

        List<Position> actual = direction.findPositionsInPath(Position.of("d1"), Position.of("a4"));
        List<Position> expected = List.of(Position.of("c2"), Position.of("b3"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a4, target: d1 일 때 path는 b3, c2의 position이 들어가야한다.")
    @Test
    void right_down_path() {
        Direction direction = Direction.RIGHT_DOWN_DIAGONAL;

        List<Position> actual = direction.findPositionsInPath(Position.of("a4"), Position.of("d1"));
        List<Position> expected = List.of(Position.of("b3"), Position.of("c2"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: d4, target: a1 일 때 path는 c3, b2 position이 들어가야한다.")
    @Test
    void left_down_path() {
        Direction direction = Direction.LEFT_DOWN_DIAGONAL;

        List<Position> actual = direction.findPositionsInPath(Position.of("d4"), Position.of("a1"));
        List<Position> expected = List.of(Position.of("c3"), Position.of("b2"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a1, target: a2 일 때 direction은 UP을 반환한다.")
    @Test
    void up() {
        Direction actual = Direction.findCrossDirection(Position.of("a1"), Position.of("a2"));
        Direction expected = Direction.UP;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a2, target: a1 일 때 direction은 DOWN을 반환한다.")
    @Test
    void down() {
        Direction actual = Direction.findCrossDirection(Position.of("a2"), Position.of("a1"));
        Direction expected = Direction.DOWN;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: b1, target: a1 일 때 direction은 LEFT를 반환한다.")
    @Test
    void left() {
        Direction actual = Direction.findCrossDirection(Position.of("b1"), Position.of("a1"));
        Direction expected = Direction.LEFT;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a1, target: b1 일 때 direction은 RIGHT을 반환한다.")
    @Test
    void right() {
        Direction actual = Direction.findCrossDirection(Position.of("a1"), Position.of("b1"));
        Direction expected = Direction.RIGHT;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a1, target: b3 일 때 direction은 NONE을 반환한다.")
    @Test
    void NONE_2() {
        Direction actual = Direction.findCrossDirection(Position.of("a1"), Position.of("b3"));
        Direction expected = Direction.NONE;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a1, target: a4 일 때 path는 a2, a3 position이 들어가야한다.")
    @Test
    void up_path() {
        Direction direction = Direction.UP;

        List<Position> actual = direction.findPositionsInPath(Position.of("a1"), Position.of("a4"));
        List<Position> expected = List.of(Position.of("a2"), Position.of("a3"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a4, target: a1 일 때 path는 a3, a2 position이 들어가야한다.")
    @Test
    void down_path() {
        Direction direction = Direction.DOWN;

        List<Position> actual = direction.findPositionsInPath(Position.of("a4"), Position.of("a1"));
        List<Position> expected = List.of(Position.of("a3"), Position.of("a2"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: d1, target: a1 일 때 path는 c1, b1 position이 들어가야한다.")
    @Test
    void left_path() {
        Direction direction = Direction.LEFT;

        List<Position> actual = direction.findPositionsInPath(Position.of("d1"), Position.of("a1"));
        List<Position> expected = List.of(Position.of("c1"), Position.of("b1"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a1, target: d1 일 때 path는 b1, c1 position이 들어가야한다.")
    @Test
    void right_path() {
        Direction direction = Direction.RIGHT;

        List<Position> actual = direction.findPositionsInPath(Position.of("a1"), Position.of("d1"));
        List<Position> expected = List.of(Position.of("b1"), Position.of("c1"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a1, target: d1 일 때 direction은 RIGHT_UP_DIAGONAL을 반환한다.")
    @Test
    void findAllDirection_if_CrossDirection() {
        Direction actual = Direction.findAllDirection(Position.of("a1"), Position.of("d1"));
        Direction expected = Direction.RIGHT;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("source: a2, target: b1 일 때 direction은 RIGHT_DOWN_DIAGONAL을 반환한다.")
    @Test
    void findAllDirection_if_DiagonalDirection() {
        Direction actual = Direction.findAllDirection(Position.of("a2"), Position.of("b1"));
        Direction expected = Direction.RIGHT_DOWN_DIAGONAL;

        assertThat(actual).isEqualTo(expected);
    }

}
