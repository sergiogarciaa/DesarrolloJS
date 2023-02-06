function alumno(){
	function alumnoconf(nombre, apellidos, edad){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	var alumno1 = new alumnoconf('Antonio', 'Garcia', '19');
	document.write(typeof(alumno1));
	document.write(alumno1 instanceof Object);
	
	document.write(alumno1.nombre);
	document.write(alumno1.apellidos);
	document.write(alumno1.edad);
	/* SEGUNDO ALUMNO */
	var alumno2 = new alumnoconf('Andrea', 'Medina', '19');
	document.write(typeof(alumno2));
	document.write(alumno2 instanceof Object);
	
	document.write(alumno2.nombre);
	document.write(alumno2.apellidos);
	document.write(alumno2.edad);
	
}