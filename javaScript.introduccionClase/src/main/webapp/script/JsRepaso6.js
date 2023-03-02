/** Crea un programa que solicite dos números y devuelva el mayor de los dos en un elemento alert.
 *  Convierte los datos introducidos a números antes de comenzar a operar con ellos.
**/

let n1 = prompt("Introduce un numero");
let n2 = prompt("Introduce otro numero");

if (n1 > n2){
    document.write(n1 + " Es mayor que " + n2);
}
else{
    document.write(n2 + " Es mayor que " + n1);
}