<a id="readme-top"></a>

# Recursion
Welcome to the first module of this school year. 
I think this module includes everything you need to know about recursion in java and python.


## Structure
The structure stays the same in every module.
Here is a short overview of it:
```bash
└── recursion
    ├── java
    │   ├── FamilyTree.java
    │   └── FamilyTreeTest.java
    ├── python
    │   ├── FamilyTree.py
    │   ├── FamilyTreeTest.py
```

## Roadmap
Here is a roadmap again. The concept of the roadmap stays the same in every module. It's a guide for you to know where to find and learn what. (you don't have to follow it)
- [ ] You should start with the java folder. The only possible starting point is the [FamilyTree](java/FamilyTree.java) class.
- [ ] Actively go through each example and try to understand why the function works the way it does.
- [ ] If you have trouble understanding the examples, you can take a look at the [docs](../../docs/.keep).
- [ ] When you're done with the examples, try solving the exercises and check your solution with the [tests](#java-tests)
- [ ] The [docs](../../docs/.keep) are your friend when you need help.
- [ ] After you are done with the java folder, you can look at the python folder and admire the beauty of python (or not).
- [ ] If you want to test your python skills, you can try to solve the exercises in the python folder and check your solution with the [tests](#python-tests)
- [ ] In case you already started some kind of own project after the introduction, try implementing some recursive functions in it. If you haven't started a project yet, you can start one now (anything you can think of).
- [ ] Take a look at the [next](../recursion/README.md) module

<p align="right">(<a href="#readme-top">back to top</a>)</p>
<p align="center"><a href="../../README.md">Back to Main Page</a></p>

## Exercises
you can do the exercises in the [java](java/README.md) and [python](python/README.md) folder.
when you are done, you can check your solution by looking in the following list for the proper command to run the tests.<br>
### Java Tests:
<strong>searchByTitle:</strong>
```bash
mvn test -Dtest=FamilyTree#findYoungestMember
```
<strong>searchByYear:</strong>
```bash
mvn test -Dtest=FamilyTree#findShortestFamilyLine
```
<strong>searchByStatus:</strong>
```bash
mvn test -Dtest=FamilyTree#findFamilyWithMostChildren
```
<strong> IMPORTANT: </strong> You have to run the tests in the Project root folder! It will not work if you are not in the 
root folder. (The folder with the pom.xml, LICENSE.txt, README.md, ...)<br>

### Python Tests:
<strong>searchByTitle:</strong>
```bash
python -m unittest src.recursion.python.FamilyTreeTest.FamilyTreeTest.test_find_youngest_member
```
<strong>searchByYear:</strong>
```bash
python -m unittest src.recursion.python.FamilyTreeTest.FamilyTreeTest.test_find_shortest_family_line
```
<strong>searchByStatus:</strong>
```bash
python -m unittest src.recursion.python.FamilyTreeTest.FamilyTreeTest.test_find_family_with_most_children
```
<strong> AND AGAIN: </strong> You have to run the tests in the Project root folder! It will not work if you are not in the 
root folder.
