package chess.piece;

import static chess.domain.piece.Color.BLACK;
import static chess.domain.piece.Color.WHITE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.domain.piece.King;
import chess.domain.piece.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KingTest {

    @DisplayName("색과 위치가 동일한 King 인스턴스는 서로 동일하다고 간주된다.")
    @Test
    void equals_sameOnSameColorAndPosition() {
        King actual = new King(BLACK, Position.of("e1"));
        King expected = new King(BLACK, Position.of("e1"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("다른 색의 King 인스턴스는 위치가 같더라도 서로 다른 것으로 간주된다.")
    @Test
    void equals_differentOnPositionDifference() {
        King blackKing = new King(BLACK, Position.of("e1"));
        King whiteKing = new King(WHITE, Position.of("e1"));

        assertThat(blackKing).isNotEqualTo(whiteKing);
    }

    @DisplayName("같은 색과 위치의 King 인스턴스의 해쉬코드 값은 서로 같다.")
    @Test
    void hashCode_sameOnSameColorAndPosition() {
        int actual = new King(BLACK, Position.of("e1")).hashCode();
        int expected = new King(BLACK, Position.of("e1")).hashCode();

        assertThat(actual).isEqualTo(expected);
    }
}