import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
    public class binaryTreeTests extends Assertions {
        @Test
        public void insert_addsNewValue_valueIsFound() {
            binaryTree tree = new binaryTree();

            tree.insert( "3");

            assertEquals("3", tree.search("3"));
        }

        @Test
        public void Min_findsMinOfTree_returnsMin() {
            binaryTree tree = new binaryTree();

            tree.insert( "a");
            tree.insert( "ab");
            tree.insert( "c");
            tree.insert( "aaa");


            assertEquals("a", tree.Min(tree.root));
        }

        @Test
        public void Max_findsMaxOfTree_returnsMax() {
            binaryTree tree = new binaryTree();

            tree.insert( "aaa");
            tree.insert( "aab");
            tree.insert( "abb");
            tree.insert( "abc");


            assertEquals("abc", tree.Max(tree.root));
        }
        @Test
        public void getSucc_findsSucOf1bc_sucEquals2cd() {
            binaryTree tree = new binaryTree();

            tree.insert( "1bc");
            tree.insert( "2cd");
            tree.insert( "ertgf");
            tree.insert( "4gess");


            assertEquals("2cd", tree.getSucc(tree.root, "1bc").key);
        }
        @Test
        public void getPred_findsPredOf2cd_predEquals1bc() {
            binaryTree tree = new binaryTree();

            tree.insert( "1bc");
            tree.insert( "2cd");
            tree.insert( "ertgf");
            tree.insert( "4gess");


            assertEquals("1bc", tree.getPredShell(tree.root, "2cd").key);
        }
        @Test
        public void de2lete_delete10_10NotFound() {
            binaryTree tree = new binaryTree();

            tree.insert( "3");
            tree.insert( "2");
            tree.insert( "1");
            tree.insert( "10");
            tree.insert( "4");
            tree.de2lete("10");


            assertEquals(null, tree.search("10"));
        }


    }

