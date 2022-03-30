package chess.domain.piece;

import chess.domain.direction.Direction;
import chess.domain.position.Position;
import java.util.List;
import java.util.Objects;

public class Bishop extends Piece {

    private static final double SCORE = 3;

    private static final String BLACK_DISPLAY = "♙";
    private static final String WHITE_DISPLAY = "♟";

    private final List<Direction> directions = Direction.getDiagonalDirection();

    public Bishop(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> getPositionsInPath(Position toPosition) {
        Direction direction = Direction.findDirection(position, toPosition);
        return direction.findPositionsInPath(position, toPosition);
    }

    @Override
    public void move(Position position) {
        validateMovable(position);
        this.position = position;
    }

    @Override
    public void validateMovable(Position toPosition) {
        if (!isMovablePosition(toPosition)) {
            throw new IllegalArgumentException(INVALID_MOVABLE_POSITION_EXCEPTION_MESSAGE);
        }
    }

    private boolean isMovablePosition(Position toPosition) {
        Direction targetDirection = Direction.findDirection(position, toPosition);
        return directions.contains(targetDirection);
    }

    @Override
    protected void attack(Position enemyPosition) {
        move(enemyPosition);
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
        if (color.isBlack()) {
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
