public class Respuestas {
    /*
    ¿Qué ventajas ofrece comentar un código durante su desarrollo?
        R// Comentar un código puede tener varias ventajas y utilidades como mantener el orden en el código,
            poder identificar con facilidad una parte del código y saber que function cumple y facilitar el
            trabajo en equipos grandes.

    CREACION DEL REPOSITORIO EN GIT Y GITHUB

    ¿Qué comandos se usaron para crear el repositorio local en Git?
        R// Para crear el comando primero hay que abrir el Git Bash en la carpeta del proyecto, posteriormente
            se escribe el siguiente comando:

            git init

            Esto inicializará el repositorio en la carpeta, generando una carpeta oculta llamada ".git"
            cabe aclarar que no fue necesario escribir toda la ruta hasta el proyecto gracias a la opcion
            "Open Git Bash Here" que automáticamente abre el editor en la ruta de esa carpeta.

    ¿Qué comandos se usaron para enlazar el repositorio a GitHub?
        R// Antes de usar el comando para enlazar el repositorio a GitHub hay que entrar en la página de GitHub,
            crear una cuenta o iniciar sesion y crear el repositorio, luego hay que regresar a Git Bash y escribir:

            git remote add origin https://github.com/UsuarioGitHub/NombreDelRepositorio.git

            Esto enlazará el repositorio y para agregar los archivos guardados hay que escribir:

            git push -u origin main

            De este modo ya podremos ver los archivos en el repositorio de GitHub.


    ¿Para que sirve el archivo .gitignore?
        R// Este archivo sirve para excluir distintos archivos que no sean deseados, en este caso se excluyen los
        archivos .class y bin/ con el comando:

        touch .gitignore

        Y luego escribiendo el tipo de archivos que no queremos dentro de .gitignore. (Ejemplo: .class o bin/)

    ¿Como se puede trabajar en equipo usando ramas en Git y GitHub?
        R// Las ramas le permiten a distintas personas trabajar en un proyecto a la vez sin interferir entre si, primero
            hay que crear la rama con el comando:

            git checkout -b <RamaEjemplo>

            Ahora ya estamos ubicados en la nueva rama, otro compañero puede crea otra rama y trabajar desde ella para
            subir sus cambios, una vez hecho esto solo hay que hacer el commit y asi se guardarian los cambios desde la
            rama
            */


}
