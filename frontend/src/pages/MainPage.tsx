import {Link} from "react-router-dom";
import BookForm from "../assets/BookForm.tsx";
import {useEffect, useState} from "react";

export interface Book {
    id?: string;
    title: string;
    author: string;
    description?: string;
    year?: string;

}

export default function MainPage () {
    const [books, setBooks] = useState<Book[]>([]);
    const [newBook, setNewBook] = useState<Book>({
        title: '',
        author: '',
        year: '',

    });

    useEffect(() => {
        fetch('/api/books')
            .then((response) => response.json())
            .then((data) => setBooks(data));
    }, []);

    const addBook = async () => {
        try {
            const response = await fetch('/api/books', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(newBook),
            });

            if (!response.ok) {
                throw new Error('Failed to add book');
            }

            const addedBook = await response.json();
            setBooks([...books, addedBook]);
            setNewBook({ title: '', author: '', year: '' });
        } catch (error) {
            console.error('Error:', error);
        }

    };
    return <div><h1>My Book Library</h1>
        <ul>
            {books.map(book => (
                <li key={book.id}>
                    <Link
                        to={"/book/" + book.id}> {book.title} by {book.author} - {book.year} - {book.description}</Link>
                </li>
            ))}
        </ul>
        <input
            type="text"
            placeholder="Title"
            value={newBook.title}
            onChange={e => setNewBook({...newBook, title: e.target.value})}
        />
        <input
            type="text"
            placeholder="Author"
            value={newBook.author}
            onChange={e => setNewBook({...newBook, author: e.target.value})}
        />
        <input
            type="text"
            placeholder="Year"
            value={newBook.year}
            onChange={e => setNewBook({...newBook, year: e.target.value})}
        />
        <input
            type="text"
            placeholder="Genre"
            value={newBook.description}
            onChange={e => setNewBook({...newBook, description: e.target.value})}
        />
        <button onClick={addBook}>Add Book</button>
        <BookForm/>
</div>
}