import React, {Component} from 'react';
import { Button, Form, Row, Col, Container } from 'react-bootstrap';

class EditProduct extends Component {
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
                    <Form>
                        <Row className="mb-3">
                            <Form.Group as={Col} controlId="formGridProductID">
                                <Form.Label>Product ID</Form.Label>
                                <Form.Control type="text" placeholder="Enter Product ID"/>
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridProductName">
                                <Form.Label>Product Name</Form.Label>
                                <Form.Control type="text" placeholder="Product Name"/>
                            </Form.Group>
                        </Row>

                        <Row className="mb-3">
                            <Form.Group as={Col} controlId="formGridPrice">
                                <Form.Label>Price</Form.Label>
                                <Form.Control placeholder="Enter Price"/>
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridProductCategory">
                                <Form.Label>Product Category</Form.Label>
                                <Form.Select defaultValue="Choose...">
                                    <option>Choose...</option>
                                    <option>...</option>
                                </Form.Select>
                            </Form.Group>
                        </Row>
                        <div className="text-center">
                            <Button variant="primary" type="submit">
                                Submit
                            </Button>
                        </div>

                    </Form>
                </Container>

            </div>

        )
    }
}

export default EditProduct;


