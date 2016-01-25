import React, {PropTypes } from 'react';
import { connect } from 'react-redux';
import BasketCss from './../../css/basket.css';
import {Link} from 'react-router';
import * as actions from './../redux-actions/Actions.js';

class Basket extends React.Component{

    render(){
        let products, isBasketEmptyClass;
        if(this.props.selectedProducts.length > 0) {
            products = this.props.selectedProducts.map(function (product, i) {
                return (
                    <label key={i}> {product} </label>
                )
            });
            isBasketEmptyClass = "";
        }else{
            products = "";
            isBasketEmptyClass = "hidden";
        }
        return (
            <div className="basket">
                <label className="basket-title"> Basket </label>
                <div className="basket-items">
                    {products}
                </div>
                <div className={"checkout " + isBasketEmptyClass}>
                    <Link to={"confirmed"} >Checkout</Link>
                </div>
            </div>
        )
    }
}

Basket.contextTypes = {
    store : React.PropTypes.object
}


Basket.propTypes = {
    selectedProducts : PropTypes.array
}

function select(state) {
    return {
        selectedProducts : state.selectedProducts.basket
    }
}

export default connect(select)(Basket)