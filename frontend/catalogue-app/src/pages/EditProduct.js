import React from 'react'
import CustomButton from '../components/customButton';
import Ep from '../editProduct/Ep';
import NavBar from '../navBar/NavBar';
import './EditPage.css';
const EditProduct = () =>{
    return (
        <div>
            <NavBar></NavBar>
            <div id="editPage">
                <div id="name">
                    <p>ProductName</p>
                    <img src="https://picsum.photos/200"></img>
               </div>
                <div id="editable"><Ep></Ep></div>
                <span id="button"><CustomButton content="Save Changes"></CustomButton></span>
            </div>
        </div>
    );
}
export default EditProduct;