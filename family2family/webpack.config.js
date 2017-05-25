var webpack = require('webpack');
var path = require('path');

var dir = "./";

var ROOT_BUILD_DIR = path.resolve(dir, 'src/main/resources/static/build');
var ROOT_APP_DIR = path.resolve(dir, 'src/main/web');

/**
 * A helper function for generating a new bundled js file based on a configuration name.
 *
 * This expects a react file to exist at the location:
 * <pre>
 * ./src/main/web/[CONFIG]/[CONFIG].jsx
 * </pre>
 *
 * The webpack command will package up the jsx file in a single js file at:
 * <pre>
 * ./src/main/static/build/[CONFIG]/[CONFIG]-bundle.js
 * </pre>
 *
 * When using the resulting file in an html file, import it as:
 * <pre>
 * <script type="text/javascript" src="../static/build/[CONFIG]/[CONFIG]-bundle.js" th:src="@{/build/[CONFIG]/[CONFIG]-bundle.js}"></script>
 * </pre>
 *
 * Adding the static src attribute will allow us to view the html file directly, without the server running.
 *
 * @param configName the name of the configuration given to the module. This should probably match the html page as well
 * for consistency purposes.
 * @returns a module for exporting
 */
function getConfig(configName) {
    var configSourceDir = ROOT_APP_DIR + '/' + configName + '/';
    var configBuildDir = ROOT_BUILD_DIR + '/' + configName + '/';
    return {
        entry: [configSourceDir +  configName + '.jsx'],
        output: {
            path: configBuildDir,
            filename: configName + '-bundle.js'
        },
        module: {
            loaders : [
                {
                    test : /\.jsx/,
                    include : configSourceDir,
                    loader: 'babel-loader'
                }
            ]
        }
    }
}

//To add additional configs, just add them to the list here. The naming convention will have to line up.
var configurations = ['test'];

var exports = [];
for (var i = 0; i < configurations.length; i++) {
    exports.push(getConfig(configurations[i]));
}

module.exports = exports;
