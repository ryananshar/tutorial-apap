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
            isLoading: false,
        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        // this.handleClickLoading = this.handleClickLoading.bind(this);
    }

    componentDidMount() {
        console.log("componentDidMount()");
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({isLoading: !currentLoading})
        console.log(this.state.isLoading);
    }

    render() {
        console.log("render()");
        return (
            <div>
                <h1>All Reseps</h1>
                <p>Resep 1, 2, 3, dst</p>
                <button onClick={this.handleClickLoading}>Change State</button>
            </div>
        );
    }
}

export default ResepList;