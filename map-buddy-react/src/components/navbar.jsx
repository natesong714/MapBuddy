import React, { Component } from 'react';



export default class NavBar extends Component {


    render() {
        console.log(this.divStyle);
        return (
            // <div 
            //     style = {this.divStyle}
            <nav 
                className="navbar navbar-light bg-light"
            >
                <h3>Untitled Nate App</h3>
            </nav>
        )
    }
}


