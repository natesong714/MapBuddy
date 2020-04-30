import React, { Component } from "react";
import Businesses from "./Business/businesses";
import Location from "./Location/location";

export default class SideBar extends Component {
  state = {
    locationName: "",
    businessCounter: 1,
    businesses: [{ id: 0, businessName: "" }]
  };

  handleLocationChange = locationName => {
    this.setState({ locationName });
  };
  handleBusinessChange = (business, businessName) => {
    const businesses = [...this.state.businesses];
    const index = businesses.indexOf(business);
    if (index >= 0) {
      businesses[index].businessName = businessName;
      this.setState({ businesses });
    }
  };

  handleBusinessIncrement = () => {
    if (this.state.businesses.length < 3) {
      const newId = this.state.businessCounter + 1;
      const businesses = [
        ...this.state.businesses,
        { id: newId, businessName: "" }
      ];
      this.setState({ businesses, businessCounter: newId });
    }
  };

  handleBusinessDelete = businessId => {
    const businesses = this.state.businesses.filter(c => c.id !== businessId);
    this.setState({ businesses });
  };

  render() {
    return (
      <div>
        <Location
          onChange={this.handleLocationChange}
          locationName={this.state.locationName}
        />
        <Businesses
          onIncrement={this.handleBusinessIncrement}
          onChange={this.handleBusinessChange}
          onDelete={this.handleBusinessDelete}
          businesses={this.state.businesses}
        />
        <button
          type="submit"
          value="Search"
          onClick={ () => this.props.onSearch(
            this.state.locationName,
            this.state.businesses
          )}
        >
          Search
        </button>
      </div>
    );
  }
}
