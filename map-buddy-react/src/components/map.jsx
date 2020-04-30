import React, { Component } from "react";
import ReactDOM from 'react-dom'
import ReactMapGL, { Marker } from "react-map-gl";

export default class Map extends Component {
  state = {
    businesses: [],
    markersFound: false,
    markers: [],
    viewport: {
      latitude: 47.5562629699707,
      longitude: -122.38024139404297,
      width: "80vw",
      height: "90vh",
      zoom: 11
    }
  };


  render() {
    let markers;
    if (this.props.businesses !== undefined) {
      markers = this.props.businesses.businesses.map(business => (
        <Marker>
          key={business.id}
          longitude={business.coordinates.longitude}
          latitude={business.coordinates.latitude}
          
          
        </Marker>));
        // ReactDOM.render(markers, document.getElementById('root'));
    }
    return (
      <div>
        <ReactMapGL
          {...this.state.viewport}
          onViewportChange={viewport => this.setState({ viewport })}
          mapboxApiAccessToken={process.env.REACT_APP_MAPBOX_TOKEN}
          mapStyle="mapbox://styles/natesongya/ck6k3taub18v31ioee6b6m0ru"
        >
        
        </ReactMapGL>
        
      </div>
    );
  }
}
