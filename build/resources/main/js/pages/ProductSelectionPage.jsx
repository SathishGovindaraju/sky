import React, {PropTypes } from 'react';
import { connect } from 'react-redux';
import Product from './../components/Products.jsx';
import Basket from './../components/Basket.jsx';
import * as actions from './../redux-actions/Actions.js';
import * as cookieHelper from './../utils/CookieHelper.js';

class ProductSelectionPage extends React.Component{
    static defaultProps = {
        productsList : {
            "NEWS" : [],
            "SPORTS" : []
        }
    };

    componentDidMount(){
        const {store} = this.context;
        let customerId = cookieHelper.getCookieValue("customerId");
        store.dispatch(actions.clearBasket());
        store.dispatch(actions.getProducts(customerId));
    }

    render(){
        return (
            <div style={{'marginLeft': 3+'%'}}>
                <Product className="products-holder" products={this.props.productsList.NEWS} categoryName={"News"}/>
                <Product className="products-holder" products={this.props.productsList.SPORTS} categoryName={"Sports"}/>
                <Basket className="basket"/>
            </div>
        )
    }
}


ProductSelectionPage.contextTypes = {
    store : React.PropTypes.object
}


ProductSelectionPage.propTypes = {
    productsList : PropTypes.object,
    selectedProducts : PropTypes.array
}

function select(state) {
    return {
        productsList: state.allProducts.products,
        selectedProducts : state.selectedProducts.basket
    }
}

export default connect(select)(ProductSelectionPage)