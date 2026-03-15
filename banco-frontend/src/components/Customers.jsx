import React, { useEffect, useState } from "react";
import API from "../services/api";

function Customers() {

    const [customers, setCustomers] = useState([]);
    const [searchId, setSearchId] = useState("");

    // listar todos al cargar
    useEffect(() => {
        loadCustomers();
    }, []);

    const loadCustomers = async () => {
        try {
            const res = await API.get("/customers");
            setCustomers(res.data);
        } catch (err) {
            console.error(err);
        }
    };

    const searchCustomer = async () => {

        if (searchId === "") {
            loadCustomers();
            return;
        }

        try {
            const res = await API.get("/customers/" + searchId);
            setCustomers([res.data]); // lo convertimos en array
        } catch (err) {
            alert("Cliente no encontrado");
        }
    };

    return (
        <div>

            <h2>Clientes</h2>

            <div>

                <input
                    placeholder="Buscar cliente por ID"
                    value={searchId}
                    onChange={e => setSearchId(e.target.value)}
                />

                <button onClick={searchCustomer}>
                    Buscar
                </button>

                <button onClick={loadCustomers}>
                    Ver Todos
                </button>

            </div>

            <table>

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