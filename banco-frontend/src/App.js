import React, { useState } from "react";
import "./App.css";

import Customers from "./components/Customers";
import TransferForm from "./components/TransferForm";
import TransactionHistory from "./components/TransactionHistory";

function App() {

    const [view, setView] = useState("customers");

    const renderView = () => {
        if (view === "customers") return <Customers />;
        if (view === "transfer") return <TransferForm />;
        if (view === "history") return <TransactionHistory />;
    };

    return (
        <div className="App">

            <header className="header">
                <h1>Banco UdeA</h1>
            </header>

            <nav className="menu">
                <ul>
                    <li onClick={() => setView("customers")}>Consultar Clientes</li>
                    <li onClick={() => setView("transfer")}>Realizar Transferencia</li>
                    <li onClick={() => setView("history")}>Historial Transacciones</li>
                </ul>
            </nav>

            <div className="content">
                {renderView()}
            </div>

            <footer>
                <p>© 2026 Banco UdeA - Proyecto Arquitectura de Software</p>
            </footer>

        </div>
    );
}

export default App;