import React, {Component} from "react";
import Resep from "../../components/Resep" ;
import Obat from "../../components/Obat";
import ObatList from "../ObatList";
import classes from "./styles.module.css" ;
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button";
import Modal from "../../components/Modal";
import ReactPaginate from 'react-paginate';

class ResepList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            reseps: [],
            resepFilter: [],
            isLoading: false,
            isEdit: false,
            isCreate: false,
            isDelete: false,
            isFiltered: false,
            namaDokter: "",
            namaPasien: "",
            catatan: "",
            filterName: "",
            offset: 0,
            page: 5,
            curPage: 0,
        };
        // this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddResep = this.handleAddResep.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitAddResep = this.handleSubmitAddResep.bind(this);
        this.handleEditResep = this.handleEditResep.bind(this);
        this.handleSubmitEditResep = this.handleSubmitEditResep.bind(this);
        this.handleDeleteResep = this.handleDeleteResep.bind(this);
        this.handleFilter = this.handleFilter.bind(this);
        this.handlePagination = this.handlePagination.bind(this);
    }
    
    handleCancel(event) {
        event.preventDefault();
        this.setState({isCreate: false, isEdit: false});
    }

    handleChangeField(event) {
        const {name, value} = event.target;
        this.setState({[name]: value});
    }

    handleAddResep() {
        this.setState({isCreate: true});
    }

    handleEditResep(resep) {
        console.log("Editing")
        this.setState ({
            isEdit : true,
            noResep : resep.noResep,
            namaDokter : resep.namaDokter,
            namaPasien : resep.namaPasien,
            catatan : resep.catatan,
        });
    }

    handleFilter(event) {
        const {value} = event.target;
        this.setState({filterName: value});
        var keyword = this.state.filterName;
        var query = []
        console.log(keyword);
        if (keyword === "") {
            console.log("Empty Query")
            query = this.state.reseps;
        }
        else {
            this.state.reseps.forEach((resep) => {
                if (resep.namaDokter.toLowerCase().includes(keyword.toLowerCase())) {
                    query.push(resep);
                    // console.log(this.state.reseps.namaDokter);
                }
            });
        }
        this.setState({resepFilter: query})
        // console.log(this.state.resepFilter);
    }

    componentDidMount() {
        console.log("componentDidMount()");
        this.loadData();
        const resepList = this.state.reseps
        console.log(resepList)
        this.setState({resepFilter: resepList})
    }

    async loadData() {
        try {
            const {data} = await APIConfig.get("/reseps");
            const sliceData = data.slice(this.state.offset, this.state.offset + this.state.page);
            this.setState({
                reseps: sliceData,
                pageCount: Math.ceil(data.length / this.state.page)
            });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleSubmitAddResep (event) {
        event.preventDefault();
        try {
            const data = {
                namaDokter : this.state.namaDokter,
                namaPasien : this.state.namaPasien,
                catatan : this.state.catatan,
            };
            await APIConfig.post("/resep", data);
            this.setState({
                namaDokter: "",
                namaPasien: "",
                catatan: "",
            })
            this.loadData();
        } catch(error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitEditResep (event) {
        event.preventDefault();
        try {
            const data = {
                namaDokter : this.state.namaDokter,
                namaPasien : this.state.namaPasien ,
                catatan : this.state.catatan,
            };
            await APIConfig.put(`/resep/${this.state.noResep}`, data);
            this.loadData ();
        } catch(error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    } 

    async handleDeleteResep (noResep) {
        try {
            await APIConfig.delete(`/resep/${noResep}`);
            this.loadData();
        } catch(error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }
    // shouldComponentUpdate(nextProps, nextState) {
    //     console.log("shouldComponentUpdate()");
    // }

    // handleClickLoading() {
    //     const currentLoading = this.state.isLoading;
    //     this.setState({isLoading: !currentLoading})
    //     console.log(this.state.isLoading);
    // }

    handlePagination(event) {
        const selectedPage = event.selected;
        const offset = selectedPage * this.state.page;
        this.setState({
            curPage: selectedPage,
            offset: offset
        }, () => {
            this.loadData();
        })
    }


    render() {
        // console.log("render()");
        let ResepsFilter = this.state.reseps.filter(
            (resep) => {
                return resep.namaDokter.toLowerCase().includes(this.state.filterName.toLowerCase());
            }
        );
        return (
            <div className = {classes.resepList}>
                <h1 className = {classes.title}>All Reseps</h1>
                <Button onClick = {this.handleAddResep}variant="primary">
                    Add Resep
                </Button>
                <input
                    className = {classes.textField}
                    type = "text"
                    placeholder = "Filter Nama Dokter"
                    name = "filterName"
                    value= {this.state.filterName}
                    onChange={this.handleFilter}
                />
                <div>
                    {
                         (this.state.reseps && ResepsFilter).map((resep) => (
                            <Resep 
                            key={resep.noResep}
                            noResep={resep.noResep}
                            namaDokter={resep.namaDokter}
                            namaPasien={resep.namaPasien}
                            catatan={resep.catatan}
                            listObat={resep.listObat}
                            handleEdit={() => this.handleEditResep(resep)}
                            handleDelete={() => this.handleDeleteResep(resep.noResep)}/>
                        ))
                    }
                </div>
                <div className="d-flex justify-content-center">
                    <ReactPaginate
                        previousLabel={"prev"}
                        nextLabel={"next"}
                        breakLabel={"..."}
                        // breakClassName={"break-me"}
                        pageCount={this.state.pageCount}
                        marginPagesDisplayed={2}
                        pageRangeDisplayed={5}
                        onPageChange={this.handlePagination}
                        containerClassName={classes.pagination}
                        // subContainerClassName={"pages pagination"}
                        activeClassName={classes.active}
                    />
                </div>
                <Modal 
                    show = {this.state.isCreate || this.state.isEdit} 
                    handleCloseModal = {this.handleCancel}
                >
                    <form>
                        <h3 className = {classes.modalTitle}>
                        {this.state.isCreate
                            ? "Add Resep"
                            : `Edit Resep Nomor ${this.state.noResep}`}
                        </h3>
                        <input
                            className = {classes.textField}
                            type = "text"
                            placeholder = "Nama Dokter"
                            name = "namaDokter"
                            value= {this.state.namaDokter}
                            onChange={this.handleChangeField}
                        />

                        <input
                            className = {classes.textField}
                            type = "text"
                            placeholder = "Nama Pasien"
                            name = "namaPasien"
                            value = {this.state.namaPasien}
                            onChange = {this.handleChangeField}
                        />

                        <textarea
                            className = {classes.textField}
                            placeholder = "Catatan"
                            name = "catatan"
                            rows = "4"
                            value = {this.state.catatan}
                            onChange = {this.handleChangeField}
                        />

                        <Button 
                            onClick = {
                                this.state.isCreate
                                ? this.handleSubmitAddResep
                                : this.handleSubmitEditResep
                            }
                            variant = "primary"
                        >
                            {this.state.isCreate? "Create" : "Edit"}
                        </Button>

                        <Button 
                            onClick = {this.handleCancel} 
                            variant = "danger"
                        >
                            Cancel
                        </Button>
                    </form>
                </Modal>
            </div>
            // <div>
            //     <h1>All Reseps</h1>
            //     <p>Resep 1, 2, 3, dst</p>
            //     <button onClick={this.handleClickLoading}>Change State</button>
            // </div>
        );
    }
}

export default ResepList;