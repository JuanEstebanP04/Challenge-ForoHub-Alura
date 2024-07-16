# Challenge ForoHub Alura Latam
Este repositorio contiene el código del proyecto desarrollado para el Alura Challenge Latam de SpringBoot, donde se presenta una solución innovadora para construir un el backend para un foro: Forohub. En este reto se ponen a prueba los conocimientos para crear una API REST usando Spring. Nuestra API se centra específicamente en los tópicos, y permitir a los usuarios:

- Crear un nuevo tópico
- Mostrar todos los tópicos creados
- Mostrar un tópico específico
- Actualizar un tópico
- Eliminar un tópico

Ademas de las permitir estas acciones, la API tambien cuenta con las siguientes funcionalidades:
- Validaciones realizadas según las reglas de negocio
- Implementación de una base de datos relacional para la persistencia de la información
- Servicio de autenticación/autorización para restringir el acceso a la información.

## Utilizando nuestro Forohub
Para realizar las pruebas se utiliza insomina
### Login
![image](https://github.com/user-attachments/assets/d683695c-98c0-496a-b31c-49a6b23d6728)
### Creando un nuevo tópico
En esta prueba, verificamos la autenticación/autorización, debemos usar el token retornado cuando se realiza el login
![image](https://github.com/user-attachments/assets/69d51db4-fbfc-49fd-9cb5-6dbf0e676690)
#### Validación reglas de negocio
![image](https://github.com/user-attachments/assets/a0424699-93f5-4c29-abac-b1f15d825eb6)
### Mostrar todos los tópicos
![image](https://github.com/user-attachments/assets/76330d94-53fe-4c56-926f-03df817bf53f)
### Mostrar un tópico específico
![image](https://github.com/user-attachments/assets/3e3d5e9a-cba5-47a2-acc9-bc99e582d70f)
### Actualizar tópico
#### Validación reglas de negocio
![image](https://github.com/user-attachments/assets/634a5abc-81be-4b3c-af2b-52cb1cf21ccb)

![image](https://github.com/user-attachments/assets/f39bc44b-958f-4843-a99c-6ab0a9ce4373)
### Eliminar tópico
![image](https://github.com/user-attachments/assets/b473ef14-4e92-49d5-ba83-cae86891426e)

Para la documnetación de la API se hace uso de Swagger:
![image](https://github.com/user-attachments/assets/c628f719-aec4-4d82-a9f1-621476808ab5)
