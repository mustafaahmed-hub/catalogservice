import React, { Component } from 'react';
import { Navbar, Nav, Container, Form, FormControl,Button } from 'react-bootstrap';
import CategoryDropdown from '../components/categoryDropdown';
import Flex from '@react-css/flex'
class NavHead extends Component {
    render() {
        return (
            <Navbar bg="light" expand="lg">
                <Container fluid>
                    <Navbar.Brand href="#">Catalog Service</Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                        >
                        <Form className="d-flex">
                            <FormControl
                            type="search"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                            />
                            <Button variant="outline-success">Search</Button>
                        </Form>

                        {/* <Nav.Link href="#action2"></Nav.Link> */}
                        <CategoryDropdown></CategoryDropdown>
                        {/* <NavDropdown title="Select Category" id="navbarScrollingDropdown">
                        <NavDropdown.Item href="#action3">Action</NavDropdown.Item>
                        <NavDropdown.Item href="#action4">Another action</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#action5">
                            Something else here
                        </NavDropdown.Item>
                        </NavDropdown> */}
                        <Nav.Link href="#action1">Past Orders</Nav.Link>

                    </Nav>
                    
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        );
    }
}

export default NavHead;