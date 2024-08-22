<a id="readme-top"></a>

# Introduction

## First Things First
This folder contains an introduction to java and python in general. 
It will cover everything you learned about java in the last years, and will hopefully help you to remember everything.<hr>
<strong> This is not a complete guide to java or python. It's just a reminder of what you learned in the last years. </strong><hr>
You can also find some python examples here, to get a first impression of the language. 
(It's really easy, I promise. You can read it like plain english)

## Structure
The folder is divided into two subfolders: [`java`](java) and [`python`](python).
They contain some examples and exercises to get you started.<br>
The examples are the same in both languages, so you can compare them and see the differences and similarities.<br>
This Structure is universal for all topics in this repository.
```bash
├── introduction
│   ├── java
│   │   ├── AudioBook.java
│   │   ├── Book.java
│   │   ├── DigitalLibrary.java
│   │   ├── DigitalLibraryTest.java
│   │   ├── Ebook.java
│   │   ├── LibraryItem.java
│   ├── python
│   │   ├── AudioBook.py
│   │   ├── Book.py
│   │   ├── DigitalLibrary.py
│   │   ├── DigitalLibraryTest.py
│   │   ├── Ebook.py
│   │   ├── LibraryItem.py
```

## Roadmap
This roadmap will guide you through this introduction and show you where to find and learn what<hr>
- [ ] You should start with the java folder. A nice starting point is the [LibraryItem](java/LibraryItem.java) class.
- [ ] After that you can work through the [Book](java/Book.java) class and see what you remember about inheritance.
- [ ] For some more examples take a glance at the [Ebook](java/Ebook.java) and [AudioBook](java/AudioBook.java) classes.
- [ ] As soon as you feel comfortable with the classes, you can take a look at the [DigitalLibrary](java/DigitalLibrary.java) class.
- [ ] You will find some exercises in the DigitalLibrary class. Try to solve them, and check your solution with the [tests](#java-tests)
- [ ] If you have really no idea how to solve the exercises, you can take a look at the [docs](../../docs/.keep).
- [ ] After you are done with the java folder, you can take a look at the python folder and see where you can find similarities and differences.
- [ ] Try to write some code in both languages. Maybe your own small project. Anything you can think of.
- [ ] Take a look at the [recursion](../recursion/README.md) module

<p align="right">(<a href="#readme-top">back to top</a>)</p>
<p align="center"><a href="../../README.md">Back to Main Page</a></p>

## Exercises
you can do the exercises in the [java](java/README.md) and [python](python/README.md) folder.
when you are done, you can check your solution by looking in the following list for the proper command to run the tests.<br>
### Java Tests:
<strong>searchByTitle:</strong>
```bash
mvn test -Dtest=DigitalLibraryTest#searchByTitle
```
<strong>searchByYear:</strong>
```bash
mvn test -Dtest=DigitalLibraryTest#searchByYear
```
<strong>searchByStatus:</strong>
```bash
mvn test -Dtest=DigitalLibraryTest#searchByStatus
```
<strong> IMPORTANT: </strong> You have to run the tests in the Project root folder! It will not work if you are not in the 
root folder. (The folder with the pom.xml, LICENSE.txt, README.md, ...)<br>

### Python Tests:
<strong>searchByTitle:</strong>
```bash
python -m unittest src.introduction.python.DigitalLibraryTest.DigitalLibraryTest.test_search_by_title
```
<strong>searchByYear:</strong>
```bash
python -m unittest src.introduction.python.DigitalLibraryTest.DigitalLibraryTest.test_search_by_year
```
<strong>searchByStatus:</strong>
```bash
python -m unittest src.introduction.python.DigitalLibraryTest.DigitalLibraryTest.test_search_by_status
```
<strong> AND AGAIN: </strong> You have to run the tests in the Project root folder! It will not work if you are not in the 
root folder.
