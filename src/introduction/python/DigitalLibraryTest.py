from unittest import TestCase
from unittest.mock import patch
from io import StringIO
from src.introduction.python import AudioBook, Book, DigitalLibrary, Ebook

class DigitalLibraryTest(TestCase):
    def setUp(self):
        self.library = DigitalLibrary()
        self.library.add_item(Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, pages=180))
        self.library.add_item(Ebook("The Odyssey", "Homer", 1614, format="PDF"))
        self.library.add_item(AudioBook("Sofies Welt", "Jostein Gaarder", 1991, duration=720))

    @patch("sys.stdout", new_callable=StringIO)
    def test_search_by_title(self, mock_stdout):
        # test if search_by_title prints the correct item
        self.library.search_by_title("The Great Gatsby")
        expected_output0 = "Title: The Great Gatsby"
        expected_output1 = "Author: F. Scott Fitzgerald"
        self.assertIn(expected_output0, mock_stdout.getvalue())
        self.assertIn(expected_output1, mock_stdout.getvalue())
        mock_stdout.seek(0)
        mock_stdout.truncate(0)
        self.library.search_by_title("The Odyssey")
        expected_output2 = "Title: The Odyssey"
        expected_output3 = "Author: Homer"
        expected_output4 = "Format: PDF"
        unexpected_output0 = "Duration:"
        unexpected_output1 = "Pages:"
        unexpected_output2 = "Gatsby"

        self.assertIn(expected_output2, mock_stdout.getvalue())
        self.assertIn(expected_output3, mock_stdout.getvalue())
        self.assertIn(expected_output4, mock_stdout.getvalue())
        self.assertNotIn(unexpected_output0, mock_stdout.getvalue())
        self.assertNotIn(unexpected_output1, mock_stdout.getvalue())
        self.assertNotIn(unexpected_output2, mock_stdout.getvalue())


    @patch("sys.stdout", new_callable=StringIO)
    def test_search_by_year(self, mock_stdout):
        # test if search_by_year prints the correct item
        self.library.search_by_year(1925)
        expected_output0 = "Title: The Great Gatsby"
        expected_output1 = "Author: F. Scott Fitzgerald"
        self.assertIn(expected_output0, mock_stdout.getvalue())
        self.assertIn(expected_output1, mock_stdout.getvalue())
        mock_stdout.seek(0)
        mock_stdout.truncate(0)
        self.library.search_by_year(1614)
        expected_output2 = "Title: The Odyssey"
        expected_output3 = "Author: Homer"
        expected_output4 = "Format: PDF"
        unexpected_output0 = "Duration:"
        unexpected_output1 = "Pages:"
        unexpected_output2 = "Gatsby"

        self.assertIn(expected_output2, mock_stdout.getvalue())
        self.assertIn(expected_output3, mock_stdout.getvalue())
        self.assertIn(expected_output4, mock_stdout.getvalue())
        self.assertNotIn(unexpected_output0, mock_stdout.getvalue())
        self.assertNotIn(unexpected_output1, mock_stdout.getvalue())
        self.assertNotIn(unexpected_output2, mock_stdout.getvalue())

    @patch("sys.stdout", new_callable=StringIO)
    def test_search_by_status(self, mock_stdout):
        # test if search_by_status prints the correct item
        self.library.search_by_status(True)
        expected_output0 = "Title: The Great Gatsby"
        expected_output1 = "Author: F. Scott Fitzgerald"
        self.assertIn(expected_output0, mock_stdout.getvalue())
        self.assertIn(expected_output1, mock_stdout.getvalue())
        mock_stdout.seek(0)
        mock_stdout.truncate(0)
        self.library.search_by_status(False)
        expected_output2 = "Title: The Odyssey"
        expected_output3 = "Author: Homer"
        expected_output4 = "Format: PDF"
        unexpected_output0 = "Duration:"
        unexpected_output1 = "Pages:"
        unexpected_output2 = "Gatsby"

        self.assertIn(expected_output2, mock_stdout.getvalue())
        self.assertIn(expected_output3, mock_stdout.getvalue())
        self.assertIn(expected_output4, mock_stdout.getvalue())
        self.assertNotIn(unexpected_output0, mock_stdout.getvalue())
        self.assertNotIn(unexpected_output1, mock_stdout.getvalue())
        self.assertNotIn(unexpected_output2, mock_stdout.getvalue())
