import React, {Component} from "react";
import Layout from "./components/Layout";
import ResepList from "./containers/ResepList"

class App extends Component {
  render () {
    return (
      <Layout>
        <ResepList/>
      </Layout>
    );
  }
}

export default App;
