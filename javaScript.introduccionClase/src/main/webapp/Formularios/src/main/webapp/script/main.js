/**
 * 
 */
function guardar(){
    let numero = document.getElementsByName('valor')[0].value;
    let descuento = numero * 0.3
   
    document.write("Con el 30% de descuento seria: " + (numero - descuento));
    console.log("Con el 30% de descuento seria: " + (numero - descuento));
}

function calculadora(form){
	let calculo = form.operacion.value;
	form.resultado.value = eval(calculo);
}

function calculadoraPeso(form){
	let edad = form.edad.value;
	let altura = form.altura.value;
	let sexo = form.sexo.value;
	
	if(sexo === "hombre"){
		form.peso.value = eval(50+((altura-150)/4)*3 + (edad - 20)/4);
	}
	else if(sexo === "mujer"){
		form.peso.value = eval((50+((altura-150)/4)*3 + (edad - 20)/4)*0.9);
	}
}