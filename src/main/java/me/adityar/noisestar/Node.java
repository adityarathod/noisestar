/*
 * Node.java
 * Copyright (C) 2019 Aditya Rathod. All rights reserved.
 */

package main.java.me.adityar.noisestar;

import java.util.Objects;

public class Node {
    private int f;
    private int g;
    private int h;
    private Position pos;
    private Node parent;

    public Node(Position pos) {
        this.pos = pos;
        this.parent = null;
    }

    public Node(Node other) {
        this.f = other.getF();
        this.g = other.getG();
        this.h = other.getH();
        this.pos = other.getPos();
        this.parent = other.getParent();
    }

    public Node(Position pos, Node parent) {
        this.pos = pos;
        this.parent = parent;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return pos.equals(node.pos);
    }

    @Override
    public String toString() {
        return "Node{" +
//                "f=" + f +
//                ", g=" + g +
//                ", h=" + h +
                "pos=" + pos +
                '}';
    }
}
