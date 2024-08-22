package recursion.java;

import java.util.*;

public class FamilyTree {
    //declaring the variables for name age and children
    private String name;
    private int age;
    private List<FamilyTree> children;

    /**
     * Constructor to create a family member with name and age
     *
     * @param name The name of the family member
     * @param age The age of the family member
     */
    public FamilyTree(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Add a child to the family member
     *
     * @param child The child to add
     */
    public void addChild(FamilyTree child) {
        children.add(child);
    }

    /**
     * Counts the total number of family members in the family tree.
     * This method uses a technique called recursion to traverse the tree.
     * <p>
     * Recursion is a process where a method calls itself to solve a problem.
     * In this case, the method counts the current family member and then
     * calls itself for each child to count all descendants.
     * <p>
     * Here's how it works:<br>
     * 1. Start with the current family member and count them as 1.<br>
     * 2. For each child of the current family member, call this method again.<br>
     * 3. Each call will count the child and all of their descendants.<br>
     * 4. Sum up all the counts to get the total number of family members.<br>
     *
     * @return The total number of family members in the family tree.
     */
    public int countFamilyMembers() {
        int count = 1; // Count this member
        for (FamilyTree child : children) {
            count += child.countFamilyMembers();
        }
        return count;
    }

    /**
     * Find the oldest family member in the family tree.
     * This method again uses recursion, and does basically the same thing as the previous method.
     * just checking the age of the family member and comparing it with the other family members this time.
     * @return The oldest family member in the family tree.
     * return is a statement that returns the value of the function (in this case the oldest family member)<br>
     * the function can then be used like a value.
     */
    public FamilyTree findOldestMember() {
        FamilyTree oldest = this;
        for (FamilyTree child : children) {
            FamilyTree childOldest = child.findOldestMember();
            if (childOldest.age > oldest.age) {
                oldest = childOldest;
            }
        }
        return oldest;
    }

    /**
     * Find a family member by name in the family tree.
     * I hope you are getting the idea of how recursion works.
     *
     * @param targetName The name of the family member to find.
     * @return The family member with the given name, or null if not found.
     */
    // Divide and conquer: Find a family member by name
    public FamilyTree findMemberByName(String targetName) {
        if (this.name.equals(targetName)) {
            return this;
        }
        for (FamilyTree child : children) {
            FamilyTree found = child.findMemberByName(targetName);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    //
    /**
     * Print the family tree structure with indentation to show hierarchy.
     * This method uses recursion to traverse the tree and print each family member, showing their depth in the tree.
     * @param depth The depth of the current family member in the tree.
     */
    public void printFamilyTree(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + name + " (" + age + " years)");
        for (FamilyTree child : children) {
            child.printFamilyTree(depth + 1);
        }
    }

    // Iterative vs Recursive: Calculate total age of family
    // Recursive method:
    public int calculateTotalAgeRecursive() {
        int totalAge = this.age;
        for (FamilyTree child : children) {
            totalAge += child.calculateTotalAgeRecursive();
        }
        return totalAge;
    }

    // Iterative method:
    public int calculateTotalAgeIterative() {
        int totalAge = 0;
        Queue<FamilyTree> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            FamilyTree current = queue.poll();
            totalAge += current.age;
            queue.addAll(current.children);
        }

        return totalAge;
    }
    // You don't have to understand everything in this function to see that it's waay more complicated that the recursive one

    /**
     * Finding the longest family line using some advanced recursion
     * <p>
     * let's break it into pieces:<p>
     * 1. If the family has no children, then the longest line is just the current family member.<p>
     * 2. Otherwise, for each child, find the longest line of that child.<p>
     * 3. Compare the longest line of each child and return the longest one.<p>
     * 4. Add the current family member to the beginning of the longest line.<p>
     * 5. Return the longest line.<p>
     * </p>
     * @return a list of names (as strings) representing the longest family line.
     */
    public List<String> findLongestFamilyLine() {
        //1. If the family has no children, then the longest line is just the current family member.
        if (children.isEmpty()) {
            return new ArrayList<>(Collections.singletonList(name));
        }

        //2. Otherwise, for each child, find the longest line of that child.
        List<String> longestLine = new ArrayList<>();
        for (FamilyTree child : children) {
            List<String> childLine = child.findLongestFamilyLine();
            //3. Compare the longest line of each child and return the longest one.
            if (childLine.size() > longestLine.size()) {
                longestLine = childLine;
            }
        }

        //4. Add the current family member to the beginning of the longest line.<p>
        longestLine.add(0, name);
        return longestLine; //5. Return the longest line.
    }

    // Helper method to create a sample
    public static FamilyTree createSampleFamilyTree() {
        FamilyTree root = new FamilyTree("Grandpa", 70);
        FamilyTree parent1 = new FamilyTree("Dad", 45);
        FamilyTree parent2 = new FamilyTree("Aunt", 42);
        FamilyTree child1 = new FamilyTree("You", 20);
        FamilyTree child2 = new FamilyTree("Sister", 18);
        FamilyTree cousin = new FamilyTree("Cousin", 15);

        root.addChild(parent1);
        root.addChild(parent2);
        parent1.addChild(child1);
        parent1.addChild(child2);
        parent2.addChild(cousin);

        return root;
    }

    // exercise functions:

    public FamilyTree findYoungestMember() {
        // This function is left as an exercise
        return null; // Replace this line
    }

    public List<String> findShortestFamilyLine() {
        // This function is left as an exercise
        return null; // Replace this line
    }

    public FamilyTree findFamilyWithMostChildren() {
        // This function is left as an exercise
        return null; // Replace this line
    }

    public static void main(String[] args) {
        FamilyTree familyTree = createSampleFamilyTree();

        System.out.println("Family Tree Structure:");
        familyTree.printFamilyTree(0);

        System.out.println("\nTotal family members: " + familyTree.countFamilyMembers());

        FamilyTree oldest = familyTree.findOldestMember();
        System.out.println("Oldest family member: " + oldest.name + " (" + oldest.age + " years)");

        String targetName = "You";
        FamilyTree found = familyTree.findMemberByName(targetName);
        System.out.println("Found " + targetName + ": " + (found != null ? "Yes" : "No"));

        System.out.println("Total age (recursive): " + familyTree.calculateTotalAgeRecursive());
        System.out.println("Total age (iterative): " + familyTree.calculateTotalAgeIterative());

        List<String> longestLine = familyTree.findLongestFamilyLine();
        System.out.println("Longest family line: " + String.join(" -> ", longestLine));
    }
}
