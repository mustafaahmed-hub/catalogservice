import React from "react";
import { Route, Switch } from "react-router-dom";
import { BrowserRouter as Router } from "react-router-dom";
import CreateProduct from "./components/createProduct";
import EditProduct from "./components/editProduct";
import NoMatch from "./components/noMatch";
import ProductDetailView from "./components/productDescription/ProductDesc";
import ProductList from "./components/ProductList";
import NavHead from "./header/NavHead";
function App() {
  return (
   <React.Fragment>
     <Router>
       <NavHead/>
       <Switch>
         <Route exact path="/" component={ProductList}/>
         <Route path="/editproduct" component={EditProduct}/>
         <Route path="/createproduct" component={CreateProduct}/>
         <Route path="/productdesc" component={ProductDetailView}/>
         
         <Route component={NoMatch}/>
       </Switch>
     </Router>
   </React.Fragment>
  );
}

export default App;
