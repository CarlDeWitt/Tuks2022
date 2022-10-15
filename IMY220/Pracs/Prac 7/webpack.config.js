const path = require("path");
module.exports = {
  // Since our index.js file is going to render all the JSX, we provide a path to that file
  entry: "./src/index.js",
  // we want the resulting bundle to be exported in the public directory as a new file named bundle.js
  output: {
    path: path.resolve("public"),
    filename: "bundle.js",
  },
  mode: "development",
  // rules it has to follow for transformations
  module: {
    rules: [
      {
        // test tells Webpack to only bundle .js files(We can change the regex to specify other file extensions, such as .jsx)
        test: /\.js$/,
        // exclude tells Webpack not to bundle the files inside the node_modules directory (which would have made the bundling process very slow)
        exclude: /node_modules/,
        // use tells Webpack what plugin, loader, etc. to use for the files we specified
        // In this case, we are telling it to use babel-loader to transpile all .js files
        use: {
          loader: "babel-loader",
        },
      },
    ],
  },
};
