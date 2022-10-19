var ti = document.getElementById("title");
var p = document.getElementById("body");
const allin = document.querySelector("#display");
function getUpdateXML(){
    chr = new XMLHttpRequest();
    

    chr.open('GET',"./update.rss")

    chr.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var res = chr.response;
            console.log(res);
            parser = new DOMParser();
            res = parser.parseFromString(chr.response,"text/xml");
            console.log(res);
            var data = res.getElementsByTagName("item");
            
            // console.log("------------T--------------");
            for(var i =0;i< data.length;i++){
                console.log(data[i].getElementsByTagName("title")[0].innerHTML);
                console.log(data[i].getElementsByTagName("description")[0].innerHTML);
                console.log(data[i].getElementsByTagName("link")[0].innerHTML);
            }
            //     // console.log(data[i].getElementsByTagName("title")[0].innerHTML);
            //     // console.log(data[i].getElementsByTagName("description")[0].innerHTML);
            //     // console.log(data[i].getElementsByTagName("link")[0].innerHTML);
            
            //     var title = data[i].getElementsByTagName("title")[0].innerHTML;
            //     var body = data[i].getElementsByTagName("description")[0].innerHTML;
            //     var link = data[i].getElementsByTagName("link")[0].innerHTML;
            
            //     var ttag = document.createElement('a');
            //     ttag.href = link;
            //     var ttexttag = document.createTextNode(title);
            //     ttag.appendChild(ttexttag);
            //     allin.appendChild(ttag);
            
            //     //p
            //     var ptag = document.createElement('p');
            //     var ptexttag = document.createTextNode(body);
            //     ptag.appendChild(ptexttag);
            //     allin.appendChild(ptag);

            //     // /hr
            //     allin.appendChild(document.createElement('hr'));
            // }          
         }
    }

    chr.send();
}

function getJSON(){
    xhr = new XMLHttpRequest();

    xhr.open('GET',"./update.json")

    xhr.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
        
        var response = JSON.parse(xhr.response);
        // console.log(response['items']);
        // response = response['items'];
        // for(var i=0; i < response.length; i++){

        //     var title = response[i].title;
        //     var body = response[i].description;
        //     var link = response[i].link;
            
        //     //h1
        //     var ttag = document.createElement('a');
        //     var ttexttag = document.createTextNode(title);
        //     ttag.href = link;
        //     ttag.appendChild(ttexttag);
        //     allin.appendChild(ttag);
            
        //     //p
        //     var ptag = document.createElement('p');
        //     var ptexttag = document.createTextNode(body);
        //     ptag.appendChild(ptexttag);
        //     allin.appendChild(ptag);
            
        //     // /hr
        //     allin.appendChild(document.createElement('hr'));
        // }
    }
    }

    xhr.send();
}

function callfunctions(){
    getUpdateXML();    
    getJSON();
}
callfunctions();

// window.setInterval(callfunctions,1000);