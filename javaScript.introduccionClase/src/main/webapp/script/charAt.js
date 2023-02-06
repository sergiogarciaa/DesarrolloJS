function separar(){
    let palabra = prompt("Introduce una palabra: ");
    let palabraFinal="";
    for(var i=0;i< palabra.length;i++){
        palabraFinal += palabra[i] + "|";
    }
    alert(palabraFinal);
}
