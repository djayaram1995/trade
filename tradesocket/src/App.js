import React, { Component } from "react";
import "./App.css";

class App extends Component {
  ws = new WebSocket('ws://localhost:8080/pricestreamer');
  constructor() {
    super();
    this.state = {
      dataFromServer:"0"
    }
  }
  componentDidMount() {
    this.ws.onmessage = evt => {
      this.setState({dataFromServer: evt.data})
      console.log(evt.data)
      }
  }
  render() {
  return (
    <div className="App">
      {this.state.dataFromServer}
    </div>
  );
  }
}

export default App;
