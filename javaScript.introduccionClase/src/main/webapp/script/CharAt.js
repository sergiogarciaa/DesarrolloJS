function charAt(){
	letra = prompt("Introduce una palabra o frase");
	for(let i = 0; i<letra.length; i++){
		document.write(letra.charAt(i) + "<br>");
	}
}