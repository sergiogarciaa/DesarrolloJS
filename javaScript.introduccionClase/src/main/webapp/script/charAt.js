function char(){
	let text = prompt("Introduce una frase");
	for(let i = 0; i < text.length; i++){
		document.write(text.charAt(i) + "<br>");
	}
	
}

