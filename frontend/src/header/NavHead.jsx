import React, { Component } from 'react';
import { Navbar, Nav, Container, Form, FormControl,Button } from 'react-bootstrap';
import AnimatedMulti from "../components/DropdownOptions";
class NavHead extends Component {

    search(){
        let search = document.getElementById("search").value

        window.location.href = "?"+search
    }

    render() {
        
        return (
            <Navbar bg="dark" variant="dark" expand="lg" >
                <Container >
                    <Navbar.Brand href="/">Catalog Service</Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0 mx-auto gap-5"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                        >

                        <Form className="d-flex">
                            <FormControl
                            type="search"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                            id="search"
                            />

                            <Button variant="outline-info" onClick={this.search}>Search</Button>
                        </Form>
                        <AnimatedMulti></AnimatedMulti>


                        <Nav.Link href="#action1">Past Orders</Nav.Link>

                    </Nav>
                    
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        );
    }
}
export default NavHead;