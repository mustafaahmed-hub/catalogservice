import React from 'react'
import Product from '../product/Product'
import './Products.css'
const Products = () =>{
    return (
        <div>            
            <table>
                <tr>
                        <td>Id</td>
                        <td>Name</td>
                        <td>Price</td>  
                        <td>Category</td>
                        <td>Actions</td>
                </tr>
                <Product></Product>
                <Product></Product>
                <Product></Product>
                <Product></Product>
                <Product></Product>
            </table>
        </div>
    );
}  
export default Products;