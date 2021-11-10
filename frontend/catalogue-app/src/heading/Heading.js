import React from 'react'
import './Heading.css'
const Heading = ()=>{
    return (
        <div>
            <table>
                <tr id="head">
                    <td colSpan={2}>Products</td>
                    <td colSpan={3}><button id="createP">Create Product</button></td>
                </tr>
            </table>
        </div>
    );
}
export default Heading;