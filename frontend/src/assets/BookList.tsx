// noinspection TypeScriptCheckImport
import React, { useEffect, useState } from 'react';

const BookList: React.FC = () => {
    const [books, setBooks] = useState<any[]>([]);

    useEffect(() => {
        fetch('/api/books')
            .then((response) => response.json())
            .then((data) => setBooks(data));
    }, []);

    return (
        <div>
            <h2>Book List</h2>
            <ul>
                {books.map((book) => (
                    <li key={book.id}>
                        {book.title} by {book.author} - {book.isRead ? 'Read' : 'Unread'}
                    </li>
                ))}
            </ul>


        </div>
    );
};

export default BookList;


