import org.example.day7.Day7;
import org.example.day7.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Day7Test {
    private TreeNode nodes;

    private TreeNode dirA;
    private TreeNode dirB;
    private TreeNode fileB;

    @Before
    public void getNodes() {
        nodes = new TreeNode(null, "home", false);
        dirA = new TreeNode(nodes, "dirA", false);
        nodes.addToNodes(dirA);
        TreeNode fileA = new TreeNode(dirA, "fileA", 100);
        dirA.addToNodes(fileA);

        dirB = new TreeNode(dirA, "dirB", false);
        dirA.addToNodes(dirB);
        fileB = new TreeNode(dirB, "fileB", 200);
        TreeNode fileX = new TreeNode(dirB, "fileX", 300);
        dirB.addToNodes(fileB);
        dirB.addToNodes(fileX);
    }

    @Test
    public void testGetSizeForFolders() {
        Assert.assertEquals(600, dirA.getSize(dirA));
    }

    @Test
    public void testGetSizeForSingleFolder() {
        Assert.assertEquals(500, dirB.getSize(dirB));
    }

    @Test
    public void testGetSizeForFile() {
        Assert.assertEquals(200, fileB.getSize(fileB));
    }

    @Test
    public void testGetTotalSize() {
        Assert.assertEquals(600, nodes.getSize(nodes));
    }

    @Test
    public void testGetDirectoriesUnder100000() {
        Day7 day7 = new Day7();
        Assert.assertEquals(1100, day7.getDirectorySizeUnder100000(nodes));
    }
}
