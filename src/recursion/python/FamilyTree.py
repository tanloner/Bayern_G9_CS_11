from typing import List, Optional

class FamilyTree:
    def __init__(self, name: str, age: int):
        """
        Constructor to create a family member with name and age<hr>
        The 'str' and 'int' in the parameters are type hints, which specify the expected types of the parameters.
        In python, type hints are optional, and don't mean that the parameters must be of that type like in java,
        however, they are useful for documentation and can be used to catch errors.
        :param name: The name of the family member
        :param age: The age of the family member
        """
        self.name = name
        self.age = age
        self.children: List[FamilyTree] = []

    def get_name(self) -> str:
        return self.name

    def add_child(self, child: 'FamilyTree'):
        """
        Add a child to the family member

        :param child: The child to add
        """
        self.children.append(child)

    def count_family_members(self) -> int:
        """
        Counts the total number of family members in the family tree.
        This method uses a technique called recursion to traverse the tree.

        Recursion is a process where a method calls itself to solve a problem.
        In this case, the method counts the current family member and then
        calls itself for each child to count all descendants.

        Here's how it works:
        1. Start with the current family member and count them as 1.
        2. For each child of the current family member, call this method again.
        3. Each call will count the child and all of their descendants.
        4. Sum up all the counts to get the total number of family members.

        :return: The total number of family members in the family tree.
        """
        count = 1  # Count this member
        for child in self.children:
            count += child.count_family_members()
        return count

    def find_oldest_member(self) -> 'FamilyTree':
        """
        Find the oldest family member in the family tree.
        This method again uses recursion, and does basically the same thing as the previous method,
        just checking the age of the family member and comparing it with the other family members this time.
        :return: The oldest family member in the family tree.
        return is a statement that returns a value from a function.
        the function can then be used like a value.
        """
        oldest = self
        for child in self.children:
            child_oldest = child.find_oldest_member()
            if child_oldest.age > oldest.age:
                oldest = child_oldest
        return oldest

    def find_member_by_name(self, target_name: str) -> Optional['FamilyTree']:
        """
        Find a family member by name in the family tree.
        I hope you are getting the idea of how recursion works.

        :param target_name: The name of the family member to find.
        :return: The family member with the given name, or None if not found.
        """
        if self.name == target_name:
            return self
        for child in self.children:
            found = child.find_member_by_name(target_name)
            if found is not None:
                return found
        return None

    def print_family_tree(self, depth: int = 0):
        """
        Print the family tree structure with indentation to show hierarchy.
        This method uses recursion to traverse the tree and print each family member, showing their depth in the tree.
        :param depth: The depth of the current family member in the tree.
        """
        indent = "  " * depth
        print(f"{indent}{self.name} ({self.age} years)")
        for child in self.children:
            child.print_family_tree(depth + 1)

    def calculate_total_age_recursive(self) -> int:
        """
        Recursive method to calculate total age of family
        """
        total_age = self.age
        for child in self.children:
            total_age += child.calculate_total_age_recursive()
        return total_age

    def calculate_total_age_iterative(self) -> int:
        """
        Iterative method to calculate total age of family
        """
        total_age = 0
        queue = [self]

        while queue:
            current = queue.pop(0)
            total_age += current.age
            queue.extend(current.children)

        return total_age

    def find_longest_family_line(self) -> List[str]:
        """
        Finding the longest family line using some advanced recursion

        Let's break it into pieces:
        1. If the family has no children, then the longest line is just the current family member.
        2. Otherwise, for each child, find the longest line of that child.
        3. Compare the longest line of each child and return the longest one.
        4. Add the current family member to the beginning of the longest line.
        5. Return the longest line.

        :return: a list of names (as strings) representing the longest family line.
        """
        # 1. If the family has no children, then the longest line is just the current family member.
        if not self.children:
            return [self.name]

        # 2. Otherwise, for each child, find the longest line of that child.
        longest_line = []
        for child in self.children:
            child_line = child.find_longest_family_line()
            # 3. Compare the longest line of each child and return the longest one.
            if len(child_line) > len(longest_line):
                longest_line = child_line

        # 4. Add the current family member to the beginning of the longest line.
        longest_line.insert(0, self.name)
        return longest_line  # 5. Return the longest line.

    @staticmethod
    def create_sample_family_tree() -> 'FamilyTree':
        """Helper method to create a sample family tree"""
        root = FamilyTree("Grandpa", 70)
        parent1 = FamilyTree("Dad", 45)
        parent2 = FamilyTree("Aunt", 42)
        child1 = FamilyTree("You", 20)
        child2 = FamilyTree("Sister", 18)
        cousin = FamilyTree("Cousin", 15)

        root.add_child(parent1)
        root.add_child(parent2)
        parent1.add_child(child1)
        parent1.add_child(child2)
        parent2.add_child(cousin)

        return root

    # exercise functions:

    def find_youngest_member(self) -> 'FamilyTree':
        # This function is left as an exercise
        return  # adjust this line

    def find_shortest_family_line(self) -> List[str]:
        # This function is left as an exercise
        return  # adjust this line

    def find_family_with_most_children(self) -> 'FamilyTree':
        # This function is left as an exercise
        return  # adjust this line


if __name__ == "__main__":
    family_tree = FamilyTree.create_sample_family_tree()

    print("Family Tree Structure:")
    family_tree.print_family_tree()

    print(f"\nTotal family members: {family_tree.count_family_members()}")

    oldest = family_tree.find_oldest_member()
    print(f"Oldest family member: {oldest.name} ({oldest.age} years)")

    target_name = "You"
    found = family_tree.find_member_by_name(target_name)
    print(f"Found {target_name}: {'Yes' if found else 'No'}")

    print(f"Total age (recursive): {family_tree.calculate_total_age_recursive()}")
    print(f"Total age (iterative): {family_tree.calculate_total_age_iterative()}")

    longest_line = family_tree.find_longest_family_line()
    print(f"Longest family line: {' -> '.join(longest_line)}")