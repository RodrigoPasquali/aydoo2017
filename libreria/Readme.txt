Modelar la suscripcionAnual con un boolean puede ir en contra del principio open-close 
�como impactaria en tu c�digo si ponemos producto con suscripci�n trimestral?
-Para solucionar dicho problema habria que aplicar un patron de dise�o como chains of responsability, 
 para que en caso de agregarse algun otro tipo de suscripcion, solo se cree una clase nueva y se modifica 
 la ultima clase de la cadena de responsabilidades para que apunte a la creada recientemente

El diagrama de clases pone en evidencia una situaci�n rara del modelo: libro, 
revista y peri�dico no tienen m�todos ni atributos propios �no te resulta llamativo? �que justificaci�n encontr�s?
-Estas clases no deberian existir ya que no suman nada al programa, en vez de existir estas clases tal vez
 bastaria solo con agregar un atributo a la clase Producto donde se indico que es un libro, una revista, o lo que fuere.

Diagrama de Secuencia 
-Diagrama de Secuencia modificado pero con dudas de como se representaria un if o el return
-Se asume que la clase Libro, Periodico y Revista no existen, como se comento en respuesta anterior.