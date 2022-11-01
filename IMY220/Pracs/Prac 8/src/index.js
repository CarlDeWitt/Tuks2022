import React from "react";
import ReactDOM from "react-dom";
import { EnrolmentList } from "./components/EnrolmentList";
import { io } from "socket.io-client";

const getDATA = () => {
  const socket = io("http://localhost:3000");
  socket.on("data", (data) => {
    console.log(data);
    ReactDOM.render(
      <div>
        <EnrolmentList codes={data} />
      </div>,
      document.getElementById("root")
    );
  });
};
getDATA();
