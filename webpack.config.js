var path = require('path');
var webpack = require('webpack');

module.exports = {
    entry: {
        main : './src/main/resources/js/entry.js'
    },
    output: {
        filename: "./src/main/resources/static/bundle/bundle.js"
    },
    module: {
        loaders: [
            {
                //tell webpack to use babel-loader for all *.jsx files
                test: /.jsx?$/,
                loader: 'babel',
                exclude: /node_modules/,
                query: {
                    presets: ['es2015', 'react', 'stage-1']
                }
            },
            {
                test: /.css?$/, // Only .css files
                loader: 'style!css'  //Run both loaders css and style
            }
        ]
    }
};