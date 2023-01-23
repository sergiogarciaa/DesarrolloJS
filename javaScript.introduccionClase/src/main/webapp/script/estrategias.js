function tipo(){
	let variable1 = 10;
     let variable2 = 5.3;

      document.write(typeof(variable1));
      document.write(typeof variable2);
}
function buleano(){
	 let es = true;
     document.write(typeof(es));
     document.write(es);
}
function numero(){
	 let variable1 = 10;
     let variable2 = 5.3;

	  document.write(typeof(variable1));
	  document.write(typeof variable2);
}
function grande(){
	 let numeroGrande = 4567891324657987654;
     let numeroGrandeCasteado = BigInt(987654321654987654);

     document.write(typeof(numeroGrande));
     document.write(numeroGrande);
     document.write(typeof(numeroGrandeCasteado));
    document.write(numeroGrandeCasteado);
}
function indef(){
	 let variableVacia;
     document.write(variableVacia);

     document.write(typeof(variableVacia));
}


