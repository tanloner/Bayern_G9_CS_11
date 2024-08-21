package recursion.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class FamilyTreeTest {
    private FamilyTree familyTree;
    private FamilyTree child1;

    @Before
    public void setUp() {
        familyTree = new FamilyTree("John", 80);
        child1 = new FamilyTree("Jane", 50);
        FamilyTree child2 = new FamilyTree("Jack", 45);
        FamilyTree grandchild1 = new FamilyTree("Jill", 25);
        FamilyTree grandchild2 = new FamilyTree("Joe", 20);
        FamilyTree grandchild3 = new FamilyTree("Jenny", 18);
        FamilyTree grandchild4 = new FamilyTree("Jerry", 15);
        child1.addChild(grandchild1);
        child2.addChild(grandchild2);
        child2.addChild(grandchild3);
        child2.addChild(grandchild4);
        familyTree.addChild(child1);
        familyTree.addChild(child2);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void calculateTotalAgeRecursive() {
        assertEquals("Test1 failed. Expected 253, but got " + familyTree.calculateTotalAgeRecursive(),
                253, familyTree.calculateTotalAgeRecursive());
        System.out.println("Test1 passed.");
        assertEquals("Test2 failed. Expected 95, but got " + child1.calculateTotalAgeRecursive(),
                95, child1.calculateTotalAgeRecursive());
        System.out.println("Test2 passed.");
    }

    @Test
    public void findYoungestMember() {
        assertEquals("Test1 failed. Expected Joe, but got " + familyTree.findYoungestMember().getName(),
                "Joe", familyTree.findYoungestMember().getName());
        System.out.println("Test1 passed.");
        assertEquals("Test2 failed. Expected Jill, but got " + child1.findYoungestMember().getName(),
                "Jill", child1.findYoungestMember().getName());
        System.out.println("Test2 passed.");
    }

    @Test
    public void findShortestFamilyLine() {
        FamilyTree greatgrandfather = new FamilyTree("Grandpa", 100);
        FamilyTree granduncle = new FamilyTree("Granduncle", 80);
        greatgrandfather.addChild(granduncle);
        greatgrandfather.addChild(familyTree);
        assertEquals("Test1 failed. Expected [Grandpa, Granduncle], but got " + familyTree.findShortestFamilyLine().toString(),
                "[Grandpa, Granduncle]", familyTree.findShortestFamilyLine().toString());
        System.out.println("Test1 passed.");

    }

    @Test
    public void findFamilyWithMostChildren() {
        assertEquals("Test1 failed. Expected name to be Jack, got: " +
                familyTree.findFamilyWithMostChildren().getName(), "Jack", familyTree.findFamilyWithMostChildren().getName());
        System.out.println("Test1 passed.");
    }
}