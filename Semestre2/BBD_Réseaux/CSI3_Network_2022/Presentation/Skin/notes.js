
displayNotes();
var addBtn = document.getElementById('addBtn');


// Get url
function urlScores(){
    let urlName = window.location.href;                     // get current url
    let regex=/(#sitenav_[0-9]*)/ig;                        // remove #sitenav_
    urlName = urlName.replace(regex,"");
    return urlName;                                         // return url
}


// below event listener will add user input into the local storage
addBtn.addEventListener('click',function(){
	
	let notesObj;
	let addNote = document.getElementById('addNote');
	let notesString = localStorage.getItem('notes');
	
	if(notesString == null){
		notesObj = [];
	}
	else{
		notesObj = JSON.parse(notesString);
	}
	
	//Add date
	let now = new Date();
	let dateTime = `${now.getDate()}-${now.getMonth()+1}-${now.getFullYear()} | ${now.getHours()}:${now.getMinutes()}`;
//	let urlName = window.location.href
	let urlName = urlScores();                              // get url
    
	//pushing into local storage
	let tempObj = { text: addNote.value, time: dateTime, url: urlName };
	
	notesObj.push(tempObj);
	localStorage.setItem('notes',JSON.stringify(notesObj));
	
	addNote.value = '';
	
	displayNotes();
});


// funtion to display data stored in the local storage
function displayNotes(){
	let notesObj;
	let notesString = localStorage.getItem('notes');
	
	if(notesString == null){
		notesObj = [];
	}
	else{
		notesObj = JSON.parse(notesString);
	}
	
	let html = '';
	
	notesObj.forEach(function(element,index){
//        let urlNameSearch = window.location.href;
        let urlNameSearch = urlScores();                              // get url
        
        if(urlNameSearch.includes('index.html')){
            urlNameSearch = urlNameSearch.replace('index.html','');
        
            if(element.url.includes(urlNameSearch)){
                html += `
                    <div class="card mx-1 my-1 bg-white text-black thatsMyNote" style="width: 16rem;">
                        <div class="card-body">

                            <p class="card-text"><a href="${element.url}" target="_blank">Lien</a>&nbsp;&nbsp;&nbsp;${element.text.replace(/</g, "&lt;").replace(/>/g, "&gt;")}</p>
                            <button style="height:25px;width:120px;background-color: white" id="${index}" onclick=deleteNote(this.id) class="btn btn-outline-danger"><h6 style="color: black; font-size:10px;">Supprimer la note</h6></button>
                        </div>
                    </div>
                `;
            }
        }
        else{          
            if (urlNameSearch == element.url){
        
                html += `
                    <div class="card mx-1 my-1 bg-white text-black thatsMyNote" style="width: 16rem;">
                        <div class="card-body">

                            <p class="card-text">${element.text.replace(/</g, "&lt;").replace(/>/g, "&gt;")}</p>
                            <button style="height:25px;width:80px;background-color: white" id="${index}" onclick=deleteNote(this.id) class="btn btn-outline-danger"><h6 style="color: black; font-size:10px;">Supprimer</h6></button>
                        </div>
                    </div>
            `;
            }
        }
	});
	
	let noteEle = document.getElementById('notesList');
	
	if(notesObj.length != 0){
		noteEle.innerHTML = html;
	}
	else{
		noteEle.innerHTML = '<h4 style="text-align: center; color: grey;">Aucune note</h4>';
	}	
}


//function to delete a note
function deleteNote(index){
	let notesObj;
	let notesString = localStorage.getItem('notes');
	
	if(notesString == null){
		notesObj = [];
	}
	else{
		notesObj = JSON.parse(notesString);
	}
	
	notesObj.splice(index,1);
	localStorage.setItem('notes',JSON.stringify(notesObj));
	
	displayNotes();
}



let search = document.getElementById('searchNote');
search.addEventListener('input',function(e){
	
	let inputText = search.value;
    
	
	//below statement will be executed when the search bar is emptied using backspace
	if(inputText == ''){
		document.getElementById('noNotesMatches').innerHTML = '';
	}
	
	var countNone = 0;
	
	let cards = document.getElementsByClassName('thatsMyNote');
	
	
	Array.from(cards).forEach(function(ele){
		let cardText = ele.getElementsByTagName('p')[0].innerText;
		if(cardText.includes(inputText)){
			ele.style.display = 'block';
		}
		else{
			ele.style.display = 'none';
			
			countNone++;
			
			if(countNone === cards.length){
				document.getElementById('noNotesMatches').innerHTML = '<h6 style="text-align: center; color: black; font-size:12px;">Aucune note identifiée</h6>';
			}
			else{
				document.getElementById('noNotesMatches').innerHTML = '';
			}
		}
	});
	
	//Below code will be executed when the input text matches all the elements.
	if(countNone === 0){
		document.getElementById('noNotesMatches').innerHTML = '';
	}
	
});
