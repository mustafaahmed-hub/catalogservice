import React from 'react';
import Select from 'react-select';
import makeAnimated from 'react-select/animated';
import axios from "axios";

const animatedComponents = makeAnimated();

const colourOptions = [

    { value: 'blues', label: 'Blues' },

    { value: 'rock', label: 'Rock' },

    { value: 'jazz', label: 'Jazz' },

    { value: 'orchestra', label: 'Orchestra' }

];

export default function AnimatedMulti() {

    let dropdownOptions = []
    axios
        .get("http://localhost:9000/category/"
        )
        .then((res) => {
            // dropdownOptions.push({
            //     'value':res.data.categoryName, 'label': res.data.categoryName
            // })
                (res.data.map(item =>{
                    dropdownOptions.push({'value': item.categoryName, 'label': item.categoryName})
                }))
                // console.log(res.data)
        }
        )
    return (
        <Select
            closeMenuOnSelect={false}
            components={animatedComponents}
            defaultValue={[dropdownOptions[0]]}
            isMulti
            options={dropdownOptions}

        />

    );

}