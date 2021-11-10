import React from 'react'
import profile from '../resources/profile.png';
import './NavBar.css'
const NavBar = ()=> {
    return (
        <div className="navBar"> 
            <img src={profile}></img>
            <h3>User XYZ </h3>
            <input type="text"></input>
            <button id="orders">Orders/Returns</button>
        </div>
    );
}
export default NavBar;