import React from "react";
import classes from "./styles.module.css";
const Button = (props) => {
    const {onClick, children, variant} = props;
    return (
        <button
            onClick = {onClick}
            className = {[classes.button, classes[variant]].join(" ")}
        >
            {children}
        </button>
    );
};

export default Button;