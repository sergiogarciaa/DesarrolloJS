/**
 * Construye el objeto de tipo persona con los siguientes campos: nombre, apellidos, edad y fecha de nacimiento. Dale a la fecha de nacimiento un valor en formato adecuado para poder pasar de string a date.
 * Cuando tengas el objeto, opten el tipo de dato que es y verifica que es un tipo persona.
 */

function persona(){
    function personaconf(nombre, apellidos, edad, fechaNacimiento){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    const personaconf1 = new personaconf('Hass', 'Garcia', '19', new Date('2000-02-16'));
    document.write(typeof(personaconf1) + " Tipo <br>");
    document.write(personaconf1 instanceof Object);

    document.write(personaconf1.nombre);
    document.write(personaconf1.apellidos);
    document.write(personaconf1.edad);
    document.write(personaconf1.fechaNacimiento);
}