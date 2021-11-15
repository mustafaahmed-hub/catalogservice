import React, { Component } from 'react';
import { Button, Form, Row, Col, Container, Table } from 'react-bootstrap';
class Product extends Component 
{
    constructor(){
        super();
        this.state={
            productList: [
                {
                  productId:"1111",
                  productName:"Mobile",
                  productPrice:15000,
                  productCategory:"elcotronics"
                },
                {
                  productId:"2222",
                  productName:"Shirt",
                  productPrice:999,
                  productCategory:"cloths"
                },
                {
                  productId:"3333",
                  productName:"Book",
                  productPrice:500,
                  productCategory:"education"
                },
                {
                  productId:"4444",
                  productName:"Biscuit",
                  productPrice:15000,
                  productCategory:"food"
                },
                {
                  productId:"5555",
                  productName:"laptop",
                  productPrice:55000,
                  productCategory:"elcotronics"
                }
              ]
        }
    }
    
    render() {
      // console.log({this.state.productList.productId});
    
        return (
          <Container>
              <Container style={{ textAlign: "center",padding:"15px" }}>
                <Row>
                  <Col><h3>Products</h3></Col>
                  <Col> <Button variant="primary" onClick={()=> window.open(window.location.href+"createproduct", "_blank")}>Create Product</Button>{' '}</Col>
                </Row>
              </Container>
              <Table striped bordered hover variant="dark" style={{ textAlign: "center" }}>
                <thead>
                  <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Category</th>
                    <th></th>
                    <th></th>

                  </tr>
                </thead>
                <tbody>
                  {
                    this.state.productList.map(item=>
                          <tr key={item.productId}>
                            <td>{item.productId}</td>
                            <td>{item.productName}</td>
                            <td>{item.productPrice}</td>
                            <td>{item.productCategory}</td>
                            <td>
                                <Button variant="secondary" onClick={()=> window.open(window.location.href+"editproduct", "_blank")}>Edit</Button>
                                {/* <Button variant="danger" onClick={this.props.deleteItem.bind(this, this.props.name)}>Delete</Button> */}
                    
                            </td>
                            
                            <td><Button variant="danger">Delete</Button></td>
                          </tr>
                      )
                  }
                  
                </tbody>
              </Table>
          </Container>
            
        );
    }
}

export default Product;