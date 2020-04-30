import React, { Component } from "react";

export default class Location extends Component {
  constructor(props) {
    super(props);
    this.state = {
      locationName: this.props.locationName
    };
  }

  handleChange(event) {
    this.setState({locationName: event.target.value});
    this.props.onChange(event.target.value);
    
  }

  render() {
    return (
      <div>
        <h3>Enter Location</h3>
        <form>
          <label>
            Location:
            <input
              type="text"
              name="name"
              value={this.props.locationName}
              onChange={this.handleChange.bind(this)}
            />
          </label>
        </form>
      </div>
    );
  }
}
