# In Python, we don't need to import any specific module to use strings or booleans, 
# but for complex data structures like lists, we can import them from the collections' module.

# Base class representing a general library item
# This class has attributes for title, author, year, and checked out status
# It also has methods to check out, return, and display information about the item
# It can later be extended by specific item types like Book, Ebook, and AudioBook
# and is just a blueprint for those classes
class LibraryItem:
    def __init__(self, title, author, year):
        """
        Initializes a LibraryItem instance with the given title, author, and year.

        This method is similar to a constructor in Java and is automatically executed 
        when a new instance of the class is created. The provided arguments (title, author, year) 
        are required to initialize the object's state.

        In Python, the __init__ method handles the setup of an object's initial state, 
        just like a constructor does in Java.

        :param title: The title of the item
        :param author: The author of the item
        :param year: The year the item was published
        """

        # In Python, variables and methods are typically public by default, meaning they can be accessed from outside the class.
        # However, if we want to indicate that a variable or method should be treated as private (i.e., for internal use within the class),
        # we conventionally prefix its name with a single underscore "_". 
        # While this does not enforce true privacy, it signals to other developers that it is intended to be private.
        # Note: Python does offer a stricter form of "private," but it's less common and not conventional,
        # so it is not covered here for simplicity.
        self.title = title
        self.author = author
        self.year = year
        self.is_checked_out = False


    # In Python, we don't typically need getter and setter methods because attributes are public by default
    # and can be accessed or modified directly.

    def check_out(self):
        """
        Method to check out the item
        This method first checks if the item is already checked out, by using an if statement.
        the "not" keyword negates the value of is_checked_out.
        you can read the if statement as "if not is_checked_out do:"
        if the item is not checked out, we set is_checked_out to True and print a message.
        else (if the item is already checked out), we print a different message.
        """
        if not self.is_checked_out:
            self.is_checked_out = True
            print(f"{self.title} has been checked out.")
        else:
            print(f"{self.title} is already checked out.")

    def return_item(self):
        """
        Method to return the item
        This method is similar to the check_out method, but it checks if the item is already in the library.
        """
        if self.is_checked_out:
            self.is_checked_out = False
            print(f"{self.title} has been returned.")
        else:
            print(f"{self.title} is already in the library.")

    def display_info(self):
        """
        Method to display information about the item.
        
        Note: This method can be replaced by the __repr__ method, which provides a string 
        representation of the object and integrates better with Python’s built-in functions.
        """
        print(f"Title: {self.title}")
        print(f"Author: {self.author}")
        print(f"Year: {self.year}")
        print(f"Status: {'Checked Out' if self.is_checked_out else 'Available'}")

    def __repr__(self):
        """
        Returns a string representation of the LibraryItem object, 
        displaying the title, author, year, and checked out status.
        
        This method is more versatile and Pythonic, replacing the need for a separate 
        display_info method, as it integrates seamlessly with Python's interactive environment.

        # For example, you can simply use print(testitem) to automatically use the __repr__ method,
        # displaying a formatted string representation of the object.
        """
        status = 'Checked Out' if self.is_checked_out else 'Available'
        return f"Title: {self.title}, Author: {self.author}, Year: {self.year}, Status: {status}"
