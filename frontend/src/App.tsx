// noinspection TypeScriptCheckImport
import React, { useEffect, useState } from 'react';
import BookForm from "./assets/BookForm.tsx";
import "./App.css"
import {Link, Route, Routes} from "react-router-dom";
import BookDetailPage from "./pages/BookDetailPage.tsx";
import MainPage from "./pages/MainPage.tsx";



const App: React.FC = () => {




    return (

            <Routes>
                <Route path="/" element={<MainPage/>}/>
                <Route path="/book/:id" element={<BookDetailPage/>}/>
            </Routes>

    );
}

export default App;





