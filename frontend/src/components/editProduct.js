import React, {Component} from 'react';
import { Button, Form, Row, Col, Container } from 'react-bootstrap';
import axios from "axios";


class EditProduct extends Component {

    constructor(props) {
        super(props);
        this.state = {
            id:props.id,
            name: props.name,
            price:props.price,
            imageUrl:props.imageUrl,
            descId:props.descId,
            categoryId:props.categoryId
        };
        this.editProduct = this.editProduct .bind(this)
    }
    editProduct() {
        let id = document.getElementById("formGridProductID").value

        let name = document.getElementById("formGridProductName").value
        let price = document.getElementById("formGridPrice").value
        let categoryId = document.getElementById("formGridProductCategory").value

        this.setState({
            id: id, name: name, price: price, category: categoryId
        })

        let object = {
            id: id,
            name: name,
            price: price,
            categoryId: [categoryId]
        }
        let url = window.location.href;
        let product_id = url.split('?')[1]
        console.log(product_id)
        axios.put("http://localhost:9000/products/"+product_id, object)
            .then(() => {
                alert("Product Updated!!!")
                window.location.href = "/"
            })
            .catch((error)=>{
                alert(error)
            });
    }

    render() {

        return (
            <div>
                <Container>
                    <div className="header">
                        <h3 style={{
                            padding: "10px",
                            textAlign: "center",
                            backgroundColor: "radial-gradient(#eee, #aaa)"
                        }}>Create a new product</h3>
                        <hr/>
                    </div>
                    {/*<form onSubmit={this.createProduct}>*/}
                    <Form role="form" onSubmit={this.editProduct}>
                        <Row className="mb-3">
                            <Form.Group as={Col} controlId="formGridProductID" >
                                <Form.Label>Product ID</Form.Label>
                                <Form.Control type="text" placeholder="Enter Product ID" />
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridProductName">
                                <Form.Label>Product Name</Form.Label>
                                <Form.Control type="text" placeholder="Product Name"/>
                            </Form.Group>
                        </Row>

                        <Row className="mb-3">
                            <Form.Group as={Col} controlId="formGridPrice">
                                <Form.Label>Price</Form.Label>
                                <Form.Control placeholder="Enter Price" />
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridProductCategory">
                                <Form.Label>Product Category</Form.Label>
                                <Form.Select defaultValue="Choose..." >
                                    <option key="1">Choose...</option>
                                    <option key="2">electronics</option>
                                    <option key="3">Food</option>
                                </Form.Select>
                            </Form.Group>
                        </Row>
                        <div className="text-center">
                            <Button variant="primary"  onClick={this.editProduct}>
                                Submit
                            </Button>
                        </div>
                    </Form>
                    {/*</form>*/}
                </Container>

            </div>

        )
    }
}

export default EditProduct;


