import React from "react";
import classes from "./styles.module.css";

const Resep = (props) => {
    const {noResep , namaDokter , namaPasien , catatan} = props;
    return (
        <div className={classes.resep}>
            <h3> {`Resep Nomor ${noResep}` } </h3>
            <p> {`Nama Dokter: ${namaDokter}`} </p>
            <p> {`Nama Pasien: ${namaPasien}`} </p>
            <p> {`Nama Catatan: ${catatan}`} </p>
        </div>
        );
    };
    
export default Resep ;