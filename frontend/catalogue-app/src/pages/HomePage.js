import React from 'react'
import Heading from '../heading/Heading';
import NavBar from '../navBar/NavBar';
import Products from '../products/Products';
import './HomePage.css'
const HomePage = () =>{
    return (
        <div className="Home">
           <NavBar></NavBar>
           <Heading></Heading>
           <Products></Products>
        </div>
    );
}
export default HomePage;