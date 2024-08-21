from unittest import TestCase

from src.introduction.python import AudioBook, Book, DigitalLibrary, Ebook

class DigitalLibraryTest(TestCase):
    def setUp(self):
        self.library = DigitalLibrary()
        self.library.add_item(Book("The Great Gatsby", "F. Scott Fitzgerald", 1925))
        self.library.add_item(Ebook("The Odyssey", "Homer", 1614))
        self.library.add_item(AudioBook("Sophie's Welt", "Jostein Gaarder", 1991))

    def test_search_by_title(self):
        self.fail()

    def test_search_by_year(self):
        self.fail()

    def test_search_by_status(self):
        self.fail()
