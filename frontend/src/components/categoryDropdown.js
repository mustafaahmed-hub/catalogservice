import React from "react";
// import { Button, ButtonGroup } from "react-bootstrap";
import DropdownMultiselect from "react-multiselect-dropdown-bootstrap";
import axios from "axios";
import { Form } from 'react-bootstrap';

class CategoryDropdown extends React.Component {

    constructor(props) {
        super(props);
        this.state={
            dropdown: [],
            option:[]

    }}
    componentDidMount() {
        this.getAllCategory()
    }

    getAllCategory(){
        axios
            .get("http://localhost:9000/category/"
            )
            .then((res) => {
                this.setState({ dropdown: res.data});
            })

    }
    assignDropdown(){
        const dropdown = [...this.state.dropdown]
        this.state.option = dropdown.map(category=>category.categoryName)
        console.log(this.state.option)
    }
    render() {
        this.assignDropdown()
        return (
            <DropdownMultiselect options={this.state.option}/>

            );
  }
}

export default CategoryDropdown;