import React, { Component } from "react";
import { MDBBtn } from "mdbreact";

export default class Business extends Component {
  constructor(props) {
    super(props);
    this.state = {
      businessName: this.props.business.businessName
    };
  }

  handleChange(event) {
    this.setState({ businessName: event.target.value });
    this.props.onChange(this.props.business, event.target.value);
  }

  render() {
    return (
      <div>
        <form>
          <label>
            Business:
            <input
              type="text"
              name="name"
              value={this.state.businessName}
              onChange={this.handleChange.bind(this)}
            />
            <MDBBtn 
              onClick={ () => this.props.onDelete(this.props.business.id)}>
              X
            </MDBBtn>
          </label>
        </form>
      </div>
    );
  }
}
