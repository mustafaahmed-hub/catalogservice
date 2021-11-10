import React from 'react'
import CustomButton from '../components/customButton';

const Product = (props) => {
    return (
            <tr>
                <td>{props.productId || 12345}</td>
                <td>{props.productName || "product"}</td>
                <td>{props.price || 1000}</td>
                <td>{props.category || "electronics"}</td>
                <td id="Actions"><CustomButton content="Edit"/> <CustomButton content="Delete"/></td>
            </tr>
    );
}
export default Product;