# Import the LibraryItem class from the separate file
from LibraryItem import LibraryItem

class Book(LibraryItem):
    """
    Inheritance: The Book class inherits from LibraryItem.
    The Book class extends the functionality of LibraryItem by adding an additional field for the number of pages.
    """

    def __init__(self, title, author, year, pages):
        """
        Constructor to create a Book instance with title, author, year, and pages.

        This constructor calls the constructor of the superclass (LibraryItem) to initialize
        the inherited fields (title, author, year) and then initializes the additional 'pages' field.

        :param title: The title of the book
        :param author: The author of the book
        :param year: The year the book was published
        :param pages: The number of pages in the book
        """
        super().__init__(title, author, year) # Calls the method from the parent (superclass) to reuse its functionality.
        self.pages = pages

    def display_info(self):
        """
        Overrides the display_info method from the LibraryItem class to include the number of pages.
        
        This method demonstrates two key aspects of inheritance:
        1. Overriding: We replace the display_info method from the superclass with our own version.
        2. Super: We call the original display_info method from the superclass to display common information,
           and then add the number of pages specific to the Book class.
        """
        super().display_info()  # Call the method from the superclass
        print(f"Pages: {self.pages}")

    def __repr__(self):
            """
            Returns a string representation of the Book object, extending the representation from LibraryItem
            to include the number of pages.

            This method overrides the __repr__ method from the LibraryItem class to provide additional 
            information specific to the Book class.
            """
            # Get the base representation from the superclass and add the pages information
            base_repr = super().__repr__()
            return f"{base_repr}, Pages: {self.pages}"
