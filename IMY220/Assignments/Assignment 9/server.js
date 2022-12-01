import express from "express";
import http from "http";
import socketIo from "socket.io";
import "regenerator-runtime/runtime";
const app = express();

import { MongoClient } from "mongodb";
const uri =
  "mongodb+srv://Carl:C%40llaDW2022@demo.akcfpk9.mongodb.net/?retryWrites=true&w=majority";
// remeber to install socket.io-cleint
const client = new MongoClient(uri);

//SERVE A STATIC PAGE IN THE PUBLIC DIRECTORY
app.use(express.static("public"));
const server = http.createServer(app);
const io = socketIo(server);

server.listen(3000, async (err) => {
  // let results = await runFindQuery(
  //   "academicRecord",
  //   {},
  //   { projection: { name: 1, code: 1, _id: 0 } }
  // );
  let results = await runFindQuery(
    "academicRecord",
    {},
    {}
  );
  results.map((data) => {
    console.log(data);
  });
  io.on("connection", (socket) => {
    socket.emit("data", results);
  });
  console.log("Listening on localhost:3000");
});

async function runFindQuery(collection, query, options) {
  try {
    await client.connect();
    const database = client.db("Exam");
    const col = database.collection(collection);
    const cursor = col.find(query, options);
    return await cursor.toArray();
  } finally {
    await client.close();
  }
}
