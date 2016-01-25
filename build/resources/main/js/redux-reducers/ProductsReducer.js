import * as types from './../redux-actions/ActionTypes.js';
import { combineReducers } from 'redux';

function productsReducer(state = {"products" : {}}, action ={}) {
    switch (action.type) {
        case types.SHOW_PRODUCTS:
            return Object.assign({},{"products" : action.products});
        default:
            return state
    }
}

function basketReducer(state = {"basket" :[]}, action ={}) {
    switch (action.type) {
        case types.PRODUCT_SELECTED:
            return Object.assign({},
                { "basket" :[
                    ...state.basket,
                    action.text
                ]}
            );
        case types.PRODUCT_DESELECTED:
            let productIndex = state.basket.indexOf(action.text);
            return Object.assign({},
                { "basket" :[
                    ...state.basket.slice(0,productIndex),
                    ...state.basket.slice(productIndex+1)
                ]}
            );
        case types.CLEAR_BASKET:
            return Object.assign({},{"basket" :[]});
        default:
            return state
    }
}


const reducer = combineReducers(Object.assign(
    {},
    {allProducts : productsReducer} ,
    {selectedProducts : basketReducer}
));

export default reducer


