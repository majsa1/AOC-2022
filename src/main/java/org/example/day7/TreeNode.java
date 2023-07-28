package org.example.day7;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreeNode {

    private static final Logger LOGGER = Logger.getLogger(TreeNode.class.getName());

    private final TreeNode parent;
    private final String name;
    private int size;
    private boolean isLeaf;
    private Set<TreeNode> nodes;

    public TreeNode(TreeNode parent, String name) {
        this.parent = parent;
        this.name = name;
        this.isLeaf = true;
    }

    public TreeNode(TreeNode parent, String name, int size) {
        this(parent, name);
        this.size = size;
    }

    public TreeNode(TreeNode parent, String name, boolean isLeaf) {
        this(parent, name);
        this.isLeaf = isLeaf;
    }

    public TreeNode getParent() {
        return this.parent;
    }

    public String getName() {
        return name;
    }

    public int getSize(TreeNode node) {
        if (isLeaf) {
            return node.size;
        }
        node.size = 0;
        for (TreeNode nd : node.nodes) {
            node.size += nd.getSize(nd);
        }
        return node.size;
    }

    public boolean getIsLeaf() {
        return isLeaf;
    }

    public Set<TreeNode> getNodes() {
        if (isLeaf) {
            LOGGER.log(Level.INFO, "{0} is a file", this.name);
            return Collections.emptySet();
        }
        return nodes;
    }

    public void addToNodes(TreeNode node) {
        if (this.nodes == null) {
            this.nodes = new HashSet<>();
            this.isLeaf = false;
        }
        this.nodes.add(node);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", isLeaf=" + isLeaf +
                ", nodes=" + nodes +
                '}';
    }
}
