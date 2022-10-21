const express = require("express");
const app = express();
const http = require("http").Server(app);
const { MongoClient } = require("mongodb");
const uri =
  "mongodb+srv://Carl:C%40llaDW2022@demo.akcfpk9.mongodb.net/?retryWrites=true&w=majority";
const client = new MongoClient(uri);
// import "regenerator-runtime/runtime";

async function runFindQuery(collection, query, options) {
  try {
    await client.connect();
    const database = client.db("DBExample");
    const col = database.collection(collection);
    const cursor = col.find(query, options);
    return await cursor.toArray();
  } finally {
    await client.close();
  }
}

http.listen(3000, async () => {
  let results = await runFindQuery(
    "collection",
    { position: "student" },
    { projection: "name" }
  );
  //   console.log(results);
  // do something with results
  console.log("listening on *:3000");
});
