import React from "react";

import List from "components/List";
import listMovies from "movies.json";
// import logo from './logo.svg';
import './App.css';

export default class App extends React.Component {
  state = {
    showFav: false,
    tempList: listMovies,
    favItems: [],
  };

  

  handleItemClickAdd = (item) => {
    // Immotability
    const newItems = [... this.state.favItems];
    const newItem = { ... item };
    // Find item index using id
    const targetInd = newItems.findIndex((it) => it.id === newItem.id);

    if (targetInd < 0) newItems.push(newItem);
    // Delete 1 item at index targetInd
    // else newItems.splice(targetInd, 1);

    // Trigger set state
    this.setState({favItems: newItems});
  }

  handleItemClickDelete = (item) => {
    // Immotability
    const newItems = [... this.state.favItems];
    const newItem = { ... item };
    // Find item index using id
    const targetInd = newItems.findIndex((it) => it.id === newItem.id);

    // if (targetInd < 0) newItems.push(newItem);
    // Delete 1 item at index targetInd
    newItems.splice(targetInd, 1);

    // Trigger set state
    this.setState({favItems: newItems});
  }

  deleteAll = () => {
    this.setState({favItems: []});
  }

  handleOnChange = () => {
    if (!this.state.showFav) this.setState({showFav: true})
    else this.setState({showFav: false})
  }

  render() {
    const {favItems, tempList} = this.state;

    return (
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className="custom-control custom-switch text-center">
          <input onChange={this.handleOnChange} type="checkbox" className="custom-control-input" id="customSwitch2"/>
          <label className="custom-control-label" for="customSwitch2">Show Favorites</label>
        </div>
        
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List 
                title="List Movies"
                items={tempList}
                onItemClick={this.handleItemClickAdd}
              />
            </div>
            <div className={this.state.showFav ? "col-sm" : "col-sm d-none"}>
              <List 
                title="My Favorites"
                items={favItems}
                onItemClick={this.handleItemClickDelete}
              />
              
              {Object.keys(favItems).length <= 0?
                <div>
                  <h3 className="text-center mt-3 mb-0">Belum ada item yang dipilih</h3>
                  <p className="text-center text-secondary text-sm">Klik salah satu item di List Movies</p>
                  
                </div> :
                <div >
                  <button 
                    onClick={this.deleteAll}
                    type="button" 
                    className="btn btn-danger mr-3"
                    >Delete All
                  </button>
                </div>
              }
              
              
            </div>
          </div>
        </div>
      </div>
    );
  }
}

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }