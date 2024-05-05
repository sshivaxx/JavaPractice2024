package ch.five;

import java.util.Date;
import java.util.Objects;
//3.4.22
public class T2HashCode {
    public static class Point2D {
        private final double x;
        private final double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static class Interval {
        private final double start;
        private final double end;

        public Interval(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public static class Interval2D {
        private final Interval xInterval;
        private final Interval yInterval;

        public Interval2D(Interval xInterval, Interval yInterval) {
            this.xInterval = xInterval;
            this.yInterval = yInterval;
        }

        @Override
        public int hashCode() {
            return Objects.hash(xInterval, yInterval);
        }
    }

    public static class CustomDate {
        private final Date date;

        public CustomDate(Date date) {
            this.date = date;
        }

        @Override
        public int hashCode() {
            return Objects.hash(date);
        }
    }
}
