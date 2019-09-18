/*
 * Pathfinder.java
 * Copyright (C) 2019 Aditya Rathod. All rights reserved.
 */

package main.java.me.adityar.noisestar;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Pathfinder {
    public List<Node> findPathAStar(World world, Node start, Node end) {
        LinkedList<Node> openList = new LinkedList<>();
        LinkedList<Node> closedList = new LinkedList<>();
        start.setG(0);
        start.setF(start.getG() + this.hCostEst(start, end));
        openList.add(start);

        while (!openList.isEmpty()) {
            Node curNode = openList.get(this.findLowestFIdx(openList));
            if (curNode.equals(end)) {
                return this.getPath(curNode);
            }

            openList.remove(curNode);
            closedList.add(curNode);

            for (Node neighbor : world.getNeighbors(curNode)) {
                if (closedList.contains(neighbor)) {
                    continue;
                }
                int tentGScore = curNode.getG() + this.getDistance(curNode, neighbor);

                if (!openList.contains(neighbor) || tentGScore < neighbor.getG()) {
                    neighbor.setParent(curNode);
                    neighbor.setG(tentGScore);
                    neighbor.setF(neighbor.getG() + this.hCostEst(neighbor, end));
                    if (!openList.contains(neighbor)) {
                        openList.add(neighbor);
                    }
                }
            }

        }
        // path not possible, we failed.
        return null;
    }

    private int hCostEst(Node a, Node b) {
        int basicDist = this.getDistance(a, b);
        int verticalCost = (b.getPos().getY() - a.getPos().getY()) / 2;
        return basicDist + verticalCost;
    }

    private int getDistance(Node a, Node b) {
        return (int) (
                Math.pow(b.getPos().getX() - a.getPos().getX(), 2) +
                        Math.pow(b.getPos().getZ() - a.getPos().getZ(), 2)
        );
    }

    private int findLowestFIdx(List<Node> nodes) {
        int lowestF = Integer.MAX_VALUE;
        int lowestFIdx = -1;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getF() < lowestF) {
                lowestF = nodes.get(i).getF();
                lowestFIdx = i;
            }
        }
        return lowestFIdx;
    }

    private List<Node> getPath(Node currentNode) {
        List<Node> path = new ArrayList<>();
        path.add(currentNode);
        Node parent;
        while ((parent = currentNode.getParent()) != null) {
            path.add(0, parent);
            currentNode = parent;
        }
        return path;
    }
}
