package chess.controller;

import chess.domain.Board;
import chess.domain.Position;
import chess.domain.piece.Piece;
import chess.domain.piece.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static spark.Spark.get;
import static spark.Spark.post;

public class WebChessController implements ChessController {
    @Override
    public void run() {
        Board board = new Board();
        AtomicReference<String> message = new AtomicReference<>("");
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        get("/status", "application/json", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("pieces", printChessBoard(board));
            model.put("score", getScore(board));
            return model;
        }, new JsonTransformer());

        post("/move", (req, res) -> {
            try {
                board.movePiece(new Position(req.queryParams("source")), new Position(req.queryParams("destination")));
                if (!board.isBothKingAlive()) {
                    return board.getWinner().getName() + "이 승리했습니다!";
                }
                return "";
            } catch (Exception e) {
                res.status(403);
                return e.getMessage();
            }
        });
    }

    private Map<String, Piece> printChessBoard(Board board) {
        Map<String, Piece> model = new HashMap<>();
        for (Piece piece : board.getPieces().getAlivePieces()) {
            model.put(piece.getPosition().toString(), piece);
        }
        return model;
    }

    private Map<String, Double> getScore(Board board) {
        Map<String, Double> score = new HashMap<>();
        score.put("blackScore", board.calculateScoreByTeam(Team.BLACK));
        score.put("whiteScore", board.calculateScoreByTeam(Team.WHITE));
        return score;
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
