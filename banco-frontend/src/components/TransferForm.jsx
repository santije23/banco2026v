import React, { useState } from "react";
import API from "../services/api";

function TransferForm() {

    const [sender, setSender] = useState("");
    const [receiver, setReceiver] = useState("");
    const [amount, setAmount] = useState("");

    const transfer = async () => {

        const data = {
            senderAccountNumber: sender,
            receiverAccountNumber: receiver,
            amount: parseFloat(amount)
        };

        try {

            const res = await API.post("/transactions", data);

            alert("Transferencia realizada ID: " + res.data.id);

        } catch (err) {

            alert("Error: " + err.response.data);

        }

    };

    return (
        <div>

            <h2>Transferir Dinero</h2>

            <input
                placeholder="Cuenta remitente"
                onChange={e => setSender(e.target.value)}
            />

            <br />

            <input
                placeholder="Cuenta destino"
                onChange={e => setReceiver(e.target.value)}
            />

            <br />

            <input
                placeholder="Monto"
                onChange={e => setAmount(e.target.value)}
            />

            <br />

            <button onClick={transfer}>
                Transferir
            </button>

        </div>
    );
}

export default TransferForm;