import React from 'react';
import ReactDOM from 'react-dom';
import Router from 'react-router';
import thunkMiddleware from 'redux-thunk';
import { compose, createStore, applyMiddleware } from 'redux';
import { Provider } from 'react-redux';
import routes from './utils/Routes.jsx';
import history from './utils/History.js';
import reducers from './redux-reducers/ProductsReducer.js';

const createStoreWithMiddleware = compose(applyMiddleware(thunkMiddleware), window.devToolsExtension ? window.devToolsExtension() : f => f)(createStore)
const store = createStoreWithMiddleware(reducers)

ReactDOM.render(
<Provider store={store}>
    <Router history={history}>{routes}</Router>
    </Provider>,
    document.getElementById('content')
);

