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
            categoryId:props.categoryId,
            productList: []
        };
        this.editProduct = this.editProduct.bind(this)
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
                alert("ProductList Updated!!!")
                window.location.href = "/"
            })
            .catch((error)=>{
                alert(error)
            });
    }
    componentDidMount() {
        this.prepopulated()
    }
    prepopulated(){
        let url = window.location.href;
        let product_id = url.split('?')[1]
        axios.get("http://localhost:9000/products/"+product_id)
            .then((res) => {
                console.log(res.data);
                this.setState({ productList: res.data });
                console.log(this.state.productList)
                document.getElementById("formGridProductID").value = this.state.productList.id
                document.getElementById("formGridProductName").value = this.state.productList.name
                document.getElementById("formGridPrice").value = this.state.productList.price
                document.getElementById("formGridProductCategory").value = this.state.productList.categoryId[0]
            })
    }
    render() {
    // this.prepopulated()
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
                                <Form.Label>ProductList ID</Form.Label>
                                <Form.Control type="text" placeholder="Enter ProductList ID" readonly="anyBooleanPropertyFromComponent"/>
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridProductName">
                                <Form.Label>ProductList Name</Form.Label>
                                <Form.Control type="text" placeholder="ProductList Name"/>
                            </Form.Group>
                        </Row>

                        <Row className="mb-3">
                            <Form.Group as={Col} controlId="formGridPrice">
                                <Form.Label>Price</Form.Label>
                                <Form.Control placeholder="Enter Price" />
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridProductCategory">
                                <Form.Label>ProductList Category</Form.Label>
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


