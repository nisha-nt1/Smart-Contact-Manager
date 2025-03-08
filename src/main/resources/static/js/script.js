console.log("this is script fielde")

const toggleSidebar = () => {
	 console.log("Toggle sidebar function called");  // Check if the function is called
    if ($('.sidebar').is(":visible")) {
        // Hide the sidebar and adjust the content
        $(".sidebar").css("display", "none");
        $(".content").css("margin-left", "0%");
    } else {
        // Show the sidebar and adjust the content
        $(".sidebar").css("display", "block");
        $(".content").css("margin-left", "20%");
    }
};

/*const search = () => {
	
	let query = $("#search-input").val();
	
	
	if(query ==' '){
		$(".search-result").hide();
	}else{
		console.log(query);
		
		let url = 'http://localhost:8080/search/${query}';
		
		fetch(url).then((response) => {
			return response.json();
		}).then((data) =>{
			console.log(data);
			
			let text = `<div class='list-group'>`;
			
			data.forEach((contact) =>{
				
				text+=`<a href='/user/${contact.cId}/contact' class='list-group-item-group-action'> ${contact.name}</a>`
			});
			
			text+=`</div>`
			
			$(".search-result").html(text);
			$(".search-result").show();
		});
		
		
	}
};*/



const search = () => {
    let query = $("#search-input").val().trim(); // Ensure query is trimmed
    
    if (query === '') {
        $(".search-result").hide();
    } else {
        console.log(query);
        
        let url = `http://localhost:8080/search/${query}`; // Use backticks for string interpolation
        
        fetch(url)
            .then((response) => {
                if (response.ok) {
                    return response.text(); // Get the response as text
                } else {
                    throw new Error('Network response was not ok.');
                }
            })
            .then((text) => {
                if (text) {
                    return JSON.parse(text);
                } else {
                    return []; // Return an empty array if there's no data
                }
            })
            .then((data) => {
                //console.log(data);
                
                let resultHTML = `<div class='list-group'>`;
                
                if (data.length > 0) {
                    data.forEach((contact) => {
                        resultHTML += `<a href='/user/${contact.cId}/contact' class='list-group-item list-group-item-action'> ${contact.name}</a>`;
                    });
                } else {
                    // Display a message if no results are found
                    resultHTML += `<div class='list-group-item'>No contacts found</div>`;
                }
                
                resultHTML += `</div>`;
                
                $(".search-result").html(resultHTML);
                $(".search-result").show();
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
};


