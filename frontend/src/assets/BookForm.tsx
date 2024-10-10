// noinspection TypeScriptCheckImport
import React, { useState } from 'react';

const AddBookForm: React.FC = () => {
    const [newBook, setNewBook] = useState({
        title: '',
        author: '',
        description: '',
        isRead: true,
    });

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        const response = await fetch('/api/books', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newBook),
        });

        if (response.ok) {
            alert('Book added successfully!');
            setNewBook({ title: '', author: '', description: '', isRead:true });
        } else {
            alert('Failed to add the book');
        }
    };
function wasser (event){
    console.log(event.target);
}
    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Title:</label>
                <input
                    type="text"
                    value={newBook.title}
                    onChange={(e) => setNewBook({ ...newBook, title: e.target.value })}
                    required
                />
            </div>
            <div>
                <label>Author:</label>
                <input
                    type="text"
                    value={newBook.author}
                    onChange={(e) => setNewBook({ ...newBook, author: e.target.value })}
                    required
                />
            </div>
            <div>
                <label>Description:</label>
                <textarea
                    value={newBook.description}
                    onChange={(e) => setNewBook({ ...newBook, description: e.target.value })}
                    required
                />
            </div>
            <div>
                <label>
                    <input
                        type="checkbox"
                        checked={newBook.isRead}
                        onChange={(e) => setNewBook({ ...newBook, isRead: e.target.checked })}
                    />
                    Mark as Read
                </label>
            </div>
            <button type="submit">Add Book</button>


        </form>
    );
};

export default AddBookForm;






