import React from "react";
import classes from "./styles.module.css";

const Obat = (props) => {
    const {nama, bentuk, kuantitas} = props;
    return (
        <div className={classes.Obat}>
            {`${nama} (${kuantitas})`}
        </div> 
        );
    };
    
export default Obat;