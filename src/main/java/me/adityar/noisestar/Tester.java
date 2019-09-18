/*
 * Tester.java
 * Copyright (C) 2019 Aditya Rathod. All rights reserved.
 */

package main.java.me.adityar.noisestar;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        World world = new World();
        Pathfinder finder = new Pathfinder();
        Position startPos = new Position(3, 0, 3);
        Node start = new Node(startPos);
        start.getPos().setY(world.getAboveGroundYPosition(startPos));
        Position endPos = new Position(7, 0, 13);
        Node end = new Node(endPos);
        end.getPos().setY(world.getAboveGroundYPosition(endPos));
        List<Node> path = finder.findPathAStar(world, start, end);
        System.out.println(path);
    }
}
