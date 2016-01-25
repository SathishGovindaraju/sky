import React, { PropTypes} from 'react';
import { connect } from 'react-redux';
import * as actions from './../redux-actions/Actions.js';

class Checkbox extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            isChecked : false
        }
    }

    onChange = () => {
        const {store} = this.context;

        if(this.state.isChecked){
            this.setState({isChecked : false});
            store.dispatch(actions.deselectProduct(this.props.name));
        }else{
            this.setState({isChecked : true});
            store.dispatch(actions.selectProduct(this.props.name));
        }
    };

    render(){
        return(
            <div>
                <input type="checkbox" checked={this.state.isChecked} onChange={this.onChange}/>
                <label> {this.props.name}</label>
            </div>
        )
    }
}

Checkbox.contextTypes = {
    store : React.PropTypes.object
}

export default Checkbox