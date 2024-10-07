import React, { useState, useEffect } from 'react';

const App: React.FC = () => {
    const [books, setBooks] = useState<any[]>([]);
    const [newBook, setNewBook] = useState({ title: '', author: '', description: '' });

    useEffect(() => {
        fetch('/api/books')
            .then(response => response.json())
            .then(data => setBooks(data));
    }, []);

    const addBook = () => {
        fetch('/api/books', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newBook),
        }).then(() => {
            setBooks([...books, newBook]);
        });
    };

    return (
        <div>
            <h1>My Book Library</h1>
            <ul>
                {books.map(book => (
                    <li key={book.id}>
                        {book.title} by {book.author} - {book.description}
                    </li>
                ))}
            </ul>
            <input
                type="text"
                placeholder="Title"
                onChange={e => setNewBook({ ...newBook, title: e.target.value })}
            />
            <input
                type="text"
                placeholder="Author"
                onChange={e => setNewBook({ ...newBook, author: e.target.value })}
            />
            <input
                type="text"
                placeholder="Description"
                onChange={e => setNewBook({ ...newBook, description: e.target.value })}
            />
            <button onClick={addBook}>Add Book</button>
        </div>
    );
}

export default App;
