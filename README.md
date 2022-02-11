# Portero-local
Control de aforo de un local
En un local comercial se quiere controlar el aforo de las personas en cada momento,
este local tiene un aforo máximo permitido de 31 personas.
Utilizando lo visto en clase hasta ahora, debes modelar el comportamiento del
edificio, usando hilos que simulen personas que entran o salen. Al menos debes
desarrollar las siguientes clases:
Una clase para modelar el local, con su aforo máximo y el aforo en determinado
momento.
Una clase para modelar una persona, que entra al edificio y permanece 1 segundo
para después salir del edificio y que se utilizará para lanzar hilos (más hilos que el
aforo permitido).
Una clase “portero” que lleva la cuenta de las personas que han entrado al local en
total durante la jornada y las que en cada momento están dentro sin que se supere
el aforo máximo permitido (por supuesto, tampoco puede haber un número negativo
de personas en el local).
