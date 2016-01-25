import React from 'react';
import Checkbox from './Checkbox.jsx';
import ProductsCss from './../../css/product.css';

class Products extends React.Component{
    render(){
        let products;
        if(this.props.products) {
            products = this.props.products.map(function (data, i) {
                return (<Checkbox name={data} key={i}/>);
            });
        }else{
            products = "";
        }
        return(
            <div className="products-holder">
                <div className="category-name">{this.props.categoryName}</div>
                <div className="products">
                    {products}
                </div>
            </div>
        )
    }
}

export default Products