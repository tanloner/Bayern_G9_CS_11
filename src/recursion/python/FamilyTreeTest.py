import unittest
from unittest import TestCase
from src.recursion.python.FamilyTree import FamilyTree

class FamilyTreeTest(TestCase):
    def setUp(self):
        self.family_tree = FamilyTree("John", 80)
        self.child1 = FamilyTree("Jane", 50)
        child2 = FamilyTree("Jack", 45)
        grandchild1 = FamilyTree("Jill", 25)
        grandchild2 = FamilyTree("Joe", 20)
        grandchild3 = FamilyTree("Jenny", 18)
        grandchild4 = FamilyTree("Jerry", 15)
        self.child1.add_child(grandchild1)
        child2.add_child(grandchild2)
        child2.add_child(grandchild3)
        child2.add_child(grandchild4)
        self.family_tree.add_child(self.child1)
        self.family_tree.add_child(child2)

    def test_find_youngest_member(self):
        self.assertEqual(self.family_tree.find_youngest_member().get_name(), "Jerry")
        self.assertEqual(self.child1.find_youngest_member().get_name(), "Jill")

    def test_find_shortest_family_line(self):
        greatgrandfather = FamilyTree("Grandpa", 100)
        granduncle = FamilyTree("Granduncle", 80)
        greatgrandfather.add_child(granduncle)
        greatgrandfather.add_child(self.family_tree)
        self.assertEqual(str(greatgrandfather.find_shortest_family_line()), "['Grandpa', 'Granduncle']")

    def test_find_family_with_most_children(self):
        self.assertEqual(self.family_tree.find_family_with_most_children().get_name(), "Jack")

if __name__ == '__main__':
    unittest.main()