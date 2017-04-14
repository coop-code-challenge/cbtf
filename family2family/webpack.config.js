var webpack = require('webpack');
var path = require('path');

var dir = "./";

var BUILD_DIR = path.resolve(dir, 'src/main/resources/static/build');
var APP_DIR = path.resolve(dir, 'client');

var config = {
    entry: APP_DIR + '/router_test.jsx',
    output: {
        path: BUILD_DIR,
        filename: 'bundle.js'
    },
    module: {
        loaders : [
            {
                test : /\.jsx?/,
                include : APP_DIR,
                loader: 'babel-loader'
            }
        ]
    }
};

module.exports = config;
