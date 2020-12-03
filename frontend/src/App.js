import React from "react";

import List from "components/List";
import listMovies from "movies.json";
// import logo from './logo.svg';
import './App.css';

export default class App extends React.Component {
  state = {
    favItems: [],
  };
  
  render() {
    return (
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List 
                title="List Movies"
                items={listMovies}
                onItemClick={this.addToFavorites}
              />
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