import React from "react";
import './App.css';
import Customers from "./components/Customers";
import TransferForm from "./components/TransferForm";
import TransactionHistory from "./components/TransactionHistory";

function App() {

  return (
      <div>

        <h1>Banco UdeA</h1>

        <Customers />

        <hr />

        <TransferForm />

        <hr />

        <TransactionHistory />

      </div>
  );

}

export default App;