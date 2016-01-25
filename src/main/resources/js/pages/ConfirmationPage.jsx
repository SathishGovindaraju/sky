import React, {PropTypes } from 'react';
import { connect } from 'react-redux';
import * as cookieHelper from './../utils/CookieHelper.js';

class ConfirmationPage extends React.Component{
    render(){
        let products, customerId;
        customerId = cookieHelper.getCookieValue("customerId");

        if(this.props.selectedProducts.length > 0) {
            products = this.props.selectedProducts.map(function (product, i) {
                return (
                    <label style={{'display' :'block', 'marginTop': '1px'}} key={i}> {product} </label>
                )
            });
        }else{
            products = "";
        }

        return (
            <div>
                <label style={{'textAlign': 'center','display' :'block', 'marginTop': '20px', 'height':'45px','fontSize': '28px'}}> Your order is confirmed </label>
                <div style={{'textAlign': 'center','marginTop': '10px', 'height':'30px'}}>{'Customer Id = ' + customerId}</div>
                <div>
                    <label style={{'display' :'block','fontSize': '20px', 'marginBottom' : '10px'}}> Selected products </label>
                    {products}
                </div>
            </div>
        )
    }
}

ConfirmationPage.propTypes = {
    selectedProducts : PropTypes.array
}

function select(state) {
    return {
        selectedProducts : state.selectedProducts.basket
    }
}

export default connect(select)(ConfirmationPage)