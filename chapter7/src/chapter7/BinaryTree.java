package chapter7;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class BinaryTree
{
   TreeNode root;
   public BinaryTree()
   {
       root = null;
   }
   public boolean insert (StudentListing newStudentListing) {
       TreeNodeWrapper p = new TreeNodeWrapper();
       TreeNodeWrapper c = new TreeNodeWrapper();
       TreeNode n = new TreeNode();
       if (n == null) // Checking for sufficient memory
           return false;
       else {
           n.node = newStudentListing.deepCopy();
           n.lc = null; // Node's left child
           n.rc = null; // Node's right child
           if (root == null) {
               root = n;
           } else {
               boolean node = findNode(newStudentListing.getKey(), p, c); // Compare keys and assign to left child or right child
               if (newStudentListing.getKey().compareTo(p.get().node.getKey()) < 0)
                   p.get().lc = n;
               else
                   p.get().rc = n;
           }
           return true;
       }
   }
   public StudentListing fetch(String targetKey) {
       boolean found;
       TreeNodeWrapper p = new TreeNodeWrapper();
       TreeNodeWrapper c = new TreeNodeWrapper();
       found = findNode(targetKey, p, c);
       if (found == true) // Find the node
           return c.get().node.deepCopy(); // Copy the node
       else
           return null;
   }
   public boolean delete(String targetKey)
       { boolean found;
       TreeNodeWrapper p = new TreeNodeWrapper();
       TreeNodeWrapper c = new TreeNodeWrapper();
       TreeNode largest;
       TreeNode nextLargest;
       found = findNode(targetKey, p, c);
       if (found == false) // Return false if node not found
           return false;
       else
           { if (c.get().lc == null && c.get().rc == null) // Deleted node has no children
           { if (p.get().lc == c.get())
                   p.get().lc = null;
               else
                   p.get().rc = null;
           }
           else if (c.get().lc == null || c.get().rc == null) // Deleted node has one child
           {
               if (p.get().lc == c.get()) {
                   if (c.get().lc != null)
                       p.get().lc = c.get().lc;
                   else
                       p.get().rc = c.get().rc;
               } else {
                   if (c.get().lc != null)
                       p.get().rc = c.get().lc;
                   else
                       p.get().rc = c.get().rc;
               }
           }
           else // Deleted node has two children
           { nextLargest = c.get().lc; //
                   largest = nextLargest.rc;
                   if (largest != null) {
                       while (largest.rc != null) {
                           nextLargest = largest;
                           largest = largest.rc;
                       }
                       c.get().node = largest.node;
                       nextLargest.rc = c.get().rc;
                   }
                   else {
                       nextLargest.rc = c.get().rc;
                       if (p.get().lc == c.get())
                           p.get().lc = nextLargest;
                       else
                           p.get().rc = nextLargest;
                   }
               }
               return true;
           }
       }
   public boolean update (String targetKey, StudentListing newStudentListing)
   { if (delete(targetKey) == false) // Return false if node not found
           return false;
       else if (insert(newStudentListing) == false) // Return false for insufficient memory
           return false;
       return true;
   }
   public class TreeNode
   {
       private StudentListing node;
       private TreeNode lc;
       private TreeNode rc;
       public TreeNode()
       {

       }
   }
   private boolean findNode(String targetKey, TreeNodeWrapper parent, TreeNodeWrapper child) {
       parent.set(root);
       child.set(root);
       if (root == null) // Check for empty tree
           return true;
       // While loop to iteratively search the tree and return the location of the node containing the targetKey and its parent node
       while (child.get() != null) // Check for empty tree
       {
           if (child.get().node.compareTo(targetKey) == 0)
               return true;
           else {
               parent.set(child.get());
               if (targetKey.compareTo(child.get().node.getKey()) < 0)
                   child.set(child.get().lc);
               else
                   child.set(child.get().rc);
           }
       }
       return false;
   }
    public class TreeNodeWrapper // // Wrapper class created to modify the items that the parameters reference in the findNode method
    {
        TreeNode treeRef = null;
        public TreeNodeWrapper()
        {
        }
        public TreeNode get()
        {
            return treeRef;
        }
        public void set(TreeNode t)
        {
            treeRef = t;
        }
    }


}
