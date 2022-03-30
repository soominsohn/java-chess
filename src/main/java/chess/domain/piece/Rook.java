package chess.domain.piece;

import chess.domain.direction.Direction;
import chess.domain.position.Position;
import java.util.List;
import java.util.Objects;

public class Rook extends Piece {

    private static final double SCORE = 5;

    private static final String BLACK_DISPLAY = "♖";
    private static final String WHITE_DISPLAY = "♜";

    private final List<Direction> directions = Direction.getCrossDirection();

    public Rook(Color color, Position position) {
        super(color, position);
    }

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
        Rook rook = (Rook) o;
        return color == rook.color
            && position == rook.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, position);
    }

    @Override
    public String toString() {
        return "Rook{" +
            "color=" + color +
            ", position=" + position +
            '}';
    }

}
