/* Caso 2*/

function ej1(){
	var a = 6;
	var b = 9;
	
	if (a === 6) {
	  let a = 3;
	  let b = 4;
	 
	document.write(a + "<br>");
	document.write(b + "<br>");
	}
	document.write(a + "<br>");
	document.write(b);
}

/*<!-- caso2- Crea un objeto de tipo coche con las propiedades marca y matricula.
       Define una variable con los valores específicos tuyos.

       Verifica que es un tipo objeto y que es un tipo coche.
       Muestra en el navegador el valor de las dos propiedades. -->*/

function tipocoche(){
	function coche(marca, matricula){
		this.marca = marca;
		this.matricula = matricula;	
	}
		var cochenuevo = new coche('Mercedes', '75443-CDG')
		document.write(typeof(cochenuevo));
		document.write(cochenuevo instanceof Object);
		document.write(cochenuevo instanceof coche);
		document.write("<br>" + cochenuevo.marca + " " + cochenuevo.matricula);		
}