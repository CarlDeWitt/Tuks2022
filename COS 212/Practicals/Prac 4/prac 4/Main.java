///**
// * Name:
// *
// * Student Number:
// */
//
///**
// * A note on testing:
// *
// * This Main takes a different approach to testing. Previously we printed
// * information to STDOUT and verified the results manually.
// *
// * This Main uses a very simple testing framework, implemented in the Main class
// * itself. It provides a structure for testing and validates the results at run
// * time.
// *
// * This provides the following advantages:
// *
// * - Regression testing - Often as you try to fix one bug, you introduce another
// * bug somewhere else. Using this Main (or a proper unit testing framework such
// * as TestNG) you can be sure that old functions still work as intended after
// * refactoring.
// *
// * - Quick and easy validation - The framework will give a summary, indicating
// * if all test passed. This saves time and effort as validation is done by the
// * framework and not by a fallible human eye (of course, the tests also need to
// * be correct, otherwise you will be implementing the wrong functionality
// * correctly).
// *
// * - Understanding of specs and requirements - Your understanding will be tested
// * by writing the test cases first. It it much easier to fix the test cases and
// * a tree on pen and paper, than it is to fix the tree implementation.
// *
// * You may use the provided framework (can be modified to suit your needs) or
// * your own way of testing. This is just an example of an alternative way of
// * testing.
// */
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        // NOTE: this Main only tests two of the many cases.
//        // You are advised to write your own comprehensive test cases.
//
//        SplayTree<Integer> tree = new SplayTree<>();
//
//        startTestCase("Create tree with 'ZIG' structure");
//        // Tests the insert function
//
//        tree.insert(20);
//        tree.insert(10);
//        tree.insert(30);
//        tree.insert(5);
//        tree.insert(15);
//
////        tree.printLevelOrder();
//
//        assertEquals(tree.root.key, 20);
//        assertEquals(tree.root.right.key, 30);
//        assertEquals(tree.root.left.key, 10);
//        assertEquals(tree.root.left.left.key, 5);
//        assertEquals(tree.root.left.right.key, 15);
//
//        endTestCase();
//
//        startTestCase("Splaying 'ZIG' case");
//        // Tests the access function
//        tree.access(10);
//
//        assertEquals(tree.root.key, 10);
//        assertEquals(tree.root.left.key, 5);
//        assertEquals(tree.root.right.key, 20);
//        assertEquals(tree.root.right.left.key, 15);
//        assertEquals(tree.root.right.right.key, 30);
//
//        endTestCase();
//    }
//
//    public static Integer testCounter = 0;
//    public static Integer testsPassed = 0;
//    public static String currentTestCaseName = "";
//
//    /**
//     * Start a new test case. All future asserts will now be part of this case.
//     */
//    public static void startTestCase(String name) {
//        currentTestCaseName = name;
//        testCounter = 0;
//        testsPassed = 0;
//
//        System.out.println("=========================");
//        System.out.println("CASE: " + currentTestCaseName);
//        System.out.println("_________________________");
//    }
//
//    /**
//     * End the current test case and print a summary
//     */
//    public static void endTestCase() {
//        System.out.println("_________________________");
//        System.out.println("SUMMARY:");
//        if (testCounter == testsPassed) {
//            System.out.println("PASS");
//        } else {
//            System.out.println("FAIL");
//        }
//        System.out.println("Passed " + testsPassed + "/" + testCounter + " assertions");
//
//        testCounter = 0;
//        testsPassed = 0;
//        currentTestCaseName = "";
//    }
//
//    /**
//     * Asserts that the "actual" object is equal to the "expected" object NOTE: Does
//     * not work for asserting null due to .toString()
//     */
//    public static void assertEquals(Object actual, Object expected) {
//        testCounter++;
//
//        if (!actual.equals(expected)) {
//            System.out.println("Assert " + testCounter + ": FAIL");
//            System.out.println("\tExpected " + expected.toString() + ". Receieved " + actual.toString());
//        } else {
//            System.out.println("Assert " + testCounter + ": PASS");
//            testsPassed++;
//
//        }
//    }
//}
//
///** Expected output
// * =========================
// * CASE: Create tree with 'ZIG' structure
// * _________________________
// * Assert 1: PASS
// * Assert 2: PASS
// * Assert 3: PASS
// * Assert 4: PASS
// * Assert 5: PASS
// * _________________________
// * SUMMARY:
// * PASS
// * Passed 5/5 assertions
// * =========================
// * CASE: Splaying 'ZIG' case
// * _________________________
// * Assert 1: PASS
// * Assert 2: PASS
// * Assert 3: PASS
// * Assert 4: PASS
// * Assert 5: PASS
// * _________________________
// * SUMMARY:
// * PASS
// * Passed 5/5 assertions
// */

/*
  Name: Evert
  DISCLAIMER: Some of this code was taken from the provided main.
  I do not claim ownership of that code at all.
 */

public class Main
{
    /*==============================================================================
                                        MAIN
    ==============================================================================*/
//------------------------------------------------------------------------[main]
    public static void main( String[] args )
    {   //disclaimer();
//        null_tetsing();
        zig_Test();
        containsTest();
        predecessorTest();

        zigzig_Test();
        zigzag_Test();

        zag_Test();

        zagzig_Test();
        zagzag_Test();
        zigzag_TestC();
    }

    private static void null_tetsing() {
        SplayTree<Integer> tree = new SplayTree<>();
//        System.out.println(tree.access(5));
        System.out.println(tree.findPredecessor(5));
        System.out.println(tree.contains(5));
    }

    /*==============================================================================
                                  CASE TEST FUNCTIONS
    ==============================================================================*/
//--------------------------------------------------------------------[zig_Test]
    public static void zig_Test()
    {
        SplayTree<Integer> tree = new SplayTree<>();

        testStart( "Creating 'ZIG' structure tree" );

        // Tests the insert function
        tree.insert( 20 );
        tree.insert( 10 );
        tree.insert( 30 );
        tree.insert( 5 );
        tree.insert( 15 );

        assertEquals( tree.root.key, 20 );
        assertEquals( tree.root.right.key, 30 );
        assertEquals( tree.root.left.key, 10 );
        assertEquals( tree.root.left.left.key, 5 );
        assertEquals( tree.root.left.right.key, 15 );

        testEnd();
        System.out.println();

        testStart( "Splaying 'ZIG' test case" );
        System.out.println("Accessing '10': ");

        tree.access( 10 );

        assertEquals( tree.root.key, 10 );
        assertEquals( tree.root.left.key, 5 );
        assertEquals( tree.root.right.key, 20 );
        assertEquals( tree.root.right.left.key, 15 );
        assertEquals( tree.root.right.right.key, 30 );

        testEnd();
    }

    //-----------------------------------------------------------------[zigzig_Test]
    public static void zigzig_Test()
    {
        SplayTree<Integer> tree = new SplayTree<>();

        testStart( "'ZIG-ZIG' access splaying" );

        tree.insert( 20 );
        tree.insert( 10 );
        tree.insert( 30 );
        tree.insert( 5 );
        tree.insert( 15 );

        System.out.println("Accessing '5': ");

        tree.access( 5 );

        assertEquals( tree.root.key, 5 );
        assertEquals( tree.root.right.key, 10 );
        assertEquals( tree.root.right.right.key, 20 );
        assertEquals( tree.root.right.right.left.key, 15 );
        assertEquals( tree.root.right.right.right.key, 30 );

        testEnd();
    }

    //-----------------------------------------------------------------[zigzag_Test]
    public static void zigzag_Test()
    {
        SplayTree<Integer> tree = new SplayTree<>();

        testStart( "'ZIG-ZAG' access splaying" );

        tree.insert( 20 );
        tree.insert( 10 );
        tree.insert( 30 );
        tree.insert( 5 );
        tree.insert( 15 );

        System.out.println("Accessing '15': ");

        tree.access( 15 );

        assertEquals( tree.root.key, 15 );
        assertEquals( tree.root.right.key, 20 );
        assertEquals( tree.root.right.right.key, 30 );
        assertEquals( tree.root.left.key, 10 );
        assertEquals( tree.root.left.left.key, 5 );

        testEnd();
    }

    //--------------------------------------------------------------------[zigZag Carl]
    public static void zigzag_TestC()
    {
        SplayTree<Integer> tree = new SplayTree<>();

        testStart( "'ZIG-ZAG' access splaying" );

        tree.insert( 20 );
        tree.insert( 5 );
        tree.insert( 30 );
        tree.insert( 25 );
        tree.insert( 22 );
        tree.insert( 27 );
        tree.insert( 35 );

        System.out.println("Accessing '25': ");

               tree.access( 25 );

        assertEquals( tree.root.key, 25 );
        assertEquals( tree.root.right.key, 30 );
        assertEquals( tree.root.right.right.key, 35 );
        assertEquals( tree.root.right.left.key, 27 );
        assertEquals( tree.root.left.key, 20 );
        assertEquals( tree.root.left.right.key, 22 );
        assertEquals( tree.root.left.left.key, 5 );

        testEnd();
    }

    //--------------------------------------------------------------------[Zigzag_Test]
    public static void zag_Test()
    {
        SplayTree<Integer> tree = new SplayTree<>();

        testStart( "Creating 'ZAG' structure tree" );

        // Tests the insert function
        tree.insert( 10 );
        tree.insert( 5 );
        tree.insert( 20 );
        tree.insert( 15 );
        tree.insert( 30 );

        assertEquals( tree.root.key, 10 );
        assertEquals( tree.root.right.key, 20 );
        assertEquals( tree.root.left.key, 5 );
        assertEquals( tree.root.right.left.key, 15 );
        assertEquals( tree.root.right.right.key, 30 );

        testEnd();
        System.out.println();
    }

    //-----------------------------------------------------------------[zagzig_Test]
    public static void zagzig_Test()
    {
        SplayTree<Integer> tree = new SplayTree<>();

        testStart( "'ZAG-ZIG' access splaying" );

        // Tests the insert function
        tree.insert( 10 );
        tree.insert( 5 );
        tree.insert( 20 );
        tree.insert( 15 );
        tree.insert( 30 );

        System.out.println("Accessing '15':");

        tree.access( 15 );

        assertEquals( tree.root.key, 15 );
        assertEquals( tree.root.left.key, 10 );
        assertEquals( tree.root.right.key, 20 );
        assertEquals( tree.root.left.left.key, 5 );
        assertEquals( tree.root.right.right.key, 30 );

        testEnd();
    }

    //-----------------------------------------------------------------[zagzag_Test]
    public static void zagzag_Test()
    {
        SplayTree<Integer> tree = new SplayTree<>();

        testStart( "'ZAG-ZAG' access splaying" );

        // Tests the insert function
        tree.insert( 10 );
        tree.insert( 5 );
        tree.insert( 20 );
        tree.insert( 15 );
        tree.insert( 30 );

        System.out.println("Accessing '30':");

        tree.access( 30 );

        assertEquals( tree.root.key, 30 );
        assertEquals( tree.root.left.key, 20 );
        assertEquals( tree.root.left.left.key, 10 );
        assertEquals( tree.root.left.left.left.key, 5 );
        assertEquals( tree.root.left.left.right.key, 15 );

        testEnd();
    }

    //-------------------------------------------------------------[predecessorTest]
    public static void predecessorTest()
    {
        SplayTree<Integer> tree = new SplayTree<>();

        testStart( "Getting node predecessors" );

        // Tests the insert function
        tree.insert( 20 );
        tree.insert( 10 );
        tree.insert( 30 );
        tree.insert( 5 );
        tree.insert( 15 );
//        tree.findPredecessor(20);

        assertEquals( tree.findPredecessor( 20 ), 15 );
        assertEquals( tree.findPredecessor( 10 ), 5 );
        assertEquals( tree.findPredecessor( 30 ), 20 );
        assertEquals( tree.findPredecessor( 15 ), 10 );


        Integer pred = tree.findPredecessor( 5 );
        if ( pred == null )
            pred = 0;
        assertEquals( pred, 0 );


        testEnd();
    }

    //----------------------------------------------------------------[containsTest]
    public static void containsTest()
    {
        SplayTree<Integer> tree = new SplayTree<>();

        testStart( "Contains" );

        // Tests the insert function
        tree.insert( 20 );
        tree.insert( 10 );
        tree.insert( 30 );
        tree.insert( 5 );
        tree.insert( 15 );

        assertEquals( tree.contains(10), true );
        assertEquals( tree.contains( 30 ), true );
        assertEquals( tree.contains( 20 ), true );
        assertEquals( tree.contains( 17 ), false );
        assertEquals( tree.contains( 9999 ), false );

        testEnd();
    }

    /*==============================================================================
                                    MISC FUNCTIONS
    ==============================================================================*/
    public static Integer testCounter = 0;
    public static Integer testsPassed = 0;
    public static String currentTestCaseName = "";

    //-------------------------------------------------------------------[testStart]
// Taken and edited from provided main
    public static void testStart( String name )
    {
        currentTestCaseName = name;
        testCounter = 0;
        testsPassed = 0;

        System.out.println( "============================================================" );
        System.out.println( "TEST: " + currentTestCaseName );
        System.out.println( "============================================================" );
    }

    //---------------------------------------------------------------------[testEnd]
// Taken and edited from provided main
    public static void testEnd()
    {
        System.out.println( "------------------------------------------------------------" );
        System.out.println( "SUMMARY:" );
        if ( testCounter.equals( testsPassed ) )
        {
            System.out.println( "PASS" );
        }
        else
        {
            System.out.println( "FAIL" );
        }
        System.out.println(
                "Passed " + testsPassed + "/" + testCounter + " assertions" );

        System.out.println();

        testCounter = 0;
        testsPassed = 0;
        currentTestCaseName = "";
    }

    //----------------------------------------------------------------[assertEquals]
// Taken and edited from provided main
    public static void assertEquals( Object actual, Object expected )
    {
        testCounter++;

        if ( !actual.equals( expected ) )
        {
            System.out.println( "Assert " + testCounter + ": FAIL" );
            System.out.println(
                    "\tExpected " + expected.toString() + ". Received " + actual.toString() );
        }
        else
        {
            System.out.println( "Assert " + testCounter + ": PASS" );
            testsPassed++;
        }
    }

    /*==============================================================================
                                      DISCLAIMER
    ==============================================================================*/
//------------------------------------------------------------------[disclaimer]
    public static void disclaimer()
    {
        System.out.println(
                "######################################################################\n\n" +
                        "DISCLAIMER: Some of this code was taken from the provided main.\n" +
                        "I do not claim ownership of those codesnippets\n" +
                        "\n100% Success for the main does not guarantee full marks on fitchfork\n" +
                        "May fitchfork be with you. Good luck\n\n" +
                        "######################################################################"
        );
    }
}

