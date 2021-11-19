import React, { Component } from 'react';
import { Button, Row, Col, Container, Table } from 'react-bootstrap';
import axios from "axios";
import './product.css'
class ProductList extends Component
{
    constructor(props){
        super(props);
        this.state={
            productList: [],
            response:""
        };
    }
    componentDidMount() {
        this.getAllProducts()
    }

    getAllProducts(){
        let url = window.location.href
        let searchText = url.split('?')[1]
        console.log(searchText)
        if(searchText===undefined) {
            axios
                .get("http://localhost:9000/products/"
                )
                .then((res) => {
                    console.log(res.data);
                    this.setState({productList: res.data});
                })
        }
        else{
            axios
                .get("http://localhost:9000/products/"+searchText
                )
                .then((res) => {
                    console.log(res.data);
                    this.setState({productList: res.data});
                })
        }
    }
    deleteProduct = async (id)=>{
        // event.preventDefault();
        await axios.delete("http://localhost:9000/products/" + id)
            .then((res) => {
                alert(res.data)
                this.setState({ response: res.data })
                    window.location.href = "/"
            }
            )
    };

      render() {
         return (

             <Container>
                 <Container style={{textAlign: "center", padding: "15px"}}>
                     <Row>
                         <Col><h3>Products</h3></Col>
                         <Col> <Button variant="primary"
                                       onClick={() => window.open(window.location.href + "createproduct", "_blank")}>Create
                             Product</Button>{' '}</Col>
                     </Row>
                 </Container>
                 <Table striped bordered hover style={{textAlign: "center"}}>
                     <thead>
                     <tr>
                         <th>Image</th>
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
                         this.state.productList.map(item =>
                             <tr key={item.id}>
                                 <td><img src={item.imageUrl} className="img-responsive"/></td>
                                 <td>{item.id}</td>
                                 <td>{item.name}</td>
                                 <td>Rs. {item.price}</td>
                                 <td>{item.categoryId[0]}</td>
                                 <td>
                                     <Button variant="secondary"
                                             onClick={() => window.open("editproduct?"+item.id, "_blank")}>Edit</Button>
                                     {/* <Button variant="danger" onClick={this.props.deleteItem.bind(this, this.props.name)}>Delete</Button> */}

                                 </td>
                                 <td><Button variant="danger" onClick={()=>this.deleteProduct(item.id)}>Delete</Button></td>
                             </tr>
                         )
                     }
                     </tbody>
                 </Table>
             </Container>

         );
     }
}



export default ProductList;