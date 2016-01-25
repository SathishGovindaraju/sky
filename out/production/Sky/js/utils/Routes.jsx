import React from 'react';
import ReactDOM from 'react-dom';
import {Route, IndexRoute, Router} from 'react-router';
import browserHistory from "history";

import MainApp from './../pages/MainApp.jsx';
import ProductSelectionPage from './../pages/ProductSelectionPage.jsx';
import ConfirmationPage from './../pages/ConfirmationPage.jsx';
import ErrorPage from './../pages/ErrorPage.jsx';

export default (
    <Router history={browserHistory}>
        <Route path="/" component={MainApp}>
            <IndexRoute component={ProductSelectionPage}/>
            <Route path="confirmed" component={ConfirmationPage}/>
            <Route path="error-page" component={ErrorPage}/>
        </Route>
    </Router>
);