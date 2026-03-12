import React, { useState } from "react";
import API from "../services/api";

function TransactionHistory() {

    const [account, setAccount] = useState("");
    const [transactions, setTransactions] = useState([]);

    const search = async () => {

        const res = await API.get("/transactions/" + account);

        setTransactions(res.data);

    };

    return (

        <div>

            <h2>Historial de Transacciones</h2>

            <input
                placeholder="Numero de cuenta"
                onChange={e => setAccount(e.target.value)}
            />

            <button onClick={search}>
                Buscar
            </button>

            <table border="1">

                <thead>
                <tr>
                    <th>ID</th>
                    <th>Cuenta Origen</th>
                    <th>Cuenta Destino</th>
                    <th>Monto</th>
                </tr>
                </thead>

                <tbody>

                {transactions.map(t => (

                    <tr key={t.id}>

                        <td>{t.id}</td>
                        <td>{t.senderAccountNumber}</td>
                        <td>{t.receiverAccountNumber}</td>
                        <td>{t.amount}</td>

                    </tr>

                ))}

                </tbody>

            </table>

        </div>

    );
}

export default TransactionHistory;