# Import the LibraryItem class from the separate file
from LibraryItem import LibraryItem

class AudioBook(LibraryItem):
    """
    Inheritance: The AudioBook class inherits from LibraryItem.
    The AudioBook class extends the functionality of LibraryItem by adding an additional field for the duration (in minutes).
    """

    def __init__(self, title, author, year, duration):
        """
        Constructor to create an AudioBook instance with title, author, year, and duration.

        This constructor calls the constructor of the superclass (LibraryItem) to initialize
        the inherited fields (title, author, year) and then initializes the additional 'duration' field.

        :param title: The title of the audiobook
        :param author: The author of the audiobook
        :param year: The year the audiobook was published
        :param duration: The duration of the audiobook in minutes
        """
        super().__init__(title, author, year)
        self.duration = duration

    def display_info(self):
        """
        Overrides the display_info method from the LibraryItem class to include the duration.
        
        This method demonstrates overriding by first calling the display_info method from the superclass 
        to display common information, and then adding the duration specific to the AudioBook class.
        """
        super().display_info()  # Call the method from the superclass
        print(f"Duration: {self.duration} minutes")

    def __repr__(self):
        """
        Returns a string representation of the AudioBook object, extending the representation from LibraryItem
        to include the duration.

        This method overrides the __repr__ method from the LibraryItem class to provide additional 
        information specific to the AudioBook class.
        """
        # Get the base representation from the superclass and add the duration information
        base_repr = super().__repr__()
        return f"{base_repr}, Duration: {self.duration} minutes"
