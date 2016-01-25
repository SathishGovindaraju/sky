import React from 'react';
import Header from './../components/Header.jsx';
import Footer from './../components/Footer.jsx';

class MainApp extends React.Component{
    render(){
        return(
            <div style={{'width': 100+'%','height': 400+'px', 'position' : 'relative'}}>
                <Header/>
                {this.props.children}
                <Footer/>
            </div>
        )
    }
}

export default MainApp