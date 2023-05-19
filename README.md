# Act2Uf4M06
Act2 ft. Marione
<h1>Descripción del Proyecto:</h1>
El proyecto es una aplicación web que permite mostrar y administrar una lista de estudiantes y cursos.
La aplicación permite ver la lista de estudiantes y cursos existentes, así como agregar nuevos estudiantes y cursos a través de formularios. Los datos se almacenan en una base de datos MySQL y se muestran en pantalla.

<h2>Clase Controllers:</h2>
Esta clase contiene los controladores que manejan las solicitudes HTTP relacionadas con los cursos y estudiantes.

    -Método listarCursos(Model model): Este método maneja la solicitud GET a "/cursos" y recupera todos los cursos del repositorio CursoRepo. Luego, agrega los cursos al modelo y devuelve la vista "lista-cursos" para mostrarlos.

    -Método agregarCurso(String titulo, String descripcion, String url): Este método maneja la solicitud POST a "/cursos-add" y recibe los parámetros del formulario (título, descripción y URL) a través de las anotaciones @RequestParam. Crea un nuevo objeto Curso, establece los valores utilizando los parámetros recibidos y guarda el curso en el repositorio CursoRepo. Finalmente, redirige a la página de listado de cursos ("/cursos").

    -Método listarEstudiantes(Model model): Este método maneja la solicitud GET a "/estudiantes" y recupera todos los estudiantes y cursos del repositorio EstudianteRepo y CursoRepo, respectivamente. Luego, agrega los estudiantes y cursos al modelo y devuelve la vista "lista-estudiantes" para mostrarlos.

    -Método agregarEstudiante(String nombre, String apellido, Long cursoId): Este método maneja la solicitud POST a "/estudiantes-add" y recibe los parámetros del formulario (nombre, apellido y cursoId) a través de las anotaciones @RequestParam. Crea un nuevo objeto Estudiante, establece los valores utilizando los parámetros recibidos y busca el curso correspondiente utilizando el método findById() de CursoRepo. Si se encuentra el curso, se agrega al estudiante y el estudiante se agrega al curso. Luego, el estudiante se guarda en el repositorio EstudianteRepo. Finalmente, redirige a la página de listado de estudiantes ("/estudiantes").

<h2>Archivo HTML de Thymeleaf "lista-cursos.html":</h2>
Este archivo muestra la lista de cursos en una tabla. Utiliza Thymeleaf para iterar sobre la lista de cursos y mostrar los datos en las celdas de la tabla. También incluye un formulario para agregar un nuevo curso.

<h2>Archivo HTML de Thymeleaf "lista-estudiantes.html":</h2>
Este archivo muestra la lista de estudiantes en una tabla. Utiliza Thymeleaf para iterar sobre la lista de estudiantes y mostrar los datos en las celdas de la tabla. Además, muestra los cursos asociados a cada estudiante en una lista desplegable en la columna correspondiente. También incluye un formulario para agregar un nuevo estudiante y seleccionar un curso asociado.
