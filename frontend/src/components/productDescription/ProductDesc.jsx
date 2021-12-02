import React, { Component, lazy, Suspense, useState } from "react";
import axios from "axios";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faShoppingCart,
  faMinus,
  faPlus,
} from "@fortawesome/free-solid-svg-icons";
import { Container, NavItem, Row } from "react-bootstrap";
const CardFeaturedProduct = lazy(() =>
  import("../../components/card/CardFeaturedProduct")
);
const CardServices = lazy(() => import("../../components/card/CardServices"));
const Details = lazy(() => import("../../components/others/Details"));
const RatingsReviews = lazy(() =>
  import("../../components/others/RatingsReviews")
);
const QuestionAnswer = lazy(() =>
  import("../../components/others/QuestionAnswer")
);
const ShippingReturns = lazy(() =>
  import("../../components/others/ShippingReturns")
);
const SizeChart = lazy(() => import("../../components/others/SizeChart"));
// let itemDetail;
// var value=0;
class ProductDetailView extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      productId:props.productId,
      productName: props.productName,
      productPrice:props.productPrice,
      imageUrl:props.imageUrl,
      productDescription:props.productDescription,
      categoryId:props.categoryId,
      productAvailability:props.productAvailability,
      value:0
     
  };
    
  }
  prepopulated(){
    let url = window.location.href;
    let product_id = url.split('?')[1]
    axios.get("http://localhost:9000/products/description/"+product_id)
        .then((res) => {
            // console.log(res.data);
            var description = res.data;
            // this.setState({itemDetail: res.data});
            this.setState(description);
            // console.log(description);
        })
}
componentDidMount(){
  this.prepopulated();
  
}

doDecrement() {
  if(this.state.value) {
    this.setState({
      value: this.state.value - 1,
      message: null
    });
  } else {
    this.setState({
      message: "Can't decrement. Since 0 is the min value"
    });
  }
}
doIncrement(){
  if(this.state.value < 10) {
    this.setState({
      value:this.state.value + 1,
      message: null
    });
  } else {
    this.setState({
      message: "Can't increment. Since 10 is the max value"
    });
  }
}

  render() {
    return (
      <Container>
        <Suspense fallback={<div>Loading...</div>}>
      <div className="container-fluid mt-3">
        <div className="row">
          <div className="col-md-8">
            <div className="row mb-3">
              <div className="col-md-5 text-center">
                <img
                  src= {this.state.imageUrl}
                  className="img-fluid mb-3"
                  alt=""
                />
              </div>
              <div className="col-md-7">
                <h1 className="h5 d-inline mr-2">
                  {this.state.productName}
                  {console.log(this.state.productName)}
                </h1>


                <dl className="row small mb-3">
                  <dt className="col-sm-3">Availability</dt> <dd className="col-sm-9">In stock -Left - {this.state.productAvailability}</dd>
                  <dt className="col-sm-3">Sold by</dt> <dd className="col-sm-9">Authorised Store</dd>

                </dl>

                <div className="mb-3">
                  <span className="font-weight-bold h5 mr-2">Rs - {this.state.productPrice}</span>
                </div>

                <div className="mb-3">
                  <div className="d-inline float-left mr-2">
                    <div className="input-group input-group-sm mw-140" id="increment-component">
                      <button
                        onClick={this.doDecrement}
                        className="btn btn-primary text-white"
                        type="button"
                      >
                        <FontAwesomeIcon icon={faMinus} />
                      </button>
                      <Row className="g-2">
                      <input
                        type="text"
                        className="form-control"
                        defaultValue="1"
                      />
                      </Row>
                      <button
                        onClick={this.doIncrement}
                        className="btn btn-primary text-white"
                        type="button"
                      >
                        <FontAwesomeIcon icon={faPlus} />
                      </button>
                    </div>
                  </div>

                  <button
                  style={{marginTop:"10px"}}
                    type="button"
                    className="btn btn-lg btn-warning mr-2"
                    title="Buy now"
                  >
                    <FontAwesomeIcon icon={faShoppingCart} /> Buy now
                  </button>

                </div>
                <div>
                  <p className="font-weight-bold mb-2 small">
                    Product Highlights
                  </p>
                  <ul className="small">
                  {function desc(){
                    const highlight = this.state.productDescription;
                    console.log(highlight);
                    highlight.split('.').map(val=>
                      <li>val</li>)}}
                    <li>Etiam ullamcorper nibh eget faucibus dictum.</li>
                    <li>Cras consequat felis ut vulputate porttitor.</li>
                  </ul>
                </div>
              </div>
            </div>
            <div className="row">
              <div className="col-md-12">
                <nav>
                  <div className="nav nav-tabs" id="nav-tab" role="tablist">
                    <a
                      className="nav-link active"
                      id="nav-details-tab"
                      data-toggle="tab"
                      href="#nav-details"
                      role="tab"
                      aria-controls="nav-details"
                      aria-selected="true"
                    >
                      Details
                    </a>
                    <a
                      className="nav-link"
                      id="nav-randr-tab"
                      data-toggle="tab"
                      href="#nav-randr"
                      role="tab"
                      aria-controls="nav-randr"
                      aria-selected="false"
                    >
                      Ratings & Reviews
                    </a>
                    <a
                      className="nav-link"
                      id="nav-faq-tab"
                      data-toggle="tab"
                      href="#nav-faq"
                      role="tab"
                      aria-controls="nav-faq"
                      aria-selected="false"
                    >
                      Questions and Answers
                    </a>
                    <a
                      className="nav-link"
                      id="nav-ship-returns-tab"
                      data-toggle="tab"
                      href="#nav-ship-returns"
                      role="tab"
                      aria-controls="nav-ship-returns"
                      aria-selected="false"
                    >
                      Shipping & Returns
                    </a>
                    <a
                      className="nav-link"
                      id="nav-size-chart-tab"
                      data-toggle="tab"
                      href="#nav-size-chart"
                      role="tab"
                      aria-controls="nav-size-chart"
                      aria-selected="false"
                    >
                      Size Chart
                    </a>
                  </div>
                </nav>
                <div className="tab-content p-3 small" id="nav-tabContent">
                  <div
                    className="tab-pane fade show active"
                    id="nav-details"
                    role="tabpanel"
                    aria-labelledby="nav-details-tab"
                  >
                    <Details />
                  </div>
                  <div
                    className="tab-pane fade"
                    id="nav-randr"
                    role="tabpanel"
                    aria-labelledby="nav-randr-tab"
                  >
                    {Array.from({ length: 5 }, (_, key) => (
                      <RatingsReviews key={key} />
                    ))}
                  </div>
                  <div
                    className="tab-pane fade"
                    id="nav-faq"
                    role="tabpanel"
                    aria-labelledby="nav-faq-tab"
                  >
                    <dl>
                      {Array.from({ length: 5 }, (_, key) => (
                        <QuestionAnswer key={key} />
                      ))}
                    </dl>
                  </div>
                  <div
                    className="tab-pane fade"
                    id="nav-ship-returns"
                    role="tabpanel"
                    aria-labelledby="nav-ship-returns-tab"
                  >
                    <ShippingReturns />
                  </div>
                  <div
                    className="tab-pane fade"
                    id="nav-size-chart"
                    role="tabpanel"
                    aria-labelledby="nav-size-chart-tab"
                  >
                    <SizeChart />
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="col-md-4">
             {/*<CardFeaturedProduct data={data.products} />*/}
            <CardServices />
          </div>
        </div>
      </div>
          </Suspense>
          </Container>
    );
  }
}

export default ProductDetailView;
