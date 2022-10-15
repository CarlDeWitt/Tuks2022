import React from "react";
import ReactDOM from "react-dom";

import { UserList} from "./components/UserList";

var users = [
	{username: "DanielIsCool", name: "Daniel",surname: "Daniels", age: "23"},
	{username: "Username123", name: "Bob",surname: "Dabuilder", age: "25"},
	{username: "NotWilliam", name: "William",surname: "Anderson", age: "24"},
	{username: "IDontNodeWhatImDoing", name: "Tom",surname: "Garfield", age: "24"},
	{username: "BillieEyelash", name: "Michael",surname: "Scarn", age: "27"},
	{username: "MomsSpaghetti", name: "Marshall",surname: "Matters", age: "49"},
	{username: "Hugo", name: "Glen",surname: "Coco", age: "17"}
];  

ReactDOM.render(
  <UserList users={users}/>,
  document.getElementById("root")
);
