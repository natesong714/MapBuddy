import React, { Component } from "react";
import "./App.css";
import NavBar from "./components/navbar";
import SideBar from "./components/sidebar";
import Map from "./components/map";
import { Container, Row, Col } from "react-bootstrap";
import axios from "axios";

import "bootstrap/dist/css/bootstrap.min.css";

export default class App extends Component {
  constructor(props) {
    super(props);
    this.submitSearch = this.submitSearch.bind(this);
    this.returnSearch = this.returnSearch.bind(this);
    this.state = {
      businesses: [],
      isLoading: true
    };
  }

  submitSearch = (locationName, businesses) => {
    const businessList = businesses.map(business => business.businessName);

    axios
      .post("http://localhost:8080/search", {
        location: locationName,
        businessNames: businessList
      })
      .then(response => {
        console.log(response);
        this.returnSearch();
      })
      .catch(function(error) {
        console.log(error);
      });
  };

  returnSearch = () => {
    axios
      .get("http://localhost:8080/return", {
        params: {
          ID: 12345
        }
      })
      .then(response => {
        console.log(response);
        this.setState((this.businesses = response.data));
      })
      .catch(function(error) {
        console.log(error);
      })
      .then(function() {
        // always executed
      });
  };

  render() {
    return (
      <div className="App">
        <NavBar />
        <Container>
          <Row>
            <Col>
              <SideBar xs={0} onSearch={this.submitSearch} />
            </Col>
            <Col xs={9}>
              <Map businesses={this.businesses} />
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}
