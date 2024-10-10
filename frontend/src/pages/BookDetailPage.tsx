import {Link, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {Book} from "./MainPage.tsx";


export default function BookDetailPage (){
    const [book, setBook] = useState<Book>();
    const params = useParams();
    const id: string | undefined = params.id;
    useEffect(() => {
        fetch('/api/books/'+id)
            .then((response) => response.json())
            .then((data) => setBook(data));
    }, [id]);
    if (book === undefined){
        return <h2>loading...</h2>;
    }
    return <div>
        <Link
            to={"/"}> Return to Homepage</Link>
        <p> {book.title} by {book.author} - {book.year} - {book.description} </p>
    </div>

}