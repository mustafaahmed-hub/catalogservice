import React from 'react'
import './customButton.css'
const CustomButton = (props) =>{
    return (
        <div>
            <button className="customButton">{props.content}</button>
        </div>
    );
}
export default CustomButton;