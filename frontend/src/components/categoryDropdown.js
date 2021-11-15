import React from "react";
// import { Button, ButtonGroup } from "react-bootstrap";
import DropdownMultiselect from "react-multiselect-dropdown-bootstrap";

class CategoryDropdown extends React.Component {
  render() {
    return (
        <DropdownMultiselect
            options={["Electronics", "Clothes", "Food", "Education"]}
            name="Categories"
        />
        );
  }
}

export default CategoryDropdown;