# Import the LibraryItem class from the separate file
from src.introduction.python.LibraryItem import LibraryItem

class Ebook(LibraryItem):
    """
    Inheritance: The Ebook class inherits from LibraryItem.
    The Ebook class extends the functionality of LibraryItem by adding an additional field for the format (e.g., PDF, EPUB).
    """

    def __init__(self, title, author, year, format):
        """
        Constructor to create an Ebook instance with title, author, year, and format.

        This constructor calls the constructor of the superclass (LibraryItem) to initialize
        the inherited fields (title, author, year) and then initializes the additional 'format' field.

        :param title: The title of the ebook
        :param author: The author of the ebook
        :param year: The year the ebook was published
        :param format: The format of the ebook (e.g., PDF, EPUB)
        """
        super().__init__(title, author, year)
        self.format = format

    def display_info(self):
        """
        Overrides the display_info method from the LibraryItem class to include the format.
        
        This method demonstrates overriding by first calling the display_info method from the superclass 
        to display common information, and then adding the format specific to the Ebook class.
        """
        super().display_info()  # Call the method from the superclass
        print(f"Format: {self.format}")

    def __repr__(self):
        """
        Returns a string representation of the Ebook object, extending the representation from LibraryItem
        to include the format.

        This method overrides the __repr__ method from the LibraryItem class to provide additional 
        information specific to the Ebook class.
        """
        # Get the base representation from the superclass and add the format information
        base_repr = super().__repr__()
        return f"{base_repr}, Format: {self.format}"
