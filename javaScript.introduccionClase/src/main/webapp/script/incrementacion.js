/**
incrementa la siguiente variable en 5:
      let numero = 12;
Decrementa el resultado de la variable anterior en 1.
Simplifica esta operación utilizando el operador adecuado:
     let multiplicacion = 10 * 10 * 10 * 10 * 10;
Obtén el resto de 57409 dividido entre 16789.
 */
function uno(){
	let numero = 12;
numero += 5;
document.write(numero);
numero -= 1;
document.write(numero);
}

function dos(){
	let multiplicacion = 10**5;
	let resto = 57409;
	resto %= 16789;
	document.write(multiplicacion);
	document.write('<hr>')
	document.write(resto);
}
function log(){
	let a = 3;
	console.log(a **= 2);
	console.log(a **= 0);
	console.log(a **= 'hello');
}