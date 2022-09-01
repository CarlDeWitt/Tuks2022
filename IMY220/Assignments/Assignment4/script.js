$("document").ready(function(){
    $(".submit").on("click", function(){
        /**
         * @description: Task 1
         * @Todo
         * All your messages should be added to the div with the class of “messages” and “row”. </
         * 
             After doing this, you will need to add a new div element. This element must be added on top of 
            the div with the class of “messages”. </
         *
            This newly added div must take up a third of the width of the row and it will also need an offset </
         *
            of a third of the width of the row. It must be rounded, and it must also have a bottom margin. </
         *
            The value of this div will be the value of the text area with the id of “message”. If this value is 
            empty, then a message should NOT be added. </
         * @Bonus none
         */   
        
        /**
         * @description: Task 2
         * @Todo
         * If a link is detected an iframe needs to be appended to your message. The Width of this iframe 
            must be 100% (i.e., it fills up the entire column that it's in) and the height can be set as 315px. 

         *
            You must still be able to have text before and after the YouTube video link (like the screenshots 
            below). I recommend using Regex for this, but any form of string manipulation can be used. 
         *
            Please note that you will need to run the assignment on a XAMPP environment (i.e., run it on 
            localhost like with php) because of CORS errors. 
         *
            Hint: if you want to see the properties that are needed for an iframe, go onto a YouTube video 
            and select share. You will see an option for “embed” and it will provide you with the code for an 
            iframe.
         * 
         * @Bonus 
         */
        const msg = $("#message").val();   
        const pattern = /https:\/\/www.youtube.com/;
        if(msg.match(pattern)){
            const startPosition = msg.search("https://www.youtube.com/");
            // console.log('position: ' + position);
            const msg1 = msg.substring(startPosition);
            const endPosition = msg1.search(" ");
            let msg2 = msg1.substring(0, endPosition);//has  the youtube link in here
            // console.log(msg2);
            msg2 = msg2.replace("watch?v=", "embed/");       
            console.log(msg2);
             

            $(".messages.row").prepend("<div class='col-md-4 offset-4 msgs'>" + msg + "<iframe width='100%' height='315' src='" + msg2 + "' title='YouTube video player' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe></div>");   
                
        }else{
            if(msg !== ""){    
                $(".messages.row").prepend("<div class='col-4 offset-4 msgs'>" + msg + "</div>");  
            }
        }
        $(".msgs").css({
            borderRadius: "10px",
            marginBottom: "20px",
        });
        
    });
});