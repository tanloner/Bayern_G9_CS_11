from LibraryItem import LibraryItem
from AudioBook import AudioBook
from Book import Book
from Ebook import Ebook


class DigitalLibrary:
    def __init__(self) -> None:
        self.items = []

    def add_item(self, item: LibraryItem):
        self.items.append(item)

    def display_all_items(self):
        for item in self.items:
            item.display_info()
            print("--------------------")

    def display_all_items_by_repre(self):
        for item in self.items:
            print(item)

    def search_by_author(self, author):
        found = False
        for item in self.items:
            if item.author.lower() == author.lower():
                item.display_info()
                print("--------------------")
                found = True
        if not found:
            print(f"No items found by author: {author}")

    def analyze_library(self):
        total_items = len(self.items)
        books_count = 0
        ebooks_count = 0
        audiobooks_count = 0

        for item in self.items:
            if isinstance(item, Book):
                books_count += 1
            elif isinstance(item, Ebook):
                ebooks_count += 1
            elif isinstance(item, AudioBook):
                audiobooks_count += 1

        print("Library Analysis:")
        print(f"Total items: {total_items}")
        print(f"Books: {books_count}")
        print(f"E-books: {ebooks_count}")
        print(f"Audiobooks: {audiobooks_count}")

        if books_count > ebooks_count and books_count > audiobooks_count:
            print("Physical books are the most common in this library.")
        elif ebooks_count > books_count and ebooks_count > audiobooks_count:
            print("E-books are the most common in this library.")
        elif audiobooks_count > books_count and audiobooks_count > ebooks_count:
            print("Audiobooks are the most common in this library.")
        else:
            print("There's a tie for the most common item type.")

    def search_by_title(self):
        # exercise
        pass

    def search_by_year(self):
        # exercise
        pass

    def search_by_status(self):
        # exercise
        pass


if __name__ == "__main__":
    library = DigitalLibrary()

    # Adding items to the library
    library.add_item(Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180))
    library.add_item(Ebook("1984", "George Orwell", 1949, "PDF"))
    library.add_item(AudioBook("To Kill a Mockingbird", "Harper Lee", 1960, 720))
    library.add_item(Book("Pride and Prejudice", "Jane Austen", 1813, 432))
    library.add_item(Book("Dune", "Frank Herbert", 1965, 694))
    library.add_item(Ebook("Sophies Welt", "Jostein Gaarder", 1991, "EPUB"))

    # Displaying all items
    print("All items in the library:")
    library.display_all_items()

    # Searching by author
    print("Searching for books by Jane Austen:")
    library.search_by_author("Jane Austen")

    # Analyzing the library
    library.analyze_library()

    # Demonstrating method calls and object interaction
    item = Book("Moby Dick", "Herman Melville", 1851, 585)
    item.check_out()
    item.check_out()  # Trying to check out again
    item.return_item()
    item.return_item()  # Trying to return again
