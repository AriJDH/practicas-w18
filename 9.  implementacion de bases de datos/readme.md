C1 · Implementacion BD
C2 · Storage
C3 · HQL




<h2>Material C2 · Storage </h2>
<h3>OneToMany - ManytoOne: </h3>
https://docs.google.com/presentation/d/1qwJD-4OK_dd20bvUVu3TZBAEoe_kyl_zwVPgdAByx-w/edit?usp=sharing

<h4>The owning side vs the referencing side</h4>
Cuando tenemos relaciones bidireccionales no existen diferencias con la relación unidireccional a nivel BD. 
Sólo definimos las direcciones en nuestro modelo de dominio. 
Para una relación bidireccional tenemos: 

- Owning Side: 
    - En una relación Uno a Muchos definidmos el lado "propietario" del lado "muchos" de la relación y es donde dejamos la clave externa. Para eso usamos @JoinColumn

- Referencing Side: 
    - Para que la asociación sea bidireccional tenemos que definir el lado de la referencia. Podemos usar el atributo mappedBy de @OneToMany para realizar esto. En mappedBy definimos el nombre del atributo de mapeo de asociación en el lado propietario. 


