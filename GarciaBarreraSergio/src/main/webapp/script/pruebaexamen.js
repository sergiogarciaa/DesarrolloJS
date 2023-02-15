function calculo(){
	var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
	var nDni = "50125892"
	// COMPROBACION DE NÚMERO
	if(nDni < 0 || nDni > 99999999){
		alert("El numero del DNI es incorrecto");
	}
	
	else{
		// CÁLCULO DE LETRA
	
	var lDni = nDni % 23;
	let letraDni;
	
	for(let i = 0; i < letras.length; i++){
		if(i == lDni){
			letraDni = letras[i];
		}
		
	}
	console.log(nDni);
	console.log(letraDni);
	
	document.write(nDni + " - " + letraDni);
	}
}


function calculomalo(){
	var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
	var nDni = "525252424295295258"
	// COMPROBACION DE NÚMERO
	if(nDni < 0 || nDni > 99999999){
		alert("El numero del DNI es incorrecto");
	
	}
	else{
		// CÁLCULO DE LETRA
	
	var lDni = nDni % 23;
	let letraDni;
	
	for(let i = 0; i < letras.length; i++){
		if(i == lDni){
			letraDni = letras[i];
		}
		
	}
	console.log(nDni);
	console.log(letraDni);
	
	document.write(nDni + " - " + letraDni);
	}
	
}