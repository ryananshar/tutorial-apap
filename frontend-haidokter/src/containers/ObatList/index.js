import React, {Component} from "react";
import Obat from "../../components/Obat";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";

class ObatList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            obats: [],
            nama: "",
            bentuk: "",
            kuantitas: "",
        }
    }

    render() {
        const {listObat} = this.props;
        return (
            <div className = {classes.ObatList}>
                {listObat.map((obat) => (
                    <Obat 
                    nama={obat.nama}
                    bentuk={obat.bentuk}
                    kuantitas={obat.kuantitas}/>
                ))
                }
            </div>
        )
    }
}

export default ObatList;