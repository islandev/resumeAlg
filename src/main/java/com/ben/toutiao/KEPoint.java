package com.ben.toutiao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KEPoint {
    static class Point {
        double x;
        double y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    List<Point> filterPoint(List<Point> srcPoints) {
        List<Point> dstPoints = new ArrayList<Point>();
        dstPoints.add(srcPoints.get(0));
        for (int i = 1; i < srcPoints.size() - 1; i++) {
            int ccw = ccw(srcPoints.get(i - 1), srcPoints.get(i), srcPoints.get(i + 1));
            if (ccw == 1) {
                dstPoints.add(srcPoints.get(i));
            } else if (ccw == 0) {
                i++;
            } else {
                srcPoints.remove(i);
                i--;
            }
        }
        return dstPoints;
    }

    static int ccw(Point a, Point b, Point c) {

        double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area > 0) return 1;
        else if (area < 0) return -1;
        else return 0;
    }

    static List<Point> sortPoint(List<Point> srcPoint) {
        List<Point> dstList = new ArrayList<Point>();
        srcPoint.stream().min(Comparator.comparingDouble(o -> o.y)).ifPresent(dstList::add);
        Point o = dstList.get(0);
        srcPoint.remove(o);
        srcPoint.stream().sorted(Comparator.comparingDouble())

        return dstList;
    }


    public static void main(String[] args) {
        List<Point> a = new ArrayList<Point>();
        a.add(new Point(7, 7));
        a.add(new Point(7, -7));
        a.add(new Point(-7, -7));
        a.add(new Point(7, -7));
        a.add(new Point(9, 0));
        a.add(new Point(-9, 0));
        a.add(new Point(0, 9));
        a.add(new Point(0, -9));
    }


}
