import * as types from './ActionTypes.js';
import fetch from 'isomorphic-fetch';
import browserHistory from "./../utils/History.js";

export function selectProduct(product) {
    return { type: types.PRODUCT_SELECTED, text: product }
}

export function deselectProduct(product) {
    return { type: types.PRODUCT_DESELECTED, text: product }
}

export function clearBasket() {
    return { type: types.CLEAR_BASKET}
}

export const showProducts = (data) => {
    return {
        type : types.SHOW_PRODUCTS,
        products : data.products
    }
}

export function getProducts(customerId) {
    return (dispatch) => {
        fetch('http://localhost:8080/api/get-products?customerId=' + customerId)
            .then((result) => {
                if (result.status === 200) {
                    return result.json();
                }else{
                    browserHistory.push('/error-page');
                }
            })
            .then((jsonResult) => {
                if(jsonResult) {
                    dispatch(showProducts(jsonResult));
                }
            });
    }
}
