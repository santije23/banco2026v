import React, { useEffect, useState } from "react";
import API from "../services/api";

function Customers() {

    const [customers, setCustomers] = useState([]);

    useEffect(() => {
        API.get("/customers")
            .then(res => setCustomers(res.data))
            .catch(err => console.error(err));
    }, []);

    return (
        <div>
            <h2>Clientes</h2>

            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Cuenta</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Balance</th>
                </tr>
                </thead>

                <tbody>
                {customers.map(c => (
                    <tr key={c.id}>
                        <td>{c.id}</td>
                        <td>{c.accountNumber}</td>
                        <td>{c.firstName}</td>
                        <td>{c.lastName}</td>
                        <td>{c.balance}</td>
                    </tr>
                ))}
                </tbody>

            </table>
        </div>
    );
}

export default Customers;