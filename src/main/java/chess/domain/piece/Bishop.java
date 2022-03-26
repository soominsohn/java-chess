package chess.domain.piece;

import chess.domain.piece.direction.Direction;
import chess.domain.piece.position.Position;
import java.util.List;
import java.util.Objects;

public class Bishop extends Piece {

    private static final double SCORE = 3;

    private static final String BLACK_DISPLAY = "♙";
    private static final String WHITE_DISPLAY = "♟";

    public Bishop(Color color, Position position) {
        super(color, position);
    }

    @Override
    public void move(Position position) {
        validateMovable(position);
        this.position = position;
    }

    @Override
    protected void attack(Position enemyPosition) {
        move(enemyPosition);
    }

    public void checkReachable(Position toPosition) {
        if (!position.isDiagonal(toPosition)) {
            throw new IllegalArgumentException(INVALID_MOVABLE_POSITION_EXCEPTION_MESSAGE);
        }
    }

    private void validateMovable(Position toPosition) {
        if (!position.isDiagonal(toPosition)) {
            throw new IllegalArgumentException(INVALID_MOVABLE_POSITION_EXCEPTION_MESSAGE);
        }
    }

    public List<Position> getPositionsInPath(Position toPosition) {
        Direction direction = Direction.findDiagonalDirection(position, toPosition);
        return direction.findPositionsInPath(position, toPosition);
    }


    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public boolean isKing() {
        return false;
    }

    @Override
    public double score() {
        return SCORE;
    }

    @Override
    public String display() {
        if (color == Color.BLACK) {
            return BLACK_DISPLAY;
        }
        return WHITE_DISPLAY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bishop bishop = (Bishop) o;
        return color == bishop.color
            && position == bishop.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, position);
    }

    @Override
    public String toString() {
        return "Bishop{" +
            "color=" + color +
            ", position=" + position +
            '}';
    }
}
