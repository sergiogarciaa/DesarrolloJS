function temp(){
	ventana = window.open("","ventana","width=200,height=100");
    cerrar = setTimeout(function(){
		ventana.close();
		}, 1000);
}
