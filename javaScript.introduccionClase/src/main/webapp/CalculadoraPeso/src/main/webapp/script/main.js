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