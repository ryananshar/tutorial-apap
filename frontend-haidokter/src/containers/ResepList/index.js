import React, {Component} from "react";

class ResepList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            reseps: [
                {
                    noResep: 1,
                    namaDokter: "Papa APAP",
                    namaPasien: "Anaknya Papa APAP",
                    catatan: "Sakit ringan",
                },
                {
                    noResep: 2,
                    namaDokter: "Mama APAP",
                    namaPasien: "Anaknya Mama APAP",
                    catatan: "Sakit sedang",
                },
                {
                    noResep: 3,
                    namaDokter: "Kakak APAP",
                    namaPasien: "Anaknya Kakak APAP",
                    catatan: "Sakit parah",
                },
            ],
        };
    }

    componentDidMount() {
        console.log("componentDidMount()");
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
    }

    render() {
        console.log("render()");
        return (
            <div>
                <h1>All Reseps</h1>
                <p>Resep 1, 2, 3, dst</p>
            </div>
        );
    }
}

export default ResepList;