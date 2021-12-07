package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exception.OutOfRangeIndexException;
import nextstep.ladder.domain.ladder.size.LadderWidth;
import nextstep.ladder.domain.point.Point;
import nextstep.ladder.domain.rule.WayRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;
import static nextstep.ladder.utils.Validation.checkNotEmpty;
import static nextstep.ladder.utils.Validation.checkNotNull;

public class LadderLine {

    private static final int INDEX_UNIT = 1;
    private static final int MIN_INDEX = 0;

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        checkNotEmpty(points);
        this.points = points;
    }

    public static LadderLine of(LadderWidth width, WayRule wayRule) {
        checkNotNull(width, wayRule);
        List<Point> points = new ArrayList<>();

        Point first = Point.first(wayRule);
        points.add(first);

        List<Point> bodyPoints = bodyOf(width.bodyWidth(), first, wayRule);
        points.addAll(bodyPoints);

        Point endOfPoints = points.get(points.size() - INDEX_UNIT);
        points.add(endOfPoints.last());

        return new LadderLine(points);
    }

    private static List<Point> bodyOf(int bodySize, Point first, WayRule wayRule) {
        List<Point> bodyPoints = new ArrayList<>();
        Point previous = first;
        for (int currentSize = 0; currentSize < bodySize; currentSize++) {
            Point next = previous.next(wayRule);
            bodyPoints.add(next);
            previous = next;
        }
        return bodyPoints;
    }

    public int move(int startIndex) {
        checkRange(startIndex);
        Point targetPoint = points.get(startIndex);
        return targetPoint.move();
    }

    private void checkRange(int startIndex) {
        if (startIndex < MIN_INDEX || startIndex >= points.size()) {
            throw new OutOfRangeIndexException();
        }
    }

    public int width() {
        return points.size();
    }

    public List<Point> pointsExceptLast() {
        int endIndex = points.size() - INDEX_UNIT;
        return unmodifiableList(points.subList(MIN_INDEX, endIndex));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
