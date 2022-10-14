"use strict";

var _express = _interopRequireDefault(require("express"));
function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { "default": obj }; }
//CREATE APP
var app = (0, _express["default"])();

//SERVE A STATIC PAGE IN THE PUBLIC DIRECTORY
app.use(_express["default"]["static"]("public"));

//PORT TO LISTEN TO
app.listen(1337, function () {
  console.log("Listening on localhost:1337");
});