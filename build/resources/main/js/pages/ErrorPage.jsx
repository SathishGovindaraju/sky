import React from 'react';

class ErrorPage extends React.Component{
    render(){
        return (
            <div style={{'textAlign': 'center','marginTop': 100+'px','fontSize': 26+'px'}}>
                Oops! Something went wrong. Please try again!
            </div>
        )
    }
}

export default ErrorPage