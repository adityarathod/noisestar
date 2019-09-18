/*
 * World.java
 * Copyright (C) 2019 Aditya Rathod. All rights reserved.
 */

package main.java.me.adityar.noisestar;

import java.util.List;
import java.util.LinkedList;

public class World {
    private final int xLength = 30;
    private final int zLength = 30;
    private final int[][] worldMap = {
            {16, 2, 12, 26, 18, 18, 31, 47, 35, 31, 28, 5, 8, 2, 3, 48, 31, 22, 7, 24, 9, 10, 29, 42, 12, 39, 46, 42, 2, 18},
            {5, 41, 33, 25, 22, 34, 21, 28, 36, 49, 7, 23, 3, 4, 45, 26, 21, 32, 20, 50, 30, 17, 24, 28, 31, 23, 37, 6, 47, 20},
            {4, 1, 49, 32, 50, 23, 27, 49, 45, 48, 23, 15, 13, 40, 28, 23, 36, 22, 23, 19, 21, 44, 28, 11, 13, 41, 13, 30, 26, 37},
            {38, 28, 21, 46, 49, 40, 30, 32, 31, 39, 9, 29, 46, 42, 3, 2, 39, 29, 41, 41, 1, 11, 31, 17, 44, 36, 23, 39, 10, 3},
            {42, 44, 17, 40, 21, 6, 49, 46, 32, 24, 6, 50, 1, 34, 16, 2, 19, 8, 16, 8, 27, 40, 14, 23, 46, 26, 41, 9, 13, 12},
            {41, 36, 26, 14, 13, 39, 14, 27, 18, 7, 45, 32, 15, 8, 29, 28, 49, 28, 39, 1, 1, 46, 14, 48, 19, 46, 44, 12, 30, 12},
            {38, 27, 19, 26, 15, 11, 7, 8, 47, 47, 47, 3, 42, 36, 2, 7, 6, 21, 30, 40, 9, 40, 34, 32, 8, 11, 31, 21, 2, 5},
            {50, 1, 14, 41, 46, 22, 22, 7, 20, 5, 12, 19, 34, 35, 29, 22, 46, 21, 47, 19, 36, 2, 29, 6, 22, 24, 42, 8, 15, 43},
            {25, 10, 5, 30, 34, 41, 41, 44, 38, 11, 10, 14, 37, 36, 1, 34, 30, 44, 48, 7, 20, 30, 32, 37, 21, 30, 19, 28, 38, 23},
            {21, 45, 11, 17, 19, 19, 20, 46, 31, 25, 38, 15, 17, 35, 40, 12, 48, 39, 17, 45, 49, 43, 44, 43, 5, 34, 9, 49, 24, 33},
            {25, 21, 38, 1, 38, 4, 17, 21, 35, 42, 3, 39, 16, 37, 24, 27, 33, 19, 38, 6, 29, 50, 23, 49, 15, 13, 7, 48, 38, 48},
            {30, 7, 27, 23, 27, 2, 1, 42, 41, 12, 17, 35, 22, 13, 35, 5, 1, 5, 33, 45, 6, 36, 4, 49, 10, 34, 4, 49, 9, 9},
            {1, 28, 14, 16, 17, 24, 2, 43, 29, 3, 7, 46, 5, 18, 41, 28, 2, 34, 24, 14, 27, 41, 4, 38, 22, 22, 25, 13, 45, 6},
            {6, 18, 25, 48, 29, 19, 12, 41, 47, 50, 33, 13, 34, 23, 36, 44, 24, 44, 34, 23, 28, 41, 8, 37, 41, 22, 25, 5, 36, 47},
            {30, 3, 13, 48, 39, 38, 10, 39, 33, 21, 43, 13, 33, 12, 45, 38, 47, 10, 24, 5, 40, 33, 49, 37, 24, 17, 8, 13, 16, 18},
            {50, 37, 1, 47, 28, 10, 9, 26, 29, 10, 18, 24, 27, 8, 45, 10, 28, 9, 30, 21, 46, 28, 42, 17, 28, 33, 47, 26, 47, 49},
            {47, 31, 20, 46, 36, 38, 40, 5, 15, 17, 30, 23, 6, 9, 48, 23, 47, 8, 4, 6, 26, 33, 39, 17, 15, 37, 32, 27, 46, 35},
            {13, 18, 30, 50, 32, 15, 47, 24, 18, 10, 6, 15, 49, 24, 4, 21, 22, 13, 27, 29, 29, 25, 29, 23, 27, 6, 37, 23, 36, 8},
            {17, 45, 17, 20, 13, 19, 7, 44, 7, 9, 33, 1, 39, 45, 47, 38, 40, 17, 44, 7, 5, 43, 27, 9, 31, 25, 8, 29, 3, 6},
            {1, 4, 5, 30, 5, 18, 5, 41, 16, 37, 22, 26, 2, 30, 49, 10, 42, 31, 12, 34, 35, 24, 1, 21, 24, 12, 18, 48, 34, 18},
            {2, 26, 20, 49, 3, 13, 2, 9, 46, 32, 33, 5, 32, 29, 19, 5, 4, 19, 9, 19, 40, 2, 50, 22, 19, 34, 46, 20, 43, 28},
            {10, 24, 50, 35, 6, 31, 17, 40, 25, 15, 44, 21, 11, 29, 37, 35, 29, 4, 16, 7, 6, 38, 47, 37, 39, 24, 7, 20, 3, 40},
            {22, 46, 20, 23, 20, 26, 31, 3, 12, 32, 28, 28, 7, 10, 37, 46, 21, 49, 26, 37, 30, 15, 12, 49, 14, 26, 17, 49, 22, 43},
            {13, 13, 29, 16, 29, 1, 28, 21, 16, 41, 34, 6, 27, 11, 15, 20, 37, 43, 38, 7, 14, 10, 5, 1, 38, 4, 39, 36, 50, 2},
            {38, 36, 38, 46, 5, 44, 40, 37, 14, 26, 44, 21, 22, 49, 35, 26, 41, 39, 37, 41, 47, 25, 27, 24, 15, 24, 9, 26, 20, 6},
            {47, 28, 1, 42, 1, 23, 26, 37, 28, 50, 31, 26, 38, 18, 23, 3, 17, 12, 3, 11, 14, 19, 18, 16, 15, 2, 41, 6, 40, 29},
            {29, 17, 28, 13, 13, 19, 3, 23, 4, 27, 31, 20, 3, 18, 31, 1, 11, 18, 9, 10, 18, 11, 42, 28, 38, 14, 5, 15, 24, 18},
            {49, 19, 31, 23, 32, 50, 6, 31, 12, 12, 44, 47, 49, 26, 5, 25, 16, 37, 9, 14, 38, 24, 28, 27, 12, 26, 5, 14, 49, 4},
            {33, 16, 42, 22, 9, 18, 1, 27, 18, 3, 30, 14, 30, 47, 39, 22, 47, 49, 37, 28, 34, 22, 32, 45, 3, 48, 47, 1, 4, 28},
            {42, 28, 8, 13, 42, 24, 35, 12, 1, 3, 10, 29, 38, 11, 47, 38, 3, 8, 14, 18, 13, 27, 49, 8, 46, 16, 18, 47, 38, 22}
    };

    public int getAboveGroundYPosition(Position p) {
        return this.worldMap[p.getZ()][p.getX()];
    }

    public List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new LinkedList<>();
        Position nodePos = node.getPos();

        boolean canGoRight = nodePos.getX() + 1 < xLength;
        boolean canGoLeft = nodePos.getX() - 1 >= 0;
        boolean canGoDown = nodePos.getZ() + 1 < zLength;
        boolean canGoUp = nodePos.getZ() - 1 >= 0;

        if (canGoRight) {
            Position rightPos = new Position(nodePos.getX() + 1, 0, nodePos.getZ());
            rightPos.setY(this.getAboveGroundYPosition(rightPos));
            neighbors.add(new Node(rightPos));
            if (canGoDown) {
                Position drPos = new Position(nodePos.getX() + 1, 0, nodePos.getZ() + 1);
                drPos.setY(this.getAboveGroundYPosition(drPos));
                neighbors.add(new Node(drPos));
            }
            if (canGoUp) {
                Position urPos = new Position(nodePos.getX() + 1, 0, nodePos.getZ() - 1);
                urPos.setY(this.getAboveGroundYPosition(urPos));
                neighbors.add(new Node(urPos));
            }
        }
        if (canGoLeft) {
            Position leftPos = new Position(nodePos.getX() - 1, 0, nodePos.getZ());
            leftPos.setY(this.getAboveGroundYPosition(leftPos));
            neighbors.add(new Node(leftPos));
            if (canGoDown) {
                Position dlPos = new Position(nodePos.getX() - 1, 0, nodePos.getZ() + 1);
                dlPos.setY(this.getAboveGroundYPosition(dlPos));
                neighbors.add(new Node(dlPos));
            }
            if (canGoUp) {
                Position ulPos = new Position(nodePos.getX() - 1, 0, nodePos.getZ() - 1);
                ulPos.setY(this.getAboveGroundYPosition(ulPos));
                neighbors.add(new Node(ulPos));
            }
        }

        if (canGoDown) {
            Position downPos = new Position(nodePos.getX(), 0, nodePos.getZ() + 1);
            downPos.setY(this.getAboveGroundYPosition(downPos));
            neighbors.add(new Node(downPos));
        }

        if (canGoUp) {
            Position upPos = new Position(nodePos.getX(), 0, nodePos.getZ() - 1);
            upPos.setY(this.getAboveGroundYPosition(upPos));
            neighbors.add(new Node(upPos));
        }

        return neighbors;

    }
}
