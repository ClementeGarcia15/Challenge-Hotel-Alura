# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/75176552/236646458-4756e21e-5ecd-4fb9-90df-fa8cbf3734d9.png">
</p>

### Indice

- [Bienvenida](#bienvenido-al-proyecto-hotel-alura)
- [Descripcion](#descripcion)
- [Tecnologías Utilizadas](#%EF%B8%8F-tecnolog%C3%ADas-utilizadas)
- [Importante](#%EF%B8%8F-importante-%EF%B8%8F)
- [Funcionalidad](#funcionalidades)
- [Añadido adicional](#a%C3%B1adido-adicional)
- [Visualizar proyecto](#visualizar-proyecto)
- [Ejecutar proyecto](#ejecutar-proyecto)
- [Desarrollador](#desarrollador)


## ¡Bienvenido al proyecto Hotel Alura!

En este repositorio se mostrara el challenge Hotel Alura y la explicación del funcionamiento del programa

<p align="center" >
     <img width="500" heigth="300" src="https://user-images.githubusercontent.com/75176552/236646458-4756e21e-5ecd-4fb9-90df-fa8cbf3734d9.png">
</p>

## Descripcion
## Este repositorio contiene el código fuente para la solución del desafío de crear una aplicación CRUD utilizando JDBC y Swing. El objetivo del desafío es desarrollar una aplicación que permita realizar operaciones CRUD en una base de datos relacional.
</br>

## 🖥️ Tecnologías Utilizadas.

- Java
- Eclipse
- Biblioteca JCalendar
- MySql
- Plugin WindowBuilder
- Biblioteca C3PO para crear Pool de conexiones
 </br>

---
## ⚠️ Importante! ⚠️

☕ Use Java versión 8 o superior para compatibilidad. [Java](https://www.java.com/en/download/)
</br></br>
📝 Se recomienda usar el editor de Eclipse para compatibilidad con la Interfaz Gráfica. [Eclipse standard](https://www.eclipse.org/downloads/) 
</br></br>
🎨 La interfaz contiene dos métodos importantes:
- setResizable(false): determina el tamaño de la ventana, y a través del parámetro <strong>false</strong>, la pantalla no se puede maximizar;
- setLocationRelativeTo(null): determina la ubicación de la ventana, y a través del parámetro <strong>null</strong> la mantiene centrada en la pantalla.


## Funcionalidades

### Generales
:heavy_check_mark: `Funcionalidad 1:`Sistema de autenticación de usuario para que solo usuarios pertenecientes al hotel consigan acceder al sistema.

:heavy_check_mark: `Funcionalidad 2:` Permitir crear, editar y eliminar una reserva para los clientes.

:heavy_check_mark: `Funcionalidad 3:` Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas.

:heavy_check_mark: `Funcionalidad 4:` Registrar, editar y eliminar datos de los huéspedes.

:heavy_check_mark: `Funcionalidad 5:` Calcular el valor de la reserva en base a la cantidades de días de la reserva y a una tasa diaria que puede ser asignada por ti y en la moneda local de tu país.

:heavy_check_mark: `Funcionalidad 6:` Base de datos para almacenar todos los datos pedidos anteriormente. <br><br>
En este caso se creo un programa simple para crear base de datos y tablas con su respectiva informacion (filas, columnas, etc..). 
<br>
Un ejemplo de esto es el siguente.

1.- Primero se abrira una ventana de inicio de sesion para conectar con el servidor. 
    Se pedira los siguientes datos:
 * La url en mi caso (jdbc:mysql://localhost:3306)
 * El nombre de la base de datos. si no haz creado una anteriormente deja en blanco este campo.
 * El usuario de la base de datos.
 * Y la contraseña. 
<br>

Click [Aqui](#iniciar-sesion-en-el-servidor) para mirar imagen.

<br>

2.- En caso de que no tegas base de datos se abrira otra ventana donde te pedira un nombre para tu base de datos.

<br>

Click [Aqui](#creando-base-de-datos) para mirar imagen.

<br>

3.- Una vez que hayas creado la base de datos se te volvera a abrir la ventana de Inicio de sesion.

<br>

Click [Aqui](#iniciar-sesion-en-el-servidor) para mirar imagen.

<br>

4.- y ahora se abrira otro ventana en donde crearas tu tabla utilizando la base de datos que haz hecho.

<br>

Click [Aqui](#creando-tabla-utilizando-la-base-de-datos-creada-o-existente) para mirar imagen.

<br>


listo haz creado una base de datos con su tabla y parametros. 😀 

<br>

### Añadido adicional

:heavy_check_mark: `Funcionalidad 1:` Aplicacion para crear base de datos y tablas.<br>

## INICIAR SESION EN EL SERVIDOR
<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/75176552/236652548-00b092ab-ce72-4745-9869-3eed455a4bbe.png">
</p>
<br>

## CREANDO BASE DE DATOS.
<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/75176552/236652602-5caf77df-f2ff-4c3c-a6da-c7e054c6360b.png">
</p>

## CREANDO TABLA UTILIZANDO LA BASE DE DATOS CREADA O EXISTENTE
En este caso ya se a creado la base de datos "escuela" y se esta creando la tabla "alumnos" con la informacion adecuada (id, nombre, fecahNacimiento, etc..)

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/75176552/236653027-44c6a421-caa6-4288-abd2-8137d52f2fcd.png">
</p>

:heavy_check_mark: `Funcionalidad 2:` Se añadio boton de cerrar aplicacion tanto para Login como para Menu Principal. <br>
LOGIN.
<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/75176552/236645628-164bdb69-9a1d-48b4-9b0e-ca7a0b78e79c.png">
</p>
MENU PRINCIPAL.

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/75176552/236649386-c00b785d-41f6-416b-876b-6246447136f8.png">
</p>

Tambien se añadio boton de Cerrar sesion en el MenuUsuario.
<p align="center" >
     <img width="500" heigth="300" src="https://user-images.githubusercontent.com/75176552/236649538-92437034-fc47-43f4-b05c-8ac8dd541c89.png">
</p>

:heavy_check_mark: `Funcionalidad 3:` Crear usuario. Se añade nueva ventana de Registro de usuario. 

Primero se notifica al Cliente si quiere crear un usuario.
<p align="center" >
     <img width="500" heigth="300" src="https://user-images.githubusercontent.com/75176552/236647762-835ea2be-d65f-466f-8fef-df0f6314ce42.png">
</p>

En caso de que si. Se visualizara la ventana de Registro de Usuario.

<p align="center" >
     <img width="500" heigth="300" src="https://user-images.githubusercontent.com/75176552/236648617-0ed3b0f4-5f78-4448-b69a-a17f560a3a9d.png">
</p>

Se verifica si el usuario y contraseña no sean nulos.

<p align="center" >
     <img width="500" heigth="300" src="https://user-images.githubusercontent.com/75176552/236648727-7e4b1f00-6144-44db-926e-aaf91c2983c4.png">
</p>

:heavy_check_mark: `Funcionalidad 4:` Se añadieron nuevas ventanas que simulan la creacion de un usuario, cierre de sesion y cerrando aplicacion (se utilizo el mismo diseño para agilizar la creacion de estas ventanas).

CREACION DE USUARIO. Aqui se notifica que usuario se creo en este caso es: admin.

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/75176552/236649245-5ef7b60a-41a3-436b-a576-d85cce55d1e4.png">
</p>

CIERRE DE SESION
<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/75176552/236648170-878d602e-8eb9-4b35-be97-40b896d9f34b.png">
</p>
CERRANDO APLICACIOn

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/75176552/236648156-34dc018e-5d1e-419e-b3cb-305becbfd7a6.png">
</p>

:heavy_check_mark: `Funcionalidad 5:` Iniciar sesion con el usuario registrado.
<p align="center" >
     <img width="500" heigth="300" src="https://user-images.githubusercontent.com/75176552/236647364-6410e2ad-9205-43b0-b53d-5a135f26ff62.png">
</p>

:heavy_check_mark: `Funcionalidad 6:` Verificar si el usuario exite (en este caso se notificara que el usuario o contraseña son incorrectos)

<p align="center" >
     <img width="500" heigth="300" src="https://user-images.githubusercontent.com/75176552/236646988-fd7492dd-c2aa-4296-9c14-484f46c77aba.png">
</p>

## Visualizar proyecto
Ver el proyecto. Click [Aqui](https://github.com/ClementeGarcia15/Challenge-Hotel-Alura)

## Ejecutar proyecto

1.- Descarga el proyecto desde [Aqui](https://github.com/ClementeGarcia15/Challenge-Hotel-Alura/archive/refs/heads/main.zip)
<br>
2.- Una vez descargado el proyecto y descomprimido abre eclipse e importalo 


## DESARROLLADOR
💙 <strong>Clemente Garcia</strong></br>
<a href="https://www.linkedin.com/company/alura-latam/mycompany/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
