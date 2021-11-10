import React from 'react'
import './Row.css'
const Row = (props) =>{
    return (
        <div className="editRow">
            <p>{props.heading || "heading"}</p>
            <input type="text"></input>
        </div>
    );
}
export default Row;