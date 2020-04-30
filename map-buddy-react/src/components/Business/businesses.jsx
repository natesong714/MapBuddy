import React, { Component } from "react";
import Business from "./business";
import { MDBBtn } from "mdbreact";

export default class Businesses extends Component {



  

  render() {
    
    return (
      <React.Fragment>
        <h3>Enter Business</h3>
        <div>
          {this.props.businesses.map(business => (
            <Business 
              key = { business.id}
              business = { business}
              onChange={this.props.onChange}
              onDelete={this.props.onDelete} />
          ))}
          <MDBBtn color="success" onClick={this.props.onIncrement}>
            +
          </MDBBtn>
        </div>
        
      </React.Fragment>
    );
  }
}
