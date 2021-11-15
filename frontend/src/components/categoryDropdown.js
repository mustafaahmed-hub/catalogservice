import React from "react";
// import { Button, ButtonGroup } from "react-bootstrap";
import DropdownMultiselect from "react-multiselect-dropdown-bootstrap";
import axios from "axios";

class CategoryDropdown extends React.Component {

    constructor() {
        super();
        this.state={
            dropdown: [],

        }
    }
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
    render() {
        const dropdown = [...this.state.dropdown]
        let option = dropdown.map(category=>category.categoryName)
        console.log(option)
        return (
            <DropdownMultiselect
                options ={[...option]}
                // options=
                name="Categories"
            />
            );
  }
}

export default CategoryDropdown;