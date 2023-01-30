function tiposEstrategias(){
	function alumno(nombre, apellidos, edad){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;	
	}
		var AlumnoUno = new alumno('Sergio', 'Garcia', 20)
		document.write(typeof(AlumnoUno));
		document.write(AlumnoUno instanceof Object);
		document.write(AlumnoUno instanceof alumno);
}