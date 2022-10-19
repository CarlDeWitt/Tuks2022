var express = require('express');
var bodyParser = require('body-parser');
var fs = require('fs');

var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extend: false}))
var routes = require('./routes.js')(app,fs);

var port = process.env.PORT || 3000;
app.listen(port);
console.log("server listening on port " + port);

/*[
    {
       "id": 2,
        "name": "Paper",
        "price": 12.50
    },
    {
        "id": 3,
        "name": "Rock",
        "price": 25.50
    },
    {
        "id": 4,
        "name": "Scissors",
        "price": 20.50
    }
]*/

app.get('/data', (req, res) => {
    fs.readFile(dataFile, (err, rdata) => {
        if(err){
            throw err;
        }
        res.send(JSON.parse(rdata));
    })
})

app.get('/data/:id', (req, res) => {
    fs.readFile(dataFile, (err, rdata) => {
        if(err){
            throw err;
        }
        // console.log(req.params["id"].substring(1));
        // console.log(parseInt(req.params["id"].substring(1)));
        var id =parseInt(req.params["id"]);
        var jdata = JSON.parse(rdata);
        console.log(jdata);
        var i;
        var checker = false;
        for(i = 0; i < jdata.length; i++){
            // console.log(id);
            if(jdata[i]["id"] === id){
                // console.log(jdata[i]);
                res.send(JSON.stringify(jdata[i]));
                checker = true;
            }
            
        }
        if(i == jdata.length && checker == false){
            res.send(null);
        }
    })
})

app.post('/data', (req, res) => {
    // console.log(req.body.id);
    if(req.body.length != 0){
        var id = req.body.id;
        var name = req.body.name;
        var price = req.body.price;
        var newObj;
        // res.send(req.body);

        fs.readFile(dataFile, (err, rdata) => {
            if(err){
                throw err;
            }
            // console.log(req.body);
            newObj = JSON.parse(rdata);
            newObj[newObj.length] = req.body;
            
            fs.writeFile(dataFile,JSON.stringify(newObj), (err) => {
                if(err)
                throw err;
            })

            res.send(newObj);
        });


    }else{
        res.send("why u null check me huh");
    }
})

app.put('/data/:id', (req, res) => {
    if(req.body.length != 0){
        var getid = parseInt(req.params["id"]);
        // console.log(getid);
        var id = req.body.id;
        var name = req.body.name;
        var price = req.body.price;
        // res.s?end(req.body);

        fs.readFile(dataFile, (err, rdata) => {
            if(err){
                throw err;
            }

            var jdata = JSON.parse(rdata);
            var i;
            var checker = false;
            for(i = 0; i < jdata.length; i++){
                // console.log(id);
                if(jdata[i]["id"] === getid){
                    // console.log("here");
                    jdata[i]['id'] = parseInt(id);
                    jdata[i]['name'] = name;
                    jdata[i]['price'] = parseInt(price);
                    checker = true;
                    res.send(jdata);
                    break;
                }
                
            }
            if(i == jdata.length && checker == false){
                res.send(null);
            }

            fs.writeFile(dataFile,JSON.stringify(jdata), (err) => {
                if(err)
                throw err;
            })
        });
    }else{
        res.send("why u null check me huh");
    }
})

app.delete('/data/:id', (req, res) => {
    var jdata;
    fs.readFile(dataFile, (err, rdata) => {
        if(err){
            throw err;
        }
        // console.log(jdata);
        // console.log("after splice");
        var id =parseInt(req.params["id"]);
        jdata = JSON.parse(rdata);
        for(var i = 0; i < jdata.length; i++){
            if(jdata[i]["id"] == id){
                jdata.splice(i,1);
            }
        }

        // console.log(jdata);
    
        fs.writeFile(dataFile,JSON.stringify(jdata), (err) => {
            if(err)
            throw err;
        })
        fs.readFile(dataFile, (err, rdata) => {
            if(err){
                throw err;
            }
            res.send(JSON.parse(rdata));
        })
        
    })    
})